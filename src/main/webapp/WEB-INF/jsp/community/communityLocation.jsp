<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>已处理数据列表</title>
    <!-- css & js  -->
    <%@ include file="/common/header.jsp" %>
</head>
<body>
<%@ include file="/common/navbar.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=${ak}"></script>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <!-- sidebar -->
        <%--<c:import url="${ctx}/sidebar.html"/>--%>
        <%@ include file="/WEB-INF/jsp/menus/sidebar.jsp" %>
        <!-- main-content -->
        <div class="main-content">
            <div class="page-content">
                <div class="space-6" style="padding-top: 20px"></div>
                <table style="padding-bottom: 20px">
                    <tr>
                        <td> 小区名称:</td>
                        <td><input type="text" id="name" name="name" width="400px" placeholder="输入完整小区名"/></td>
                        <td>
                            <span class="input-group-btn">
                                <button onclick="gridReload()" type="button" class="btn btn-primary btn-sm">
                                  查询
                                  <i class="icon-search icon-on-right bigger-110"></i>
                                </button>
                            </span>
                        </td>
                    </tr>
                </table>
                <br>
                <!-- 表格 -->
                <table id="grid-table"></table>
                <!-- 分页 -->
                <div id="grid-pager"></div>
                <div class="row">
                    <div class="col-xs-12" style="padding-left:5px;" align="center">
                        <div  style="width:1000px;height:500px;border:#ccc solid 1px;font-size:12px;" id="map"></div>
                    </div>
                </div>
            </div>
            <!-- /.page-content -->
        </div><!-- /.main-content -->

        <!-- #ace-settings-container -->
        <%@ include file="/common/settings.jsp" %>
    </div><!-- /.main-container-inner -->

</div><!-- /.main-container -->
<!-- basic scripts -->
<%@ include file="/common/basic-script.jsp" %>
<!-- form scripts -->
<%@ include file="/common/form-script.jsp" %>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    //查询
    function gridReload() {
        var name = jQuery("#name").val() || null;
        //var status = jQuery("#status").val() || null;
        jQuery("#grid-table").jqGrid('setGridParam', {
            url: "${ctx}/community/communityLocationInfoList.json",
            mtype: "post",
            page: 1,
            /*postData: {loanName: loanName, status: status}*/
            postData: {name:name}
        }).trigger("reloadGrid");
    }
    jQuery(function ($) {
        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function (title) {
                var $title = this.options.title || '&nbsp;'
                if (("title_html" in this.options) && this.options.title_html == true)
                    title.html($title);
                else title.text($title);
            }
        }));
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";
        jQuery(grid_selector).jqGrid({
            url: '${ctx}/community/communityLocationInfoList.json',
            datatype: "json",
            mtype: "post",
            height: 330,
            colNames: ['ID', '小区名', '经度', '纬度', '操作'],
            colModel: [
                {
                    name: 'id',
                    index: 'id',
                    width: 50,
                    editable: false
                },
                {
                    name: 'name',
                    index: 'name',
                    width: 50,
                    editable: false
                },
                {
                    name: 'coordinateLng',
                    index: 'coordinateLng',
                    width: 50,
                    editable: false
                },
                {
                    name: 'coordinateLat',
                    index: 'coordinateLat',
                    width: 50,
                    editable: false
                },
                {
                    name: '',
                    index: '',
                    width: 80,
                    fixed: true,
                    sortable: false,
                    formatter: function (value, options, rowObject) {
                        return "<a href=\"javascript: initMap(" + rowObject['coordinateLng'] + "," + rowObject['coordinateLat'] + ",19" + ")\">地图显示</a>";
                    }
                }

            ],

            viewrecords: true,
            rowNum: 10,
            rowList: [5, 10, 15, 20, 50, 200],
            pager: pager_selector,
            altRows: true,
            toppager: false,
            multiselect: true,
            multiboxonly: true,
            loadComplete: function () {
                var table = this;
                setTimeout(function () {
                    styleCheckbox(table);
                    updateActionIcons(table);
                    updatePagerIcons(table);
                    //enableTooltips(table);
                }, 0);
            },

            caption: "小区坐标信息(百度坐标系)",
            autowidth: true
        });
        //enable datepicker
        function pickDate(cellvalue, options, cell) {
            setTimeout(function () {
                $(cell).find('input[type=text]')
                    .datepicker({format: 'yyyy-mm-dd', autoclose: true});
            }, 0);
        }

        // 修改默认按钮功能
        $(grid_selector).jqGrid("navGrid", pager_selector, {
            edit: false,
            editicon: 'icon-pencil blue',
            add: false,
            addicon: 'icon-plus-sign purple',
            del: false,
            delicon: 'icon-trash red',
            search: false,
            searchicon: 'icon-search orange',
            refresh: true,
            refreshtext: "刷新",
            refreshicon: 'icon-refresh green',
            view: false,
            viewicon: 'icon-zoom-in grey',
            alerttext: "请选择一条数据"   // 当未选中任何行而点击编辑、删除、查看按钮时，弹出的提示信息
        }, {// 修改编辑相关的参数
        }, {// 修改添加相关的参数
        }, {// 修改删除相关的参数
        }, {// 修改查询相关的参数
        }, {// 修改查看相关的参数
        });
        /// 对表格式样式进行修改
        //it causes some flicker when reloading or navigating grid
        //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
        //or go back to default browser checkbox styles for the grid
        function styleCheckbox(table) {
        }

        //unlike navButtons icons, action icons in rows seem to be hard-coded
        //you can change them like this in here if you want
        function updateActionIcons(table) {
        }

        //replace icons with FontAwesome icons like above
        function updatePagerIcons(table) {
            var replacement =
                {
                    'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
                    'ui-icon-seek-prev': 'icon-angle-left bigger-140',
                    'ui-icon-seek-next': 'icon-angle-right bigger-140',
                    'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
                };
            $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
                var icon = $(this);
                var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

                if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
            })
        }

        function enableTooltips(table) {
            $('.navtable .ui-pg-button').tooltip({container: 'body'});
            $(table).find('.ui-pg-div').tooltip({container: 'body'});
        }
    });
</script>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(lng, lat, level) {
        //alert(name);
        createMap(lng, lat, level);//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMapOverlay();//向地图添加覆盖物
        if (!(lng == 121.480524 && lat == 31.23595)) {
            /*$("#map").css("display","block");*/
            addMapOverlay(lng, lat);//添加标记
        }
    }
    function createMap(lng, lat, level) {
        map = new BMap.Map("map");
        map.centerAndZoom(new BMap.Point(lng, lat), level);
    }
    function setMapEvent() {
        map.enableScrollWheelZoom();
        map.enableKeyboard();
        map.enableDragging();
        map.enableDoubleClickZoom()
    }
    function addClickHandler(target, window) {
        target.addEventListener("click", function () {
            target.openInfoWindow(window);
        });
    }
    function addMapOverlay() {
    }
    //向地图添加控件
    function addMapControl() {
        var scaleControl = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT});
        scaleControl.setUnit(BMAP_UNIT_IMPERIAL);
        map.addControl(scaleControl);
        var navControl = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_LEFT, type: 1});
        map.addControl(navControl);
        var overviewControl = new BMap.OverviewMapControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, isOpen: true});
        map.addControl(overviewControl);
    }

    function addMapOverlay(lng, lat) {
        var markers = [
            {content: "", title: "", imageOffset: {width: 0, height: 3}, position: {lat: lat, lng: lng}}
        ];
        for (var index = 0; index < markers.length; index++) {
            var point = new BMap.Point(markers[index].position.lng, markers[index].position.lat);
            var marker = new BMap.Marker(point, {
                icon: new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png", new BMap.Size(20, 25), {
                    imageOffset: new BMap.Size(markers[index].imageOffset.width, markers[index].imageOffset.height)
                })
            });
            var label = new BMap.Label(markers[index].title, {offset: new BMap.Size(25, 5)});
            var opts = {
                width: 200,
                title: markers[index].title,
                enableMessage: false
            };
            var infoWindow = new BMap.InfoWindow(markers[index].content, opts);
            marker.setLabel(label);
            addClickHandler(marker, infoWindow);
            map.addOverlay(marker);
        }
        ;
        var labels = [];
        for (var index = 0; index < labels.length; index++) {
            var opt = {position: new BMap.Point(labels[index].position.lng, labels[index].position.lat)};
            var label = new BMap.Label(labels[index].content, opt);
            map.addOverlay(label);
        }
        ;
        var plOpts = [];
        var plPath = [];
        for (var index = 0; index < plOpts.length; index++) {
            var polyline = new BMap.Polyline(plPath[index], plOpts[index]);
            map.addOverlay(polyline);
        }
    }
    var map;
    var lng = 121.480524;
    var lat = 31.23595;
    var level = 12;
    initMap(lng, lat, level);
</script>
</body>
</html>
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
<%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=${ak}"></script>--%>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <!-- sidebar -->
        <c:import url="${ctx}/sidebar.html"/>
        <!-- main-content -->
        <div class="main-content">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <div class="col-xs-12 col-sm-4 widget-container-span">
                                <div class="widget-box">
                                    <div class="widget-header">
                                        <h5> 社区匹配条件 </h5>

                                        <div class="widget-toolbar">
                                            <a href="#" data-action="reload">
                                                <i class="icon-refresh"></i>
                                            </a>

                                            <%--<a href="#" data-action="collapse">
                                                <i class="icon-chevron-up"></i>
                                            </a>
                                            <a href="#" data-action="close">
                                                <i class="icon-remove"></i>
                                            </a>--%>
                                        </div>
                                    </div>

                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <form class="form-horizontal m-t" id="commentForm">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">通勤时间(分钟)：</label>
                                                    <div class="col-sm-8">
                                                        <input id="minCommuteTime" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                                        <input id="maxCommuteTime" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">每平米单价(元)：</label>
                                                    <div class="col-sm-8">
                                                        <input id="minAveragePerPrice" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                                        <input id="maxAveragePerPrice" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label">套内平均面积(平米)：</label>
                                                    <div class="col-sm-8">
                                                        <input id="minAverageArea" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                                        <input id="maxAverageArea" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                    </div>
                                                </div>
                                                <%--<div class="form-group">
                                                    <label class="col-sm-4 control-label">所属区域：</label>
                                                    <div class="col-sm-8">
                                                        <select></select>
                                                        <input id="region" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                                        <input id="regionSecondary" style="display: inline-block;width: 45%" type="email" class="form-control" name="email" required="" aria-required="true">
                                                    </div>
                                                </div>--%>
                                                <div class="form-group">
                                                    <div class="col-sm-4 col-sm-offset-3">
                                                        <button class="btn btn-primary" type="submit">匹配</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-8 widget-container-span">
                                <div class="widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main no-padding">
                                            <table class="table table-striped table-bordered table-hover" id="grid-table">
                                            </table>
                                            <div id="grid-pager"></div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /span -->
                        </div>
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
        var communityName = jQuery("#communityName").val() || null;
        //var status = jQuery("#status").val() || null;
        jQuery("#grid-table").jqGrid('setGridParam', {
            url: "${ctx}/community/communityPriceInfo.json",
            mtype: "post",
            page: 1,
            /*postData: {loanName: loanName, status: status}*/
            postData: {communityName:communityName}
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
            url: '${ctx}/community/communityPriceInfo.json',
            datatype: "json",
            mtype: "post",
            height: 330,
            colNames: ['ID', '小区名','挂牌数量', '每平米均价(元)', '总价均价(万元)','平均建筑面积(平米)', '操作'],
            colModel: [
                {
                    name: 'id',
                    index: 'id',
                    width: 50,
                    editable: false
                },
                {
                    name: 'communityName',
                    index: 'communityName',
                    width: 50,
                    editable: false
                },
                {
                    name: 'number',
                    index: 'number',
                    width: 50,
                    editable: false
                },
                {
                    name: 'averagePerPrice',
                    index: 'averagePerPrice',
                    width: 50,
                    editable: false
                },
                {
                    name: 'averageTotalPrice',
                    index: 'averageTotalPrice',
                    width: 50,
                    editable: false
                },
                {
                    name: 'averageArea',
                    index: 'averageArea',
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
                        /*return "<a href=\"javascript: initMap(" + rowObject['coordinateLng'] + "," + rowObject['coordinateLat'] + ",19" + ")\">地图显示</a>";*/
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

            caption: "匹配结果",
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
</body>
</html>
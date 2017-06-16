<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>数据管理中心</title>
    <!-- css & js  -->
    <%@ include file="/common/header.jsp" %>
    <!-- basic scripts -->
    <%@ include file="/common/basic-script.jsp" %>
</head>

<body>
<%@ include file="/common/navbar.jsp" %>

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
                    <div class="col-xs-12" style="padding-left:5px;">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#Index" role="tab" data-toggle="tab">首页</a></li>
                        </ul>
                        <div class="alert alert-block alert-success">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="icon-remove"></i>
                            </button>

                            <i class="icon-ok green"></i>

                            欢迎使用
                            <strong class="green">
                                房产数据管理系统
                                <small>(v1.0.0)</small>
                            </strong>
                        </div>
                        <div class="space-6"></div>
                        <div>
                            <p style="font-size: 20px">
                                总数据量:${totalDataNum}条
                            </p>
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
<script>
    $(function () {
        $.ajax({
            type: "post",
            url: "${ctx}/index.json",
            data: {},
            success: function (result) {
            },
            error: function (xhr, status, statusText) {
            }
        });
    });
    //加载首页基础数据
    /*jQuery(function($) {
     //override dialog's title function to allow for HTML titles
     $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
     _title: function(title) {
     var $title = this.options.title || '&nbsp;'
     if( ("title_html" in this.options) && this.options.title_html == true )
     title.html($title);
     else title.text($title);
     }
     }));
     var grid_selector = "#grid-table";
     var pager_selector = "#grid-pager";
     jQuery(grid_selector).jqGrid({
     url : '${ctx}/index.json',
     datatype : "json",
     mtype : "post",
     height: 330,
     colNames:['序列','申请编号','借款人','手机', '状态', '创建时间','是否驳回', '操作'],
     colModel:[
     {
     name:'id',
     index:'id',
     width:40,
     editable:true,
     editoptions:{
     size:"20",
     maxlength:"30"
     }
     },
     {
     name:'applyNo',
     index:'applyNo',
     width:90,
     editable:true,
     editoptions:{
     size:"20",
     maxlength:"30"
     }
     },
     {
     name:'loanName',
     index:'loanName',
     width:90,
     editable:true,
     editoptions:{
     size:"20",
     maxlength:"30"
     }
     },
     {
     name:'mobile',
     index:'mobile',
     width:90,
     editable: false
     },
     {
     name:'status',
     index:'status',
     width:50,
     editable: false,
     unformat:function(cellvalue, options, rowObject){
     if(cellvalue == "通过"){
     return 0;
     }else if(cellvalue == "拒绝"){
     return 1;
     }else if(cellvalue == "未审批"){
     return 2;
     }
     return cellvalue;
     },
     formatter:function(cellvalue, options, rowObject){
     if(cellvalue == 0){
     return "通过";
     }else if(cellvalue == 1){
     return "拒绝";
     }else if(cellvalue == 2){
     return "未审批";
     }
     return cellvalue;
     }
     },
     {
     name:'createTime',
     index:'createTime',
     width:80,
     editable:false,
     edittype:"Date",
     formatter: function(value, options, rowObject){
     var date = new Date();
     date.setTime(value);
     return date.Format("yyyy-MM-dd hh:mm:ss");
     }
     },
     {
     name:'isBack',
     index:'isBack',
     width:80,
     editable:false
     },
     {
     name: '',
     index: '',
     width: 80,
     fixed:true,

     sortable:false,
     formatter: function(value, options, rowObject){
     if(rowObject.status == '2'){
     return "<a href=\"javascript: approval("+rowObject['id']+")\">审批</a>";
     }
     return "";
     }
     }
     ],

     viewrecords : true,
     rowNum:10,
     rowList:[5, 10, 15, 20, 50, 200],
     pager : pager_selector,
     altRows: true,
     toppager: false,
     multiselect: true,
     multiboxonly: true,
     loadComplete : function() {
     var table = this;
     setTimeout(function(){
     styleCheckbox(table);
     updateActionIcons(table);
     updatePagerIcons(table);
     //enableTooltips(table);
     }, 0);
     },
     caption: "申请件授信列表",
     autowidth: true
     });
     //enable datepicker
     function pickDate( cellvalue, options, cell ) {
     setTimeout(function(){
     $(cell) .find('input[type=text]')
     .datepicker({format:'yyyy-mm-dd' , autoclose:true});
     }, 0);
     }
     // 修改默认按钮功能
     $(grid_selector).jqGrid("navGrid", pager_selector, {
     edit: false,
     add: false,
     del: false,
     search: false,
     searchicon : 'icon-search orange',
     refresh: true,
     refreshtext:"刷新",
     refreshicon : 'icon-refresh green',
     view: true,
     viewtext:"查看",
     viewicon : 'icon-zoom-in grey',
    <%--viewfunc: function(id){--%>
            <%--window.location = "${ctx }/app/approvalMistinessInfo.html?id="+id;--%>
            <%--}, --%>
     alerttext : "请选择一条数据"   // 当未选中任何行而点击编辑、删除、查看按钮时，弹出的提示信息
     },{// 修改编辑相关的参数
     },{// 修改添加相关的参数
     },{// 修改删除相关的参数
     },{// 修改查询相关的参数
     },{// 修改查看相关的参数
     });
     function styleCheckbox(table) {
     }
     function updateActionIcons(table) {
     }

     //replace icons with FontAwesome icons like above
     function updatePagerIcons(table) {
     var replacement =
     {
     'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
     'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
     'ui-icon-seek-next' : 'icon-angle-right bigger-140',
     'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
     };
     $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
     var icon = $(this);
     var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

     if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
     })
     }

     function enableTooltips(table) {
     $('.navtable .ui-pg-button').tooltip({container:'body'});
     $(table).find('.ui-pg-div').tooltip({container:'body'});
     }
     //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
     });*/
</script>
</body>
</html>
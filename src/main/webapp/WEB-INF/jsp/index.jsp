<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>借款管理系统</title>
    <!-- css & js  -->
    <%@ include file="/common/header.jsp"%>
    <!-- basic scripts -->
    <%@ include file="/common/basic-script.jsp"%>
</head>

<body>
<%@ include file="/common/navbar.jsp"%>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <!-- sidebar -->
        <c:import url="/sidebar.html" />

        <!-- main-content -->
        <div class="main-content">
            <%--<div class="breadcrumbs" id="breadcrumbs" style="display: none;">--%>
                <%--<script type="text/javascript">--%>
                    <%--try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}--%>
                <%--</script>--%>

                <%--<ul class="breadcrumb">--%>
                    <%--<li>--%>
                        <%--<i class="icon-home home-icon"></i>--%>
                        <%--<a href="${ctx}/index.html">首页</a>--%>
                    <%--</li>--%>
                    <%--<li class="active">控制台</li>--%>
                <%--</ul><!-- .breadcrumb -->--%>

                <%--<!-- nav-search -->--%>
                <%--<%@ include file="/common/search.jsp"%>--%>
            <%--</div>--%>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12" style="padding-left:5px;">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#Index" role="tab" data-toggle="tab">首页</a></li>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="Index">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- /.page-content -->
        </div><!-- /.main-content -->

        <!-- #ace-settings-container -->
        <%@ include file="/common/settings.jsp"%>
    </div><!-- /.main-container-inner -->

</div><!-- /.main-container -->


<!-- inline scripts related to this page -->

</body>
</html>
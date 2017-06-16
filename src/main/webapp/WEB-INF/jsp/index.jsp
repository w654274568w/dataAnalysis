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
</script>
</body>
</html>
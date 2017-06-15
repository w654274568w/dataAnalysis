<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>用户管理列表</title>
  <!-- css & js  -->
</head>
<body>
<%@ include file="/common/navbar.jsp"%>

<div class="main-container" id="main-container">
  <input id="file0" name="file0" type="file" class="file" />
</div><!-- /.main-container -->

<!-- basic scripts -->
<!-- basic scripts -->
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/ajaxfileupload.js"></script>
<!-- inline scripts related to this page -->

<script type="text/javascript">
  $('#file0').change(function(){
    ajaxFileUpload();
  });

  //upload file
  function ajaxFileUpload(){
    $.ajaxFileUpload({
      url:'${ctx}/uploadAppFile.json',
      secureuri:false,
      fileElementId:'file0',
      data:{appId: 44, fileType: 1},
      dataType: 'text',
      success: function(data,status){
        console.log(data)
      },
      error: function(data,status,e){
        console.log(data);
        console.log(status);
        $('#file0').change(function(){
          ajaxFileUpload();
        });
      }
    });
    return false;
  }
</script>

</body>
</html>


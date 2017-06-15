<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!--[if !IE]> -->

<script src="${ctx}/assets/js/jquery-2.0.3.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${ctx}/assets/js/jquery-1.10.2.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
  window.jQuery || document.write("<script src='${ctx }/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='${ctx }/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
  if("ontouchend" in document) document.write("<script src='${ctx }/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${ctx }/assets/js/bootstrap.min.js"></script>
<script src="${ctx }/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx }/assets/js/typeahead-bs2.min.js"></script>
<script src="${ctx }/assets/my97/WdatePicker.js"></script>

<!-- page specific plugin scripts -->

<script src="${ctx }/assets/js/jquery-ui-1.10.3.full.min.js"></script>
<script src="${ctx }/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx }/assets/js/bootbox.min.js"></script>
<script src="${ctx }/assets/js/jquery.toastmessage.js"></script>

<!-- ace scripts -->

<script src="${ctx }/assets/js/ace-elements.min.js"></script>
<script src="${ctx }/assets/js/ace.min.js"></script>
<script src="${ctx }/assets/js/ace-extra.min.js"></script>

<script src="${ctx }/js/spin.min.js"></script>
<script src="${ctx }/js/jquery.spin.js"></script>

<!-- common -->
<script src="${ctx }/js/common.js"></script>

<!-- basic scripts -->


<!-- page specific plugin scripts -->

<script src="${ctx }/assets/js/fuelux/fuelux.wizard.min.js"></script>
<script src="${ctx }/assets/js/jquery.validate.min.js"></script>
<script src="${ctx }/assets/js/additional-methods.min.js"></script>
<script src="${ctx }/assets/js/jquery.maskedinput.min.js"></script>
<script src="${ctx }/assets/js/select2.min.js"></script>
<script>
$(document).ready(function(){
  $.ajaxSetup({
    complete: function(xmlHttp) {
      if(xmlHttp.status==403){
        location.href="${ctx }/403"; //跳转到登录页面
      }
    }
  });
});
</script>
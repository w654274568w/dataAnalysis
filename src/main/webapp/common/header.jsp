<%@ include file="/common/meta.jsp" %>

<!-- basic styles -->
<link type="image/x-icon" rel="shortcut icon" href="${ctx }/favicon.ico" />
<link href="${ctx }/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx }/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
<link rel="stylesheet" href="${ctx }/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->

<link rel="stylesheet" href="${ctx }/assets/css/jquery-ui-1.10.3.full.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/datepicker.css" />
<link rel="stylesheet" href="${ctx }/assets/css/datepicker.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ui.jqgrid.css" />

<!-- fonts -->

<link rel="stylesheet" href="${ctx }/assets/css/google-fonts.css" />

<!-- ace styles -->

<link rel="stylesheet" href="${ctx }/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/jquery.toastmessage.css" />
<link rel="stylesheet" href="${ctx}/css/common.css" />

<!--[if lte IE 8]>
<link rel="stylesheet" href="${ctx }/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="${ctx }/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="${ctx }/assets/js/html5shiv.js"></script>
<script src="${ctx }/assets/js/respond.min.js"></script>
<![endif]-->

<script src="${ctx }/js/dim.js"></script>
<script type="text/javascript">
    var ctx = "${ctx}";
    /**
     * 查询标的余额和企业余额
     * @param projectId
     * @param companyType
     * @returns {String}
     */
    function queryBalance(projectId,companyType){
        var msg = "";
        $.ajax({
            url:"${ctx}/queryBalance.html",
            type:"post",
            data:{projectId:projectId,companyType:companyType},
            async:false,
            success:function(data){
                msg = data;
            }
        });
        return msg;

    }
     function queryPaymentsBalance(projectId){
			var msg = "";
	        $.ajax({
	            url:"${ctx}/PaymentsBalance/confirmInfo.html",
	            type:"post",
	            data:{projectId:projectId},
	            async:false,
	            success:function(data){
	                msg = data;
	            }
	        });
	        return msg;
		}
</script>

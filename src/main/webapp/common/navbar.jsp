<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp"%>
<div class="navbar navbar-default" id="navbar">
  <script type="text/javascript">
    try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    function retSetPassWord(){
      bootbox.dialog({
        message:  "    <div >"
                    +"    <label class='col-sm-3 control-label no-padding-right' for='oldPassword'> 旧密码 </label>"
                    +"    <div class='col-sm-9'>"
                    +"    <div class='clearfix'>"
                    +"    <input type='password' id='oldPassword' name='oldPassword' placeholder='旧密码' class='col-xs-10 col-sm-8' />"
                    +"     </div>"
                    +"    </div>"
                    +"   </div>"
                    +"<div >"
                +"<label class='col-sm-3 control-label no-padding-right' for='userPassword'> 新密码 </label>"
                  +" <div class='col-sm-9'>"
                  +"  <div class='clearfix'>"
                  +"   <input type='password' id='userPassword' name='userPassword' placeholder='新密码' class='col-xs-10 col-sm-8' />"
                  +"     </div>"
                  +"     </div>"
                  +"     </div>"
                  +"    <div >"
                  +"    <label class='col-sm-3 control-label no-padding-right' for='userPassword2'> 新密码确认 </label>"
                  +"    <div class='col-sm-9'>"
                  +"    <div class='clearfix'>"
                    +"    <input type='password' id='userPassword2' name='userPassword2' placeholder='新密码确认' class='col-xs-10 col-sm-8' />"
            +"     </div>"
          +"    </div>"
        +"   </div>",
        title: "修改密码",
        buttons: {
          Cancel: {
            label: "取消",
            className: "btn-default",
            callback: function () {
              this.close();
            }
          }
          , OK: {
            label: "确认",
            className: "btn-primary",
            callback: function () {
              var oldPd =$("#oldPassword").val();
              var newPd =$("#userPassword").val();
              var newPd2 =$("#userPassword2").val();
              if($.trim(oldPd) == "" || $.trim(newPd) == "" || $.trim(newPd2) == "" ){
                bootbox.alert("密码不能为空");
                return false;
              }
              if($.trim(newPd) != $.trim(newPd2)){
                bootbox.alert("两次新密码不相同！");
                return false;
              }
              $.post("${ctx}/updatePassword",{oldPd:$.trim(oldPd),newPd:$.trim(newPd)},function(msg){
                if(msg.code == 200){
                  bootbox.alert({
                    buttons: {
                      ok: {
                        label: '确定',
                        className: 'btn-myStyle'
                      }
                    },
                    message: '修改成功，请重新登录！',
                    callback: function() {
                      window.location.href="<c:url value='/logout' />";
                    },
                    title: "提示信息"
                  });
                }else{
                  bootbox.alert(msg.msg);
                }
              },"json");
              return false;
            }
          }
        }
      });
    }
    function reloadResource(){
    	$.get("${ctx}/reloadRelationMap", {}, function (){
    		window.location.href = window.location.href;
    	})
    }
  </script>

  <div class="navbar-container" id="navbar-container">
    <div class="navbar-header pull-left">
      <a href="${ctx}" class="navbar-brand">
        <small>
          房产数据管理系统
        </small>
      </a><!-- /.brand -->
    </div><!-- /.navbar-header -->

    <div class="navbar-header pull-right" role="navigation">
      <%--<ul class="nav ace-nav">
        <li class="light-blue">
          <a data-toggle="dropdown" href="#" class="dropdown-toggle">
            <img class="nav-user-photo" src="${ctx}/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									<sec:authentication property="principal.fullname"/>
								</span>

            <i class="icon-caret-down"></i>
          </a>

          <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
            <!-- <li>
              <a href="#">
                <i class="icon-cog"></i>
                设置
              </a>
            </li>

            <li>
              <a href="#">
                <i class="icon-user"></i>
                个人资料
              </a>
            </li>

            <li class="divider"></li> -->
            <li>
              <a href="javascript:retSetPassWord()">
                <i class="icon-cog"></i>
                修改密码
              </a>
            </li>
            <li>
              <a href="<c:url value='/logout' />">
                <i class="icon-off"></i>
                退出
              </a>
            </li>
          </ul>
        </li>
      </ul>--%><!-- /.ace-nav -->
    </div><!-- /.navbar-header -->
  </div><!-- /.container -->
</div>
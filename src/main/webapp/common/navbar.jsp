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
          <img src="${ctx}/assets/images/logo@2x.png" />
          借款管理系统
        </small>
      </a><!-- /.brand -->
    </div><!-- /.navbar-header -->

    <div class="navbar-header pull-right" role="navigation">
      <ul class="nav ace-nav">
       <%--  <li class="grey">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <i class="icon-tasks"></i>
            <span class="badge badge-grey">4</span>
          </a>

          <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
            <li class="dropdown-header">
              <i class="icon-ok"></i>
              还有4个任务完成
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
                  <span class="pull-left">软件更新</span>
                  <span class="pull-right">65%</span>
                </div>

                <div class="progress progress-mini ">
                  <div style="width:65%" class="progress-bar "></div>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
                  <span class="pull-left">硬件更新</span>
                  <span class="pull-right">35%</span>
                </div>

                <div class="progress progress-mini ">
                  <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
                  <span class="pull-left">单元测试</span>
                  <span class="pull-right">15%</span>
                </div>

                <div class="progress progress-mini ">
                  <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
                  <span class="pull-left">错误修复</span>
                  <span class="pull-right">90%</span>
                </div>

                <div class="progress progress-mini progress-striped active">
                  <div style="width:90%" class="progress-bar progress-bar-success"></div>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                查看任务详情
                <i class="icon-arrow-right"></i>
              </a>
            </li>
          </ul>
        </li>

        <li class="purple">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <i class="icon-bell-alt icon-animated-bell"></i>
            <span class="badge badge-important">8</span>
          </a>

          <ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
            <li class="dropdown-header">
              <i class="icon-warning-sign"></i>
              8条通知
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												新闻评论
											</span>
                  <span class="pull-right badge badge-info">+12</span>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                <i class="btn btn-xs btn-primary icon-user"></i>
                切换为编辑登录..
              </a>
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												新订单
											</span>
                  <span class="pull-right badge badge-success">+8</span>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                <div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												粉丝
											</span>
                  <span class="pull-right badge badge-info">+11</span>
                </div>
              </a>
            </li>

            <li>
              <a href="#">
                查看所有通知
                <i class="icon-arrow-right"></i>
              </a>
            </li>
          </ul>
        </li>

        <li class="green">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <i class="icon-envelope icon-animated-vertical"></i>
            <span class="badge badge-success">5</span>
          </a>

          <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
            <li class="dropdown-header">
              <i class="icon-envelope-alt"></i>
              5条消息
            </li>

            <li>
              <a href="#">
                <img src="${ctx}/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												不知道写啥 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>1分钟以前</span>
											</span>
										</span>
              </a>
            </li>

            <li>
              <a href="#">
                <img src="${ctx}/assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												不知道翻译...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20分钟以前</span>
											</span>
										</span>
              </a>
            </li>

            <li>
              <a href="#">
                <img src="${ctx}/assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												到底是不是英文 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>下午3:15</span>
											</span>
										</span>
              </a>
            </li>

            <li>
              <a href="inbox.html">
                查看所有消息
                <i class="icon-arrow-right"></i>
              </a>
            </li>
          </ul>
        </li> --%>

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
      </ul><!-- /.ace-nav -->
    </div><!-- /.navbar-header -->
  </div><!-- /.container -->
</div>
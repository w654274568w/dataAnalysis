<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="/common/config.jsp" %>
<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text"></span>
</a>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>
            <span class="btn btn-info"></span>
            <span class="btn btn-warning"></span>
            <span class="btn btn-danger"></span>
        </div>
    </div><!-- #sidebar-shortcuts -->
    <ul class="nav nav-list">
        <li>
            <a href="${ctx}/index.html">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 首页 </span>
            </a>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 手动数据分析 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="${ctx}/analysis/dataCountByDate.html">
                        <i class="icon-double-angle-right"></i>
                        原始数据解析
                    </a>
                </li>
                <li>
                    <a href="buttons.html">
                        <i class="icon-double-angle-right"></i>
                        按区域解析
                    </a>
                </li>
                <li>
                    <a href="treeview.html">
                        <i class="icon-double-angle-right"></i>
                        树菜单
                    </a>
                </li>
                <li>
                    <a href="jquery-ui.html">
                        <i class="icon-double-angle-right"></i>
                        jQuery UI
                    </a>
                </li>
                <li>
                    <a href="nestable-list.html">
                        <i class="icon-double-angle-right"></i>
                        可拖拽列表
                    </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-double-angle-right"></i>
                        三级菜单
                    </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-desktop"></i>
                <span class="menu-text"> 手动数据分析 </span>
                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li>
                    <a href="elements.html">
                        <i class="icon-double-angle-right"></i>
                        组件
                    </a>
                </li>
                <li>
                    <a href="buttons.html">
                        <i class="icon-double-angle-right"></i>
                        按钮 &amp; 图表
                    </a>
                </li>
                <li>
                    <a href="treeview.html">
                        <i class="icon-double-angle-right"></i>
                        树菜单
                    </a>
                </li>
                <li>
                    <a href="jquery-ui.html">
                        <i class="icon-double-angle-right"></i>
                        jQuery UI
                    </a>
                </li>
                <li>
                    <a href="nestable-list.html">
                        <i class="icon-double-angle-right"></i>
                        可拖拽列表
                    </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-double-angle-right"></i>
                        三级菜单
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="#">
                                <i class="icon-leaf"></i>
                                第一级
                            </a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle">
                                <i class="icon-pencil"></i>
                                第四级
                                <b class="arrow icon-angle-down"></b>
                            </a>
                            <ul class="submenu">
                                <li>
                                    <a href="#">
                                        <i class="icon-plus"></i>
                                        添加产品
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="icon-eye-open"></i>
                                        查看商品
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
    <!-- /.nav-list -->
    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }

        var addTabs = function (options) {
            var url = '${ctx}' + options.url;
            options.url = url;
            id = "tab_" + options.id;
            $(".active").removeClass("active");
            closeTab(id);
            //如果TAB不存在，创建一个新的TAB
            if (!$("#" + id)[0]) {
                //固定TAB中IFRAME高度
                mainHeight = document.documentElement.clientHeight - 130;
                //创建新TAB的title
                title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
                //是否允许关闭
                if (options.close) {
                    title += ' <i class="glyphicon glyphicon-remove icon-remove" style="cursor:pointer;" tabclose="' + id + '"></i>';
                }
                title += '</a></li>';     //是否指定TAB内容
                if (options.content) {
                    content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
                } else {
                    //没有内容，使用IFRAME打开链接
                    content = '<div role="tabpanel" ' +
                            'style="overflow :auto;height:' + mainHeight + 'px;"' +
                            ' class="tab-pane" id="' + id + '"><iframe src="' + options.url + '"  ' +
                            'style="height:' + (mainHeight - 10) + 'px;width:100%;"' +
                            ' frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes" onLoad="iFrameHeight(this)"></iframe></div>';
                }
                //加入TABS
                $(".nav-tabs").append(title);
                $(".tab-content").append(content);
            }
            //激活TAB
            $("#tab_" + id).addClass('active');
            $("#" + id).addClass("active");

            $(".glyphicon-remove").unbind("click");
            $(".glyphicon-remove").on("click", function () {
                closeTab($(this).attr("tabclose"));
            });
        };
        var closeTab = function (id) {
            //如果关闭的是当前激活的TAB，激活他的前一个TAB
            if ($("li.active").attr('id') == "tab_" + id) {
                $("#tab_" + id).prev().addClass('active');
                $("#" + id).prev().addClass('active');
            }
            //关闭TAB
            $("#tab_" + id).remove();
            $("#" + id).remove();
        };
        $(function () {
            mainHeight = $(document.body).height() - 45;
            $('.main-left,.main-right').height(mainHeight);
            $("[addtabs]").click(function () {
                addTabs({id: $(this).attr("id"), title: $(this).attr('title'), close: true});
            });
            $(".nav-tabs").on("click", "[tabclose]", function (e) {
                id = $(this).attr("tabclose");
                closeTab(id);
            });
        });

        function iFrameHeight(ifm) {
            var subWeb = ifm.contentDocument;
            if (ifm != null && subWeb != null) {
                ifm.height = subWeb.body.scrollHeight;
                ifm.width = subWeb.body.scrollWidth;
            }
        }
    </script>
</div>
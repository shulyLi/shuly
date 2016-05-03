<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <!-- Logo -->
    <a href="/index.jsp" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>跟</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b></b>跟</span>
    </a>
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id = "userInfo">
                        <!-- The user image in the navbar-->
                        <img src="/upload/head/default_head.jpg" class="user-image UserPIC" alt="User Image">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs" id = "username2">Alexander Pierce</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header">
                            <img src="/upload/head/default_head.jpg" class="img-circle UserPIC" alt="User Image">
                            <p>
                                Web Developr
                                <small id="create_time"></small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat" id ="userDetail">个人信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat" id ="logout">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li id ="whatTheFuckerSay">
                    <a href="#">
                        <span></span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>

</header>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/upload/head/default_head.jpg" class="img-circle UserPIC" alt="User Image">
            </div>
            <div class="pull-left info">
                <p id = 'username1'>Alexander Pierce</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">HEADER</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i>
                    <span>商品</span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/index.jsp"><i class="fa fa-circle-o"></i> 查找展示</a></li>
                    <li class="TRADER"><a href="/html/good/addGood.jsp"><i class="fa fa-circle-o"></i> 添加商品</a></li>
                    <li class="LOGINNEED    "><a  id ='gradeNum '  href="/html/good/LeverGood.jsp"><i class="fa fa-circle-o"></i> 我所能评价的商品</a></li>
                    <li class="TRADER"><a href="/html/good/GoodManage.jsp"><i class="fa fa-circle-o"></i> 管理我的商品</a></li>
                    <li class="ADMIN"><a href="/html/good/ManageGood.jsp"><i class="fa fa-circle-o"></i> 管理所有的商品</a></li>
                </ul>
            </li >
            <li class="treeview LOGINNEED">
                <a href="mailbox.html ">
                    <i class="fa fa-envelope"></i> <span>Mailbox</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a id ='mailNum' href="/html/Mail/mail.jsp">信箱 </a></li>
                </ul>
            </li>
            <li class="treeview LOGINNEED">
                <a href="#"><i class="fa fa-link"></i>
                    <span>协议</span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/html/deal/fromMeDealManage.jsp"><i class="fa fa-circle-o"></i>我发的协议</a></li>
                    <li class="TRADER"><a href="/html/deal/toMeDealManage.jsp"><i class="fa fa-circle-o"></i>给我的协议</a></li>
                    <li class="ADMIN"><a href="/html/deal/allDeal.jsp"><i class="fa fa-circle-o"></i>所有的协议</a></li>
                </ul>
            </li >
        </ul><!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>

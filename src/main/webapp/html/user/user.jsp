<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-3-28
  Time: 上午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@include file="/head.jsp"%>
<div class="wrapper">
    <%@include file="/meue.jsp"%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                User Profile
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Examples</a></li>
                <li class="active">User profile</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div id ="user" class="col-md-3">
                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img id ='user_pic' class="profile-user-img img-responsive img-circle" src="" alt="User profile picture">
                            <h3 id = 'user_name'class="profile-username text-center"></h3>
                            <p class="text-muted text-center">梦幻的道路没有远方</p>
                            <ul id="mainInfo" class="list-group list-group-unbordered">
                            </ul>
                            <!--
                            <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
                            -->
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->

                    <!-- About Me Box -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">信息</h3>
                        </div><!-- /.box-header -->
                        <div id = 'userMoreInfo'class="box-body">

                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col -->

                <div id='OP' class="col-md-9">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#timeline" data-toggle="tab">Timeline</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="timeline">
                                <!-- The timeline -->
                                <ul id ="opBoday"  class="timeline timeline-inverse">
                                    <!-- timeline time label -->
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                </ul>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- /.nav-tabs-custom -->
                </div><!-- /.col -->
            </div><!-- /.row -->

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>

<script src="/js/user.js" ></script>
<script>
    inint();
</script>
<!-- AdminLTE for demo purposes -->
<!-- page script -->
<!-- Page script -->

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>



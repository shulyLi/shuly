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
            <h1>商品
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Mailbox</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-sm-12">
                    <!-- Box Comment -->
                    <div class="box box-widget">
                        <div class='box-header with-border'>

                            <div id = 'goodOwner' class='user-block'>
                                <img class='img-circle' src='/upload/head/default_head.jpg' alt='user image'>
                                <span class='username'><a href="#">"    "</a></span>
                                <span class='description'>商品主</span>
                            </div><!-- /.user-block -->

                            <div class='box-tools'>
                                <button class='btn btn-box-tool' data-toggle='tooltip' title='Mark as read'><i class='fa fa-circle-o'></i></button>
                                <button class='btn btn-box-tool' data-widget='collapse'><i class='fa fa-minus'></i></button>
                                <button class='btn btn-box-tool' data-widget='remove'><i class='fa fa-times'></i></button>
                            </div><!-- /.box-tools -->

                        </div><!-- /.box-header -->
                        <div class='box-body'>

                            <div class="col-sm-6">
                                <div class="box box-widget">
                                    <div class='box-body'>
                                        <img id ="goodPic" class="img-responsive center-block" src="" alt="Photo">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">

                                <div class="box box-widget">
                                    <div class="box-body box-profile">
                                        <h3 id = "goodName" class="profile-username text-center"></h3>
                                        <p  id = "goodTag" class="text-muted text-center"></p>
                                        <ul class="list-group list-group-unbordered">
                                            <li id = "ownerPoint"class="list-group-item">
                                                <b>店主评分</b> <a class="pull-right"></a>
                                            </li>
                                            <li id = "goodJudge" class="list-group-item">
                                                <b>商品评分</b> <a class="pull-right"></a>
                                            </li>
                                            <li id ="goodPlace" class="list-group-item">
                                                <b>原产地</b> <a class="pull-right"></a>
                                            </li>
                                            <li id ="goodNum" class="list-group-item">
                                                <b>库存</b> <a class="pull-right"></a>
                                            </li>
                                            <li id ="goodPrice" class="list-group-item">
                                                <b>价格</b> <a class="pull-right"></a>
                                            </li>
                                            <li class="list-group-item col-sm-12">
                                                <div class="col-sm-5">
                                                    <a class="btn btn-block btn-social btn-success">
                                                        <i class="fa  fa-heart"></i> 添加到
                                                    </a>
                                                </div>
                                                <div class="col-sm-5 col-sm-offset-1">
                                                    <a id = "dealButten" class="btn btn-block btn-social btn-danger "  data-toggle="modal" data-target="#dealModle">
                                                        <i class="fa fa-shopping-cart"></i> 填写订单
                                                    </a>
                                                </div>
                                            </li>
                                        </ul>
                                    </div><!-- /.box-body -->

                                </div>
                            </div>
                            <!-- Social sharing buttons -->
                        </div><!-- /.box-body -->
                        <div class="box-footer  box-comments" id = "comments">

                        </div><!-- /.box-footer -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->

    </div><!-- /.content-wrapper -->
    <div class="content-wrapper">
        <!-- Main content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/foot.jsp"%>
    <%@include file="/html/modle/dealModle.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>
<script src="/js/showGood.js"></script>
<script src="/js/area.js"></script>
<script>
    _init_area();
    $(".select2").select2();
    goodDetailInit();
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



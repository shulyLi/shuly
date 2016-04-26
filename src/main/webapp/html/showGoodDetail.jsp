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
                <div class="col-md-12">
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
                                        <img class="img-responsive img-rounded" src="/upload/pic/11461562178930ri43y大金星山楂.jpg" alt="Photo">
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6">

                                <div class="box box-widget">
                                    <div class="box-body box-profile">
                                        <h3 class="profile-username text-center">山楂</h3>
                                        <p class="text-muted text-center">从济南到临沂，让你真心的喜欢</p>
                                        <ul class="list-group list-group-unbordered">
                                            <li class="list-group-item">
                                                <b>掌柜的信誉评分</b> <a class="pull-right">50</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>商品评分</b> <a class="pull-right">50</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>原产地</b> <a class="pull-right">山东省 临沂市 兰山区</a>
                                            </li>

                                            <li class="list-group-item">
                                                <b>库存</b> <a class="pull-right">20 kg</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>价格</b> <a class="pull-right">20¥</a>
                                            </li>
                                            <li class="list-group-item col-md-12">
                                                <div class="col-md-5">
                                                    <a class="btn btn-block btn-social btn-success">
                                                        <i class="fa  fa-heart"></i> 收藏
                                                    </a>
                                                </div>
                                                <div class="col-md-5 col-md-offset-1">
                                                    <a class="btn btn-block btn-social btn-danger">
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
                        <div class="box-footer">
                            <button class='btn btn-default btn-xs'><i class='fa fa-thumbs-o-up'></i> Like</button>
                            <span class='pull-right text-muted'>45 likes </span>
                        </div>

                        <div class='box-footer'>
                            <form action="#" method="post">
                                <img class="img-responsive img-circle img-sm" src="../dist/img/user4-128x128.jpg" alt="alt text">
                                <!-- .img-push is used to add margin to elements next to floating images -->
                                <div class="img-push">
                                    <input type="text" class="form-control input-sm" placeholder="Press enter to post comment">
                                </div>
                            </form>
                        </div><!-- /.box-footer -->
                        <div class="box-footer  box-comments">
                            <div class='box-comment'>
                                <!-- User image -->
                                <img class='img-circle img-sm' src='../dist/img/user3-128x128.jpg' alt='user image'>
                                <div class='comment-text'>
                                    <span class="username">
                                        天空之城
                                        <span class='text-muted pull-right'>8:03 PM Today</span>
                                    </span><!-- /.username -->
                                       呵呵哒
                                </div><!-- /.comment-text -->
                            </div><!-- /.box-comment -->
                            <div class='box-comment'>
                                <!-- User image -->
                                <img class='img-circle img-sm' src='../dist/img/user5-128x128.jpg' alt='user image'>
                                <div class='comment-text'>
                                  <span class="username">
                                    admin
                                    <span class='text-muted pull-right'>8:03 PM Today</span>
                                  </span><!-- /.username -->
                                    感谢您的支持，感谢您和我们一起见证小堡的辉煌，我们将不断完善，争取做的更好，回报您的厚爱，小堡欢迎您的再次光临！
                                </div><!-- /.comment-text -->
                            </div><!-- /.box-comment -->
                        </div><!-- /.box-footer -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>
<script src="/js/showGood.js"></script>
<script>
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



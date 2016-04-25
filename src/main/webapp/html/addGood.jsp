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
                Fixed Layout
                <small>Blank example to the fixed layout</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Layout</a></li>
                <li class="active">Fixed</li>
            </ol>
        </section>
        <!-- Main content --  -->
        <section class="content" >
            <div class ='row'>
                <div class ="col-sm-10 col-sm-offset-1">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Quick Example</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form  role="form" enctype="multipart/form-data" method="post" action = "/key/good/add">
                            <div class="box-body">
                                <div class="form-group col-sm-6">
                                    <label for="name" >货物名称</label>
                                    <input type="text" class="form-control" id="name" name = 'name' placeholder="输入">
                                </div>
                                <div class="form-group col-sm-6">
                                    <label for="name" >简短描述</label>
                                    <input type="text" class="form-control" id="shortMes" name = 'shortMes' placeholder="输入">
                                </div>
                                <div class="form-group col-sm-12">
                                    <label for="describe">长篇描述</label>
                                    <textarea class="form-control" rows="4" id = "describe" name="describe" placeholder="输入"></textarea>
                                </div>

                                <div class="form-group col-sm-3" >
                                    <label>原产地国家</label>
                                    <select class="form-control" disabled="disabled" style="width: 100%;">
                                        <option selected="selected">中国</option>

                                    </select>
                                </div>

                                <div class="form-group col-sm-3" >
                                    <label>省份</label>
                                    <select class="form-control select2" id ="s_province" name="s_province" style="width: 100%;">
                                    </select>
                                </div>
                                <div class="form-group col-sm-3">
                                    <label>地级市</label>
                                    <select class="form-control select2" id="s_city" name='s_city' style="width: 100%;">
                                    </select>
                                </div>
                                <div class="form-group col-sm-3" >
                                    <label>市、县级市</label>
                                    <select class="form-control select2" id="s_county" name="s_county" style="width: 100%;">
                                    </select>
                                </div>
                                <div class="form-group col-sm-12">
                                    <label for="pic">File input</label>
                                    <input type="file" id="pic" name="pic">
                                    <p class="help-block">图片格式PNG和JPG</p>
                                </div>

                            </div><!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div><!-- /.box -->
                </div>

                <div class ="col-sm-5 col-sm-offset-3">


                </div>
            </div>
        </section>
    </div><!-- /.content-wrapper -->
    <!-- Main Footer -->
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->
    <!-- REQUIRED JS SCRIPTS -->
    <%@include file="/js.jsp"%>
<script src="/js/area.js"></script>
<script>
    _init_area();
    $(".select2").select2();

</script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>



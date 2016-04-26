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
            商品展示
            <small>buling</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Layout</a></li>
            <li class="active">Fixed</li>
          </ol>
        </section>

        <!-- Main content --  -->
        <section class="content">
          <div class="box">
            <div class="box-header with-border">
              <div class="box-tools pull-right">
                <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
                <button class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="input-group col-sm-6 col-sm-offset-3">
                <input type="text" class="form-control" id ="findData" name = "findData">
                <div class="input-group-btn">
                  <button type="button" class="btn btn-danger " id = "find"><a class = "fa fa-search"></a></button>
                </div><!-- /btn-group -->
              </div>
            </div><!-- /.box-body -->
            <div class="box-footer">
              <form class="form-horizontal">
                <div class="form-group">
                  <label for="s_province" class="col-sm-1 control-label">省份</label>
                  <div class ="col-sm-11">
                    <select class=" form-control select2" multiple="multiple" data-placeholder="Select a State" style="width: 100%;" id ="s_province" name="province">

                    </select>
                  </div>
                </div><!-- /.form-group -->
              </form>
            </div><!-- /.box-footer-->
          </div><!-- /.box -->
          <div id="graF">

          </div>
        </section>


      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <%@include file="/foot.jsp"%>
    </div><!-- ./wrapper -->

    <!-- REQUIRED JS SCRIPTS -->
    <%@include file="/js.jsp"%>
    <script src="/js/show.js"></script>
    <script src="/js/area.js"></script>
    <script>
      _initShow();
      _init_province();
      $(".select2").select2();
    </script>
    <!-- Optionally, you can add Slimscroll and FastClick plugins.
         Both of these plugins are recommended to enhance the
         user experience. Slimscroll is required when using the
         fixed layout. -->
  </body>
</html>

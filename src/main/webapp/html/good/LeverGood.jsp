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
                可留言表格
                <small>hehda</small>
            </h1>
        </section>
        <!-- Main content --  -->
        <section class="content" >
            <row>
                <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Data Table With Full Features</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <row>
                        <table id="dataTable" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th data-field="goodName">商品名字</th>
                                <th data-field="isRight">评价情况</th>
                                <th data-field="lever">评价等级</th>
                                <th data-field="msg">评价信息</th>
                                <th data-field="create_time">时间</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                            <tfoot>
                            </tfoot>
                        </table>
                    </row>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
            </row>
        </section>
    </div><!-- /.content-wrapper -->

    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>
<%@include file="/html/modle/leaveModle.jsp"%>
<script src="/js/leave.js" ></script>
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
<style type="text/css">
table.dataTable tbody tr.selected {
    background-color: #B0BED9;
}
</style>
</html>



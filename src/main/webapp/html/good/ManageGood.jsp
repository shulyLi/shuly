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
                GoodManager
                <small>hehda</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Layout</a></li>
                <li class="active">Fixed</li>
            </ol>
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
                                <th data-field="goodname">商品名字</th>
                                <th data-field="place">源产地</th>
                                <th data-field="place">状态</th>
                                <th data-field="price">单位价钱</th>
                                <th data-field="number">库存</th>
                                <th data-field="point">评分</th>
                                <th data-field="tradeNum">交易次数</th>
                                <th data-field="judge">评价情况</th>
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
    <%@include file="/html/modle/MangerGoodModle.jsp"%>
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>

<script src="/js/manageGood.js" ></script>
<script>
    inint("/key/good/allGood.json")
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



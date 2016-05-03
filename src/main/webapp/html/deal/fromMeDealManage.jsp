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
                dealManager
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

            <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#fromMydeal" data-toggle="tab">我发出的协议</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="fromMydeal">
                        <table id="fromDealTable" class="table">
                            <thead>
                                <th data-field="goodName">商品名字</th>
                                <th data-field="goodNum">数量</th>
                                <th data-field="goodPrice">商品价格</th>
                                <th data-field="goodState">目前状态</th>
                                <th data-field="create_time">创建的时间</th>
                            </thead>
                            <tbody>

                            </tbody>

                            <tfoot>
                            </tfoot>
                        </table>
                    </div>

                </div><!-- /.tab-content -->
            </div><!-- /.nav-tabs-custom -->
        </section>
    </div><!-- /.content-wrapper -->
    <%@include file="/html/modle/showDealModle.jsp"%>
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<%@include file="/js.jsp"%>
<script src="/js/manageDeal.js" ></script>
<script>
    initFromDeal();
</script>
</body>
<style type="text/css">
.nav-tabs-custom tbody tr.selected {
    background-color: #B0BED9;
}
</style>
</html>



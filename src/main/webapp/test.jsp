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
          <div class="in" id="dealModle" aria-hidden="false" style="display: block;">
              <div class="modal-dialog modal-lg" role="document">
                  <div class="modal-content ">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">×</span>
                          </button>
                      </div>
                      <div class="modal-body">
                          <section class="invoice">
                              <!-- title row -->
                              <div class="row">
                                  <div class="col-xs-12">
                                      <h2 class="page-header">
                                          <i class="fa fa-globe"></i> shuly, Inc.电子协议
                                          <small class="pull-right"></small>
                                      </h2>
                                  </div><!-- /.col -->
                              </div>
                              <!-- info row -->
                              <div class="row invoice-info">
                                  <div class="col-sm-4 invoice-col">
                                      From
                                      <address id="from"><strong>Master</strong><br>Add:北京市<br><small>北京市</small><br>phone:18045170217<br></address>
                                  </div><!-- /.col -->
                                  <div class="col-sm-4 invoice-col">
                                      To
                                      <address id="to"><strong>李宝</strong><br>Add:北京市,北京市,东城区<br><small>大一胡同23号</small><br>phone:18045170217<br></address>
                                  </div><!-- /.col -->

                                  <div id="delinfo" class="col-sm-4 invoice-col"><b>协议</b><br><b>ID : </b>3<br><b>Date : </b>Fri Apr 29 2016<br><b>Time : </b>23:30:54 GMT+0800 (CST)<br></div><!-- /.col -->
                              </div><!-- /.row -->

                              <div class="row">
                                  <div class="col-sm-12 ">
                                      <div class="box box-widget ">
                                          <div class="box-header with-border">
                                              <h3 class="box-title">商品信息</h3>
                                              <div class="box-tools pull-right">
                                              </div>
                                          </div><!-- /.box-header -->
                                          <div class="box-body col-sm-12">
                                              <table id="goodTable" class="table text-center">
                                                  <thead>
                                                  <tr>
                                                      <th class="col-sm-2">名字</th>
                                                      <th class="col-sm-1">图片</th>
                                                      <th class="col-sm-5">描述</th>
                                                      <th class="col-sm-2">原产地</th>
                                                      <th class="col-sm-2">量</th>
                                                  </tr>
                                                  </thead>
                                                  <tbody><tr class="info"><td>山楂</td><td><img class="img-responsive" src="/upload/pic/11461562178930ri43y大金星山楂.jpg"></td><td>对人体有益，可强健大脑</td><td>省份地级市,市、县级市</td><td><div class="input-group"><input id="dealNum" type="text" value="2" readonly="" class="form-control"><span class="input-group-addon">Kg</span></div></td></tr></tbody>
                                              </table>
                                          </div><!-- /.box-body -->
                                          <div class="box-footer"></div>
                                      </div>

                                  </div>
                              </div>
                              <div class="row">
                                  <!-- accepted payments column -->
                                  <div class="col-xs-6">
                                      <p class="lead">对于支付方式</p>
                                      <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                                          请和供应商联系，本网站只是中介服务网站，只提供商品的信息来源和联系方式，这个订单会通知供应商，
                                          并存储在网站内，为了更多的服务大家，并不会提供三方支付平台，请小心上当受骗。
                                      </p>
                                  </div><!-- /.col -->
                                  <div class="col-xs-6">
                                      <p class="lead">价格详情</p>
                                      <div class="table-responsive">
                                          <table id="dealPriceTable" class="table"><tbody><tr><th style="width:50%">商品价格:</th><td>￥0</td></tr><tr><th style="width:50%">运费:</th><td>￥1.2</td></tr><tr><th style="width:50%">总价:</th><td>￥1.2</td></tr></tbody></table>
                                      </div>
                                  </div><!-- /.col -->
                              </div><!-- /.row -->

                              <!-- this row will not appear when printing -->
                              <div class="row no-print">
                                  <div class="col-xs-12">
                                      <button class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> Submit Payment</button>
                                      <button id="dealPDF" class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-download"></i> Generate PDF</button>
                                  </div>
                              </div>
                          </section><!-- /.content -->
                      </div>
                      <div class="modal-footer">
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <!-- Main Footer -->
      <%@include file="/foot.jsp"%>
    </div><!-- ./wrapper -->

    <!-- REQUIRED JS SCRIPTS -->
    <%@include file="/js.jsp"%>
    <!-- Optionally, you can add Slimscroll and FastClick plugins.
         Both of these plugins are recommended to enhance the
         user experience. Slimscroll is required when using the
         fixed layout. -->

  </body>
</html>

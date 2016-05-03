<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="dealModle" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
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
              <address id="from">
              </address>
            </div><!-- /.col -->
            <div class="col-sm-4 invoice-col">
              To
              <address id="to">

              </address>
            </div><!-- /.col -->

            <div id = 'delinfo' class="col-sm-4 invoice-col">

            </div><!-- /.col -->
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
                  <table id ="goodTable" class="table text-center">
                    <thead>
                    <tr>
                      <th class="col-sm-2">名字</th>
                      <th class="col-sm-1">图片</th>
                      <th class="col-sm-5">描述</th>
                      <th class="col-sm-2">原产地</th>
                      <th class="col-sm-2">量</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
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
                <table id = "dealPriceTable" class="table">
                  <tbody>
                    <tr>
                      <th style="width:50%">商品价格估计:</th>
                        <td>￥0.00</td></tr><tr><th style="width:50%">运费(不准):</th>
                        <td>￥0.00</td></tr><tr><th style="width:50%">总价:</th>
                        <td>￥0.00</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div><!-- /.col -->
          </div><!-- /.row -->

          <!-- this row will not appear when printing -->
          <div class="row no-print">
            <div id = "dealDeal"class="col-xs-12">
              <button id = "dealPDF" class="btn btn-primary pull-left" style="margin-right: 5px;"><i class="fa fa-download"></i> 下载PDF</button>
              <button id = "stopDeal" class="btn btn-danger pull-left" style="margin-right: 5px;"><i class="fa  fa-times"></i> 终止订单</button>
              <button id = "acceptDeal" class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> 接受</button>
            </div>
          </div>
        </section><!-- /.content -->
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>

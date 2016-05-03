<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade " id="dealModle" tabindex="-1" role="dialog"
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
            <form  role="form">
              <div class="box-body">
                <div class="form-group col-sm-3" >
                  <label>您的地址</label>
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
                <div class="form-group col-sm-6">
                  <label for="add" >您的姓名</label>
                  <input type="text" class="form-control" id="buyName" name = 'buyName' placeholder="输入">
                </div>
                <div class="form-group col-sm-6">
                  <label for="add" >您的联系电话</label>
                  <input type="text" class="form-control"
                         onkeyup="this.value=this.value.replace(/\D/g,'')"
                         onafterpaste="this.value=this.value.replace(/\D/g,'')"
                         id="buyPhone" name = 'buyPhone' placeholder="输入">
                </div>
                <div class="form-group col-sm-12">
                  <label for="add" >具体地址</label>
                  <input type="text" class="form-control" id="add" name = 'add' placeholder="输入">
                </div>
              </div><!-- /.box-body -->
            </form>

          </div><!-- /.row -->
          <!-- Table row -->
          <div class="row">
            <div class="col-md-12 ">
              <div class="box box-widget ">
                <div class="box-header with-border">
                  <h3 class="box-title">商品信息</h3>
                  <div class="box-tools pull-right">
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body col-md-12">
                  <table id ="goodTable" class="table text-center">
                    <thead >
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
                    <td>￥0.00</td></tr><tr><th style="width:50%">总价:</th><td>￥0.00</td></tr></tbody>
                </table>
              </div>
            </div><!-- /.col -->
          </div><!-- /.row -->

          <!-- this row will not appear when printing -->
          <div class="row no-print">
            <div class="col-xs-12">
              <button id ='dealSubmit' class="btn btn-danger pull-right"><i class="fa fa-credit-card"></i> Submit </button>
            </div>
          </div>
        </section><!-- /.content -->
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
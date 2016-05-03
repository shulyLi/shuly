<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="goodModle">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body col-md-12">
        <div class="box  box-widget">
          <div class="box-body">
            <div class="box-header with-border"></div><!-- /.box-header -->
            <!-- form start -->
            <div class="nav-tabs-custom">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#Agood" data-toggle="tab">固定参数</a></li>
                <li><a href="#Bgood" data-toggle="tab">可变参数</a></li>
              </ul>
            </div>
            <div class="tab-content">
              <div class="tab-pane active" id="Agood">
                <form  role="form">
                    <div class="form-group col-sm-6">
                      <img id = "goodPic" width="100%" src="">
                    </div>
                    <div class=" col-sm-6">
                      <div class="form-group ">
                        <label for="name" >货物名称</label>
                        <input  disabled="disabled" type="text" class="form-control" id="name" name = 'name' placeholder="输入">
                      </div>
                      <div class="form-group">
                        <label for="name" >简短描述</label>
                        <input   disabled="disabled" type="text" class="form-control" id="shortMes" name = 'shortMes' placeholder="输入">
                      </div>
                    </div>
                    <div class="form-group col-sm-12">
                      <label for="describe">长篇描述</label>
                      <textarea   disabled="disabled" class="form-control" rows="4" id = "describe" name="describe" placeholder="输入"></textarea>
                    </div>

                    <div class="form-group col-sm-3" >
                      <label>原产地国家</label>
                      <input class="form-control" disabled="disabled" value="中国" style="width: 100%;">
                      </input>
                    </div>
                    <div class="form-group col-sm-5" >
                      <label>具体地点</label>
                      <input class="form-control "   disabled="disabled" id ="place"  style="width: 100%;">
                      </input>
                    </div>
                </form>
              </div><!-- /.tab-pane -->
              <div class="tab-pane" id="Bgood">
                <form  role="form" >
                    <div class=" col-sm-12">
                      <div class="form-group col-sm-4">
                        <label for="name" >库存</label>
                        <input  type="text" class="form-control" id="num">
                      </div>
                      <div class="form-group col-sm-4">
                        <label for="name" >价格</label>
                        <input  type="text" class="form-control" id="price">
                      </div>
                      <div class="form-group col-sm-4">
                        <label for="state" >状态</label>
                        <select id = 'state' class="form-control" data-width="100%">
                        </select>
                      </div>
                    </div>
                </form>
                <div id = "dealDeal"class="col-xs-12">
                  <button type="button" id = "goodChangeSub" class="btn btn-danger pull-right" style="margin-right: 5px;"><i class="fa  fa-times"></i> 修改提交</button>
                </div>
              </div>
            </div><!-- /.tab-content -->
          </div>
        </div><!-- /.box -->
      </div>
      <div class="modal-footer">

      </div>
    </div>
  </div>
</div>
<script>

</script>
<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade " id="leaveModle" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content ">
      <div class="modal-header">
        <div class="pull-left">可评价的商品一览</div>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form  role="form" id = "godKey">
            <div class="form-group col-sm-12">
              <label for="lever" >等级评价</label>
              <select id = 'lever' class="form-control" style="width: 100%;">
                <option value="-1000">空</option>
                <option value="0">一般</option>
                <option value="1">神了</option>
                <option value="-1">差评</option>
              </select>
            </div>
              <div class="form-group col-sm-12">
                <label for="msg">描述</label>
                <textarea class="form-control" rows="4" id = "msg" name="msg" placeholder="输入"></textarea>
              </div>
            <div class="box-footer">
              <button type="button" id = "leverDoIt" class="btn btn-primary">Submit</button>
            </div>
          </form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
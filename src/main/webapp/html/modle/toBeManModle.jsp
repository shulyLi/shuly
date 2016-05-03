<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-4-13
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade " id="toBeManModle">
  <div class="modal-dialog" role="document">
    <div class="modal-content ">
      <div class="modal-header">
        <p>请填写这些必要的信息</p>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form  id ="Manform"role="form" enctype="multipart/form-data" method="post">
          <div class="box-body">
            <div class="form-group col-sm-12">
              <label for="Manname" >您的姓名</label>
              <input type="text" class="form-control" id="Manname" name = 'Manname' placeholder="输入">
            </div>
            <div class="form-group col-sm-12">
              <label for="Mantel" >您的手机号</label>
              <input type="text" class="form-control" id="Mantel" name = 'Mantel' placeholder="输入">
            </div>
            <div class="form-group col-sm-12">
              <label for="Manlocal">所在地</label>
              <input type="text" class="form-control" id="Manlocal" name = 'Manlocal' placeholder="输入">
            </div>
            <div class="form-group col-sm-12">
              <label for="Mandata">File input</label>
              <input type="file" id="Mandata" name="Mandata">
              <p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
                请将相应的申请文件上传谢谢您的合作<br>
                1).相关的运营执照:可照片，我们会和相关部门核实.<br>
                2).您的手持身份证 的照片.<strong>(请和要求 （1）一致)</strong><br>
                我们会局对保密您的信息<br>
                hit：将文件打包发给我们 格式（zip,rar,tar)
              </p>
            </div>
          <div class="box-footer">
            <button id = "tobeMan"type="button" class="btn btn-primary">Submit</button>
          </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
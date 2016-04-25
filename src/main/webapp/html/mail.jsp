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
                Mailbox

            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Mailbox</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-3">
                    <a href="#" id = "writeOrRead" class="btn btn-primary btn-block margin-bottom">读取</a>
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">信息中心</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul class="nav nav-stacked">
                                <li class="active" id="1">
                                    <a href="#"><i class="fa fa-inbox"></i> 收件箱
                                    </a>

                                </li>
                                <li id ='2'><a href="#"><i class="fa fa-envelope-o"></i> 发件箱</a></li>
                                <li id ='3'><a href="#"><i class="fa fa-file-text-o"></i> 草稿</a></li>
                                <li id ='4'><a href="#"><i class="fa fa-trash-o"></i> 垃圾箱</a></li>
                            </ul>
                        </div><!-- /.box-body -->
                    </div><!-- /. box -->
                    <div class="box box-solid">
                        <div class="box-header with-border">
                            <h3 class="box-title">Admin</h3>
                            <div class="box-tools">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="box-body no-padding">
                            <ul class="nav nav-stacked">
                                <li id ='5'><a href="#"><i class="fa fa-circle-o text-red"></i> 供应商审批</a></li>
                                <li id ='6'><a href="#"><i class="fa fa-circle-o text-light-blue"></i> 举报消息</a></li>
                            </ul>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div><!-- /.col -->
                <div class="col-md-9">
                    <div id = "headBox" class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">收件箱</h3>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="Search Mail">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div><!-- /.box-tools -->
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button id="refresh" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                </div><!-- /.btn-group -->
                                <div class="pull-right">
                                    <span></span>
                                    <div class="btn-group">
                                        <button id="pagemin" class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button id="pageadd"class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div><!-- /.btn-group -->
                                </div><!-- /.pull-right -->
                            </div>
                            <div class="table-responsive mailbox-messages">
                                <row>
                                    <table id ='mailTable' class="table table-hover table-striped">
                                        <tbody id="mailBody">
                                        </tbody>
                                    </table><!-- /.table -->
                                </row>
                            </div><!-- /.mail-box-messages -->
                        </div><!-- /.box-body -->

                        <div class="box-footer no-padding">
                            <!--
                            <div class="mailbox-controls">
                                <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                </div>
                                <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                <div class="pull-right">
                                    1-50/200
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                    </div>

                                </div>
                            </div>
                            -->
                        </div>
                    </div><!-- /. box -->
                    <div id = "writeBox" class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Compose New Message</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class="form-group">
                                <input id = "mailTo" name = "mailTo" class="form-control" placeholder="To:">
                            </div>
                            <div class="form-group">
                                <input id = "mailSub"name = "mailSub" class="form-control" placeholder="Subject:">
                            </div>
                            <div class="form-group">
                                <textarea id="mailMsg" name = "mailMsg" class="form-control" style="height: 300px">
                                </textarea>
                            </div>
                            <div class="form-group">
                                <div class="btn btn-default btn-file">
                                    <i class="fa fa-paperclip"></i> Attachment
                                    <input id = "attachment" type="file" name="attachment">
                                </div>
                                <p class="help-block">Max. 32MB</p>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <div class="pull-right">
                                <button id = "mailDraft" class="btn btn-default"><i class="fa fa-pencil"></i> 草稿</button>
                                <button id = "mailSend" type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> 发送</button>
                            </div>
                            <button id ="mailClear" class="btn btn-default"><i class="fa fa-times"></i> 清空</button>
                        </div><!-- /.box-footer -->
                    </div><!-- /. box -->
                    <div id=  "readBox" class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Read Mail</h3>
                            <div class="box-tools pull-right">
                                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Previous"><i class="fa fa-chevron-left"></i></a>
                                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Next"><i class="fa fa-chevron-right"></i></a>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-read-info">
                                <h3>Message Subject Is Placed Here</h3>
                                <h5>From: support@almsaeedstudio.com <span class="mailbox-read-time pull-right">15 Feb. 2015 11:03 PM</span></h5>
                            </div><!-- /.mailbox-read-info -->
                            <div class="mailbox-controls with-border text-center">
                                <div class="btn-group">
                                    <button class="btn btn-default btn-sm" data-toggle="tooltip" title="Delete"><i class="fa fa-trash-o"></i></button>
                                    <button class="btn btn-default btn-sm" data-toggle="tooltip" title="Reply"><i class="fa fa-reply"></i></button>
                                    <button class="btn btn-default btn-sm" data-toggle="tooltip" title="Forward"><i class="fa fa-share"></i></button>
                                </div><!-- /.btn-group -->
                                <button class="btn btn-default btn-sm" data-toggle="tooltip" title="Print"><i class="fa fa-print"></i></button>
                            </div><!-- /.mailbox-controls -->
                            <div id ="readbody" class="mailbox-read-message">
                                <p>Hello John,</p>
                                <p>Keffiyeh blog actually fashion axe vegan, irony biodiesel. Cold-pressed hoodie chillwave put a bird on it aesthetic, bitters brunch meggings vegan iPhone. Dreamcatcher vegan scenester mlkshk. Ethical master cleanse Bushwick, occupy Thundercats banjo cliche ennui farm-to-table mlkshk fanny pack gluten-free. Marfa butcher vegan quinoa, bicycle rights disrupt tofu scenester chillwave 3 wolf moon asymmetrical taxidermy pour-over. Quinoa tote bag fashion axe, Godard disrupt migas church-key tofu blog locavore. Thundercats cronut polaroid Neutra tousled, meh food truck selfies narwhal American Apparel.</p>
                                <p>Raw denim McSweeney's bicycle rights, iPhone trust fund quinoa Neutra VHS kale chips vegan PBR&amp;B literally Thundercats +1. Forage tilde four dollar toast, banjo health goth paleo butcher. Four dollar toast Brooklyn pour-over American Apparel sustainable, lumbersexual listicle gluten-free health goth umami hoodie. Synth Echo Park bicycle rights DIY farm-to-table, retro kogi sriracha dreamcatcher PBR&amp;B flannel hashtag irony Wes Anderson. Lumbersexual Williamsburg Helvetica next level. Cold-pressed slow-carb pop-up normcore Thundercats Portland, cardigan literally meditation lumbersexual crucifix. Wayfarers raw denim paleo Bushwick, keytar Helvetica scenester keffiyeh 8-bit irony mumblecore whatever viral Truffaut.</p>
                                <p>Post-ironic shabby chic VHS, Marfa keytar flannel lomo try-hard keffiyeh cray. Actually fap fanny pack yr artisan trust fund. High Life dreamcatcher church-key gentrify. Tumblr stumptown four dollar toast vinyl, cold-pressed try-hard blog authentic keffiyeh Helvetica lo-fi tilde Intelligentsia. Lomo locavore salvia bespoke, twee fixie paleo cliche brunch Schlitz blog McSweeney's messenger bag swag slow-carb. Odd Future photo booth pork belly, you probably haven't heard of them actually tofu ennui keffiyeh lo-fi Truffaut health goth. Narwhal sustainable retro disrupt.</p>
                                <p>Skateboard artisan letterpress before they sold out High Life messenger bag. Bitters chambray leggings listicle, drinking vinegar chillwave synth. Fanny pack hoodie American Apparel twee. American Apparel PBR listicle, salvia aesthetic occupy sustainable Neutra kogi. Organic synth Tumblr viral plaid, shabby chic single-origin coffee Etsy 3 wolf moon slow-carb Schlitz roof party tousled squid vinyl. Readymade next level literally trust fund. Distillery master cleanse migas, Vice sriracha flannel chambray chia cronut.</p>
                                <p>Thanks,<br>Jane</p>
                            </div><!-- /.mailbox-read-message -->
                        </div><!-- /.box-body -->
                        <!--
                        <div class="box-footer">
                            <ul class="mailbox-attachments clearfix">
                                <li>
                                    <span class="mailbox-attachment-icon"><i class="fa fa-file-pdf-o"></i></span>
                                    <div class="mailbox-attachment-info">
                                        <a href="#" class="mailbox-attachment-name"><i class="fa fa-paperclip"></i> Sep2014-report.pdf</a>
                        <span class="mailbox-attachment-size">
                          1,245 KB
                          <a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a>
                        </span>
                                    </div>
                                </li>
                                <li>
                                    <span class="mailbox-attachment-icon"><i class="fa fa-file-word-o"></i></span>
                                    <div class="mailbox-attachment-info">
                                        <a href="#" class="mailbox-attachment-name"><i class="fa fa-paperclip"></i> App Description.docx</a>
                        <span class="mailbox-attachment-size">
                          1,245 KB
                          <a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a>
                        </span>
                                    </div>
                                </li>
                                <li>
                                    <span class="mailbox-attachment-icon has-img"><img src="../../dist/img/photo1.png" alt="Attachment"></span>
                                    <div class="mailbox-attachment-info">
                                        <a href="#" class="mailbox-attachment-name"><i class="fa fa-camera"></i> photo1.png</a>
                        <span class="mailbox-attachment-size">
                          2.67 MB
                          <a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a>
                        </span>
                                    </div>
                                </li>
                                <li>
                                    <span class="mailbox-attachment-icon has-img"><img src="../../dist/img/photo2.png" alt="Attachment"></span>
                                    <div class="mailbox-attachment-info">
                                        <a href="#" class="mailbox-attachment-name"><i class="fa fa-camera"></i> photo2.png</a>
                        <span class="mailbox-attachment-size">
                          1.9 MB
                          <a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a>
                        </span>
                                    </div>
                                </li>
                            </ul>
                        </div>--><!-- /.box-footer -->
                        <div class="box-footer">
                            <div class="pull-right">
                                <button class="btn btn-default"><i class="fa fa-reply"></i> Reply</button>
                                <button class="btn btn-default"><i class="fa fa-share"></i> Forward</button>
                            </div>
                            <button class="btn btn-default"><i class="fa fa-trash-o"></i> Delete</button>
                            <button class="btn btn-default"><i class="fa fa-print"></i> Print</button>
                        </div><!-- /.box-footer -->
                    </div><!-- /. box -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/foot.jsp"%>
</div><!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/js.jsp"%>

<script src="/js/mail.js" ></script>
<script>
    mailInit();
</script>
<!-- AdminLTE for demo purposes -->
<!-- page script -->
<!-- Page script -->

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>



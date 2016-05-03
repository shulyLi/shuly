var pageNum = 0;
var mail = new Array();
function    clearTable(){
    $("#mailTable #mailBody").empty();
}
function DATA(tmp){
    var date = new Date(tmp);
    var today = new Date();
    if(date.toDateString() == today.toDateString()){
        return date.getHours()+":"+date.getMinutes() +" today";
    }
    return date.toDateString();
}
function addMailRow(item){
    var Str = '<tr class="'+(item.isread=='1'?"":"danger")+'"id ="mail'+item.id+'">'+
        '<td><input type="checkbox"></td>'+
        '<td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>'+
        '<td class="mailbox-name"><a href="#">'+item.name+'</td>'+
        '<td class="mailbox-subject">'+item.sub+'</td>'+
        '<td class="mailbox-attachment"></td>'+
        '<td class="mailbox-date">'+DATA(item.date)+'</td>'+
    '</tr>';
    $("#mailTable #mailBody").append(Str);
    //$("#mailBody").append(str);
}
function changeHead(){
    var tmp = $("#writeOrRead").text();
    if(tmp=="写信"){
        $("#writeOrRead").text("读取");
        $("#headBox").show();
        $("#writeBox").hide();
        $("#readBox").hide();
    }
    else{
        $("#writeOrRead").text("写信");
        $("#headBox").hide();
        $("#writeBox").show();
        $("#readBox").hide();
    }
}
function drawMail(){
    if(mail.success==false) {
        alert(data.msg);
        return null;
    }
    clearTable();
    var data = mail.data;
    var head=1+(pageNum*10);
    if(head+9<data.length) var tail = head+9;
    else var tail = data.length;
    if(head>tail) head =tail;
    var Str =head+'-'+tail+"/"+data.length;
    $("#readBox .box-body .mailbox-controls .pull-right span").text(Str);
    if(head!=0)
    for(var index = head ;index<=tail ;index++){
        addMailRow(data[index-1]);
    }
    checkBoxInit();
    $("#writeBox").hide();
    $("#readBox").hide();
    $("#headBox").show();
}
function checkBoxInit(){
    $('.mailbox-messages input[type="checkbox"]').iCheck({
        checkboxClass:'icheckbox_flat-blue',
        radioClass:'iradio_flat-blue'
    });
    $(".mailbox-star").unbind("click");
    $(".mailbox-star").click(function (e) {
        e.preventDefault();
        //detect type
        var $this = $(this).find("a > i");
        var glyph = $this.hasClass("glyphicon");
        var fa = $this.hasClass("fa");

        //Switch states
        if (glyph) {
            $this.toggleClass("glyphicon-star");
            $this.toggleClass("glyphicon-star-empty");
        }

        if (fa) {
            $this.toggleClass("fa-star");
            $this.toggleClass("fa-star-o");
        }
    });
    $(".mailbox-name").unbind("click");
    $(".mailbox-name").click(function(){
        getMail($(this).parent().attr("id").substring(4));
        $("#writeBox").hide();
        $("#readBox").show();
        $("#headBox").hide();
    })
}
function showMail(Mail){
    //alert(Mail.mes)
    $("#mailbox-read-info h3").text("标题:"+Mail.head)
    $("#mailbox-read-info h5").html('From: '+Mail.from_user+'<span class="mailbox-read-time pull-right">'+(new Date(Mail.create_time)).toLocaleString()+'</span>');
    $("#important").hide();
    if(Mail.mailtype==5){
        if(Mail.isread==0)
            $("#important").show();
        var obj = eval("(" + Mail.mes + ")");
        ///alert(obj.name)
       // alert(obj.tel)
       // alert(obj.local)
        $("#readbody").empty();
        $("#readbody").append("name:"+obj.name);
        $("#readbody").append("<br>phone:"+obj.tel);
        $("#readbody").append("<br>add:"+obj.local);
        $("#pass").unbind("click");
        $("#pass").click(function(){
            var ID=Mail.head.substring(4,6);
            alert(ID)
            $.ajax( {
                url:'/key/user/canBeMan.json',
                data :{
                    'mailId':Mail.id,
                    'id':ID,
                    'name':obj.name,
                    'tel':obj.tel,
                    'add':obj.local,
                    'BOOL':1
                },
                dataType:"json",   //返回格式为json
                async:true, //请求是否异步，默认为异步，这也是ajax重要特性
                type:"get",   //请求方式
                traditional:true,
                success:function(data) {
                    var flag = 0;
                    if(data.msg!=""){
                        alert(data.msg);
                        flag = 1;
                    }
                    if(data.goto!=""){
                        window.location.href=data.goto;
                        flag =1 ;
                    }
                    if(flag ==1) return null;
                    mailInit()
                },
            });
        })
        $("#nopass").unbind("click");
        $("#nopass").click(function(){
            $.ajax( {
                url:'/key/user/canBeMan.json',
                data :{
                    'name':obj.name,
                    'BOOL':0
                },
                dataType:"json",   //返回格式为json
                async:true, //请求是否异步，默认为异步，这也是ajax重要特性
                type:"get",   //请求方式
                traditional:true,
                success:function(data) {
                    var flag = 0;
                    if(data.msg!=""){
                        alert(data.msg);
                        flag = 1;
                    }
                    if(data.goto!=""){
                        window.location.href=data.goto;
                        flag =1 ;
                    }
                    if(flag ==1) return null;
                    mailInit()
                },
            });
        })
    }
    else if(Mail.mailtype==6){
        if(Mail.isread==0)
            $("#important").show();
        var obj = eval("(" + Mail.mes + ")");
    }
    else
        $("#readbody").html(Mail.mes);
    if(Mail.filerar!=""&&Mail.filerar!=null){
        $("#downer").empty();
        $("#downer").append(
            '<li><div class="mailbox-attachment-info">'+
            '<a href="#" class="mailbox-attachment-name"><i class="fa fa-check-circle"></i>文件</a>'+
            '<span class="mailbox-attachment-size">'+
            '<a href="/key/down/download?path='+Mail.filerar+'" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a>'+
            '</span> '+
            '</div> </li>'
        );

    }

}
function mailTable(){
    $.ajax( {
        url:'/key/mail/find.json',
        data :{'type':$("ul.nav.nav-stacked li.active").attr("id")},
        dataType:"json",   //返回格式为json
        async:true, //请求是否异步，默认为异步，这也是ajax重要特性
        type:"get",   //请求方式
        traditional:true,
        beforeSend:function() {
            //请求前的处理
            //alert("start");
        },
        success:function(data) {
            var flag = 0;
            if(data.msg!=""){
                alert(data.msg);
                flag = 1;
            }
            if(data.goto!=""){
                window.location.href=data.goto;
                flag =1 ;
            }
            if(flag ==1) return null;

            mail = data;
            pageNum=0;
            drawMail();
            //styleInit();
            navInint(data.num);
        },
        complete:function() {
        },
            error:function() {
        }
    });
}
function sendMail(mType){
    $.ajax( {
        url:'/key/mail/add.json',
        data :{
            'type':mType,
            'msg':$("#mailMsg").val(),
            'sub':$("#mailSub").val(),
            'to' :$("#mailTo").val()
        },
        dataType:"json",   //返回格式为json
        async:true, //请求是否异步，默认为异步，这也是ajax重要特性
        type:"get",   //请求方式
        traditional:true,
        beforeSend:function() {

        },
        success:function(data) {
            var flag = 0;
            if(data.msg!=""){
                alert(data.msg);
                flag = 1;
            }
            if(data.goto!=""){
                window.location.href=data.goto;
                flag =1 ;
            }
            if(flag ==1) return null;
        },
        complete:function() {
            mailInit()
        },
        error:function() {
        }
    });
}
function getMail(id){
    $.ajax( {
        url:'/key/mail/getMail.json',
        data :{
            id:id
        },
        dataType:"json",   //返回格式为json
        async:true, //请求是否异步，默认为异步，这也是ajax重要特性
        type:"post",   //请求方式
        traditional:true,
        beforeSend:function() {

        },
        success:function(data) {
            var flag = 0;
            if(data.msg!=""){
                alert(data.msg);
                flag = 1;
            }
            if(data.goto!=""){
                window.location.href=data.goto;
                flag =1 ;
            }
            if(flag ==1) return null;
            showMail(data.data);
        },
        complete:function() {
        },
        error:function() {
        }
    });
}
function navInint(num){
    //
    $.each(num, function (index,val) {
        $("ul.nav.nav-stacked li#"+val.id+" a span").remove();
        if(val.val==0) return ;
        var Str = '<span class="label label-primary pull-right">'+val.val+'</span>';
        //alert(Str);
        $("ul.nav.nav-stacked li#"+val.id+" a").append(Str);
    })
}
function writeMailClear(){
    $("#mailSub").val("")
    $("#mailTo").val("")
    $("#mailMsg").val("")
}
function mailInit(){
    //head
    $("ul.nav.nav-stacked li").unbind("click");
    $("ul.nav.nav-stacked li").click(function(){
        $("ul.nav.nav-stacked li").removeClass("active");
        $(this).addClass("active");
        mailTable();
    });
    $(".checkbox-toggle").unbind("click");
    $(".checkbox-toggle").click(function () {
        var clicks = $(this).data('clicks');
        if (clicks) {
            //Uncheck all checkboxes
            $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
            $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
        } else {
            //Check all checkboxes
            $(".mailbox-messages input[type='checkbox']").iCheck("check");
            $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
        }
        $(this).data("clicks", !clicks);
    });
    //write
    $("#writeBox").hide();
    $("#readBox").hide();

    $("#writeOrRead").attr("onclick","changeHead();");
    mailTable();
    //Write= $("#mailMsg").wysihtml5();
    $("#mailClear").attr("onclick","writeMailClear();");

    $("#mailSend").attr("onclick","sendMail(2);")
    $("#mailDraft").attr("onclick","sendMail(3);")

    $("#pagemin").unbind("click");
    $("#pagemin").click(function(){
        if(pageNum>0){
            pageNum--;
            drawMail();
        }
    });

    $("#pageadd").unbind("click");
    $("#pageadd").click(function(){
        if((pageNum+1)*10+1<mail.data.length){
            pageNum++;
            drawMail();
        }
    });
    $("#refresh").unbind("click");
    $("#refresh").click(function(){
        mailTable();
    });
}
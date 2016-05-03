
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function  What(levelr){
    var arry =new Array("","普通","商人","大商人","Master");
    if((levelr & 8) !=0) return arry[4];
    if((levelr & 2) !=0) return arry[2];
    if((levelr & 1) !=0) return arry[1];
}
function draw(user){
    $("#user_pic").attr("src",user.pic);
    $("#user_name").text(user.username)

    $("#mainInfo").empty();{
       var arry =new Array("","普通","商人","大商人","Master");
        var str = '<li class="list-group-item">'+
            '<b>评价分数</b> <a class="pull-right">'+user.point+'</a></li>'+
            '<li class="list-group-item">'+
            '<b>类型</b> <a class="pull-right">'+What(user.levelr)+'</a></li>'
            ;
        $("#mainInfo").append(str);
    }{
        /*
         <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>
         <p class="text-muted">Malibu, California</p>
         <hr>
         */
        var strr='<strong><i class="fa fa-map-marker margin-r-5"></i> 所在地</strong>'+
            '<p class="text-muted">'+user.add+'</p><hr>'+
            '<strong><i class="fa  fa-phone"></i> 手机号码</strong>'+
            '<p class="text-muted">'+user.telnum+'</p><hr>'+
            '<strong><i class="fa  fa-envelope"></i> 邮箱</strong>'+
            '<p class="text-muted">'+user.emailr+'</p><hr>';
        $("#userMoreInfo").empty();
        $("#userMoreInfo").append(strr);
    }
}
function drawOp(op){
    /*
     <li>
     <i class="fa fa-envelope bg-blue"></i>
     <div class="timeline-item">
     <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>
     <h3 class="timeline-header">
        <a href="#">Support Team</a> sent you an email
     </h3>
     <div class="timeline-body"></div><div class="timeline-footer"></div>
     </div>
     </li>
    */
    var arry =new Array("fa fa-exclamation bg-red",
        "fa fa-user bg-aqua",
        "fa fa-truck ",
        "fa fa-comments bg-yellow",
        "fa fa-sticky-note-o",
        "fa fa-envelope bg-blue");
    var str='';
    $.each(op, function (index,val) {
        str+=
        '<li><i class="'+arry[val.type]+'"></i>'+
            '<div class="timeline-item">'+
                '<span class="time"><i class="fa fa-clock-o"></i>'+(new Date(val.create_time)).toLocaleString()+'</span>'+
                '<h3 class="timeline-header">'+
                    val.reason+
                '</h3>'+
            //'<div class="timeline-body"></div><div class="timeline-footer"></div>'+
             '</div>' +
        '</li>';
    })
    str+='<li><i class="fa fa-clock-o bg-gray"></i></li>';
    $("#opBoday").empty();
    $("#opBoday").append(str);

}
function getUser(userId){
    $.ajax({
        url: "/key/user/userInfoDeatail.json",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: { "id": userId },    //参数值
        type: "post",   //请求方式
        beforeSend: function() {},
        success: function(data) {
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
            draw(data.data.user);
            drawOp(data.data.op);
        },
        complete: function() {},
        error: function() {}
    });
}
function inint(){
    var Request = new Object();
    Request = GetRequest()
    var userId = Request['userId'];
    getUser(userId);
    //$(".nihaibuyinshena").show();
}
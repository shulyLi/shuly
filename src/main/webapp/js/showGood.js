var from  = null;
var to    = null;
var good = null;
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
function setOwner(data){
    $("#goodOwner .img-circle").attr("src",data.pic);
    $("#goodOwner .username a").text(data.username);
    $("#goodOwner .username a").attr("href","/html/user/user.jsp?userId="+data.id);
    $("#ownerPoint a").text(data.point);
}
function setGood(data){
    $("#goodName").text(data.goodname);
    $("#goodTag").text(data.tag);
    $("#goodJudge a").text(data.intJudge[4]);
    $("#goodPlace a").text(data.province+data.detailPlace);
    $("#goodNum a").text(data.number+"kg");
    $("#goodPrice a").text(data.price+"￥");
    $("#goodPic").attr("src",data.pic_url);
}
function  userinfo(tag){
    var str="<strong>"+tag.username+"</strong><br>地址 ：" +
        tag.add+"<br>电话 ：" +
        tag.telnum;
    return str;
}
function drawDeal(){
    if(from == null || to == null || good ==null) {
        alert("我想似乎有地方不对啊");
    }
    var str =
        "<tr class='warning'>" +
            "<th>"+good.goodname+"</th>" +
            "<th ><img class='img-responsive' width='100%' src="+good.pic_url+" ></th>" +
            "<th>"+good.tag+"</th>" +
            "<th>"+good.province+good.detailPlace+"</th>" +
            "<th>" +
                 "<div class='input-group'>" +
            "<input id = 'dealNum'type='text' " + "class='form-control'>" +
        "<span class='input-group-addon'>Kg</span></div>"+
            "</th>" +
        "</tr>";
    $("#dealModle #goodTable tbody").empty();
    $("#dealModle #goodTable tbody").append(str);
    $('#dealNum').unbind('input');
    $('#dealNum').unbind('propertychange');
    $("#dealPriceTable").empty();
    $("#dealPriceTable").append('<tr><th style="width:50%">商品价格:</th><td>￥ 0</td></tr>');
    $("#dealPriceTable").append('<tr><th style="width:50%">运费:</th><td>￥ 0</td></tr>');
    $("#dealPriceTable").append('<tr><th style="width:50%">总价:</th><td>￥ 0</td></tr>');

    $('#dealNum').bind('input propertychange', function(){
        var num=$(this).val();
        $("#dealPriceTable").empty();
        $("#dealPriceTable").append('<tr><th style="width:50%">商品价格:</th><td>￥'+num*good.price*1.0+'</td></tr>');
        $("#dealPriceTable").append('<tr><th style="width:50%">运费:</th><td>￥'+num*0.6+'</td></tr>');
        $("#dealPriceTable").append('<tr><th style="width:50%">总价:</th><td>￥'+num*(good.price+0.6)*1.0+'</td></tr>');
    });
    /*                  <tr>
     <th style="width:50%">Subtotal:</th>
     <td>$250.30</td>
     </tr>
     */
}
function goodDetailInit(){
    var Request = new Object();

    Request = GetRequest()
    var goodId = Request['goodId'];
    if(goodId == null ) return ;
    $.ajax({
        url: "/key/good/showGoodDetail",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: { "goodId": goodId },    //参数值
        type: "post",   //请求方式
        beforeSend: function() {
            //请求前的处理
            // alert("start");
        },
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
            from = data.data.owner;
            good = data.data.good;
            setOwner(data.data.owner)
            setGood(data.data.good);
        },
        complete: function() {
            //请求完成的处理
            //alert("over");
        },
        error: function() {
            //请求出错处理
            alert("here is somethine Wrong !Sorry!");
        }
    });

    $("#dealButten").click(function () {
        $.ajax({
            url: "/key/user/toUser",    //请求的url地址
            dataType: "json",   //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {},    //参数值
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
                to = data.data;
                drawDeal();
            },
            complete: function() {},
            error: function() {}
        });
    });
    $("#dealSubmit").click(function () {
        var num = $('#dealNum').val()
        if(isNaN(num)||num<=0) {
            alert("这个数字不对吧？")
            return ;
        }
        var buyPhone = $("#buyPhone").val();
        if(isNaN(buyPhone)||buyPhone<13000000000||buyPhone>=19900000000){
            alert("电话号码不对啊!");
            return ;
        }
        var buyName = $("#buyName").val();


        $.ajax({
            url: "/key/deal/add.json",    //请求的url地址
            dataType: "json",   //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                'goodId':goodId,
                'goodNum':num,
                'detailAdd':$("#add").val(),
                'province':$("#s_province").val(),
                'city':$("#s_city").val(),
                'county':$("#s_county").val(),
                'buyName':$("#buyName").val(),
                'buyPhone':$("#buyPhone").val()
            },    //参数值
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
                to = data.data;
                drawDeal();
            },
            complete: function() {
                window.location.reload();
            },
            error: function() {}
        });
    })

    $.ajax({
        url: "/key/leave/getGoodMsg.json",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: { "goodId": goodId },    //参数值
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
            drowComment(data.data);
        },
        complete: function() {},
        error: function() {}
    });
}
function  drowComment(data){
    /*
     "<div class='box-comment'>"+
        "<img class='img-circle img-sm' src='../../dist/img/user5-128x128.jpg' alt='user image'>"+
     "<div class='comment-text'>"
        <span class="username"> admin
        <span class='text-muted pull-right'>8:03 PM Today</span>
     </span><!-- /.username -->
     感谢您的支持，感谢您和我们一起见证小堡的辉煌，我们将不断完善，争取做的更好，回报您的厚爱，小堡欢迎您的再次光临！
     </div><!-- /.comment-text -->
     </div><!-- /.box-comment -->
     */
    $("#comments").empty();
    var arry= new Array("差评","一般","神了");
    $.each(data,function(index,val){
        var str =
            "<div class='box-comment'>"+
            "<img class='img-circle img-sm' src='"+val.user.pic+"' alt='user image'>"+
            "<div class='comment-text'>"+
            "<span class='username'> "+val.user.username +
            "<span class='text-muted pull-right'>"+(new Date(val.left.create_time)).toLocaleString()+"</span>" +
            "</span>" +
            "<strong>评价等级:"+ arry[val.left.lever+1]+"</strong><br>"+
                val.left.mes+
            "</div></div>";
        $("#comments").append(str);
    })
}
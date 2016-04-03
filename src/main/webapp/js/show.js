function  addDiv(item){
    var divStr='<div class="col-xs-3 " >'+
        '<a href="/html/showGoodDetail.jsp?goodId='+item.id +'" >'+
        '<div class = "showpic">'+
        '<img src="'+item.pic_url+'"class="img-responsive img-thumbnail">'+
        '</div>'+
        '<p class = "showhead">'+item.mes+'</p>'+
        '<div class = "showinfo">'+
        '<p >点击：233，好评10</p>'+
        '</div>'+
        '</a>'+
        '</div>';
    //alert(divStr);
    $("#father").append(divStr);
}
var pageNum=1
$(function(){
    $("#father").delegate("a","click",function() {
        alert("????")
    })
    var arrivedAtBottom = function () {
        return $(document).scrollTop() + $(window).height() == $(document).height();
    }
    $(window).scroll(function(){
        if(arrivedAtBottom()) {
            alert("哦哦,到底了.");
            $.ajax({
                url: "/key/good/show.json",    //请求的url地址
                dataType: "json",   //返回格式为json
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                data: { "pageNum":pageNum },    //参数值
                type: "post",   //请求方式
                beforeSend: function() {
                    //请求前的处理
                    // alert("start");
                },
                success: function(req) {
                    alert("success")
                    $.each(req, function (index, item) {
                        alert(index)
                        //alert(item.id+'\n' +item.mes+'\n'+item.pic_url+'\n'+item.create_time)
                        //addDiv(item)
                        //addDiv(item)
                    });
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
            pageNum = pageNum+1
        }
    });
});
$(document).ready(function(){
    $("button").click(function(id){
        //alert($(this).)
        $.ajax({
            url: "/key/good/show.json",    //请求的url地址
            dataType: "json",   //返回格式为json
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: { "pageNum": "1" },    //参数值
            type: "post",   //请求方式
            beforeSend: function() {
                //请求前的处理
                // alert("start");
            },
            success: function(req) {
                alert("success")
                $.each(req, function (index, item) {
                    alert(index)
                    addDiv(item)
                });
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
    });
});
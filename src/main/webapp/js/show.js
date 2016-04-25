
var father;
var num=0;
var pageNum=0;
function addRow(){
    var id="father"+num;
    //alert(id)
    var rowStr=
        '<div class="row Delete" id ="'+id+'"> </div>';
    $("#graF").append(rowStr);
    father=$("#"+id);
}
function init(){
    father=null;
    num=0;
    pageNum=0;
    $("#graF").empty();
}
function addDiv(item){
    var divStr=
        '<section class="col-sm-3 box-primry">'+
            '<div class="box" >'+
                '<div class="box-header with-border">'+
                    '<h3 class="box-title">'+item.goodname+'</h3>'+
                '</div>'+
                '<div class="box-body">'+
                                '<a href="/html/showGoodDetail.jsp?goodId='+item.id +'" >'+
                                    '<img class ="img-responsive img-thumbnail" src="'+item.pic_url+'">'+
                                '</a>'+
                '</div>'+
                '<div class="box-footer">' +
                    '<p >'+item.tag+'</p>'+
                    '<p >点击：233，好评10</p>'+
                '</div>'+
            '</div>'+
        '</section>';
    //alert(divStr);
    father.append(divStr);
}
function arrivedAtBottom() {
    return $(document).scrollTop() + $(window).height() == $(document).height();
}

/*
$(function(){
    $(".content").delegate("a","click",function() {
        //alert("????")
    })
});
*/
function getData(){
    var str = $(".select2-selection__choice");
    var province = new Array();
    var findData = $("#findData").val()
    $.each(str,function(i,val){
        province.push(val.title);
    });
    $.ajax({
        url: "/key/good/find.json",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: { "pageNum": pageNum,"province":province,"findData":findData},    //参数值
        type: "get",   //请求方式
        traditional: true,
        beforeSend: function() {
            //请求前的处理
            //alert("start");
        },
        success: function(req) {
            //alert("success")
            $.each(req, function (index, item) {
                //alert(index)
                //alert(num%5==0)
                if(num%4==0){
                    addRow();
                }
                addDiv(item)
                num++;
            });
            pageNum++;
        },
        complete: function() {
            //请求完成的处理
            //alert("over");
        },
        error: function() {
            //请求出错处理
            //alert("here is somethine Wrong !Sorry!");
        }
    });

}
function startData(){
    init();
    getData();
}
function _initShow(){
    startData();
    $(window).scroll(function(){
        if(arrivedAtBottom()) {
            //alert("哦哦,到底了.");
            getData();
        }
    });
    $('#find').attr("onclick","startData();");
}
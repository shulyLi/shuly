
function inintTable(URL,ID){
    return $("#"+ID).DataTable({
        "lengthChange": false,
        "searching": true,
        "autoWidth": false,
        bJQueryUI:true,
        ajax: {
            url: URL,
            type : 'post',
            dataSrc: function ( json ) {
                if(json.msg!=""){
                    alert(json.msg);
                }
                if(json.goto!=""){
                    window.location.href=json.goto;
                }
                return json.data;
            },
            data :{}
        },
        rowId: 'id',
        columns:[
            {"data": "goodName" },
            {"data": "goodNum"},
            {"data": "goodPrice"},
            {"data": "goodState"},
            {"data": "create_time"}
        ],
    });
}
function  initFromDeal(){
    var table0 = inintTable('/key/deal/fromMyDeal.json','fromDealTable');
    $('#fromDealTable tbody').on( 'click', 'tr', function () {
        if ($(this).hasClass('selected') ) {
            var id = table0.row( this ).id();
            drawDeal(id,"from");
            $(this).removeClass('selected');
        }
        else {
            table0.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
}
function initToDeal(){
    var table1 = inintTable('/key/deal/toMyDeal.json','toDealTable');
    $('#toDealTable tbody').on( 'click', 'tr', function () {
        if ($(this).hasClass('selected') ) {
            var id = table1.row( this ).id();
            drawDeal(id,"to");
            $(this).removeClass('selected');
        }
        else {
            table1.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
}

function drawDeal(id,type) {
    $.ajax({
        url: "/key/deal/showDealDetail.json",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: {"dealId": id},    //参数值
        type: "post",   //请求方式
        beforeSend: function () {
            //请求前的处理
            //alert("start");
        },
        success: function (data) {
            //alert("suc")
            var flag = 0;
            if (data.msg != "") {
                alert(data.msg);
                flag = 1;
            }
            if (data.goto != "") {
                window.location.href = data.goto;
                flag = 1;
            }
            if (flag == 1) return null;
            draw(data.data,type);
        },
        complete: function () {
            //请求完成的处理
            //alert("over");
        },
        error: function () {
            //请求出错处理
            //alert("here is somethine Wrong !Sorry!");
        }
    });
}
function  draw(data,type){
    var from = data.from;
    var to = data.to;
    var good = data.good;
    var deal = data.deal;
    var str =
        "<tr class='info'>" +
            "<td>"+good.goodname+"</td>" +
            "<td ><img class='img-responsive' width='100%'  src="+good.pic_url+" ></td>" +
            "<td>"+good.tag+"</td>" +
            "<td>"+good.province+good.detailPlace+"</td>" +
            "<td>" +deal.num+" Kg"+
            "</td>" +
        "</tr>";
    var DATE= new Date(deal.create_time);
    var strFrom="<strong>"+from.username+"</strong><br>" +
        "Add:"+from.add+"<br>"+
        "<small>"+from.add+"</small><br>" +
        "phone:"+from.telnum+"<br>";

    var strTo="<strong>"+deal.buyName+"</strong><br>" +
        "Add:"+deal.add+"<br>"+
        "<small>"+deal.detailAdd+"</small><br>" +
        "phone:"+deal.buyPhone+"<br>";

    var strDeal = "<b>协议</b><br>" +
        "<b>ID : </b>"+deal.id+"<br>" +
        "<b>Date : </b>"+DATE.toDateString()+"<br>"+
        "<b>Time : </b>"+DATE.toTimeString()+"<br>"+
        "<b>State : </b>"+data.states+"<br>";

    $("#from").html(strFrom);
    $("#to").html(strTo);
    $("#delinfo").html(strDeal);

    $("#dealModle #goodTable tbody").empty();
    $("#dealModle #goodTable tbody").append(str);
    $("#dealPriceTable").empty();
    $("#dealPriceTable").append('<tr><th style="width:50%">商品价格:</th><td>￥'+deal.goodPrice+'</td></tr>');
    $("#dealPriceTable").append('<tr><th style="width:50%">运费:</th><td>￥'+deal.tradePrice+'</td></tr>');
    $("#dealPriceTable").append('<tr><th style="width:50%">总价:</th><td>￥'+(deal.goodPrice+deal.tradePrice)+'</td></tr>');

    var str = "<i class='fa fa-credit-card'></i>";
    $("#acceptDeal").attr("disabled",true);
    var tag =deal.states ==1?" 完成":" 接受";
    str+=tag;
    if(type=="from"&&deal.states==1){
        $("#acceptDeal").attr("disabled",false);
    }
    else if (type=="to" && deal.states==0){
        $("#acceptDeal").attr("disabled",false);
    }
    $("#dealPDF").unbind("click");
    $("#dealPDF").click(function () {
        $(".content-wrapper").hide();
        $(".main-footer").hide();
        $("#dealModle").html();
        window.print();
        $(".content-wrapper").show();
        $(".main-footer").show();
    });
    $("#acceptDeal").unbind("click");
    $("#acceptDeal").click(function(){
        var key = confirm("确定"+tag+"么？");
        if(key==true){
            changeDealState(type,tag==" 完成"?4:1,deal.id);
        }
    })
    $("#stopDeal").unbind("click");
    $("#stopDeal").click(function(){
        var key = confirm("确定终止么？");
        if(key==true){
            changeDealState(type,type=="from"?3:2,deal.id);
        }
    })
    $("#acceptDeal").html(str);
    $("#dealModle").modal('toggle');
    //$('#dealModle').on('hidden.bs.modal', function (e) {})
}
function changeDealState(type,key,id){
    $.ajax({
        url: "/key/deal/changeDealState.json",    //请求的url地址
        dataType: "json",   //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: {
            "id":id,
            "type":type,
            "key":key
        },    //参数值
        type: "post",   //请求方式
        beforeSend: function () {
        },
        success: function (data) {
            var flag = 0;
            if (data.msg != "") {
                alert(data.msg);
                flag = 1;
            }
            if (data.goto != "") {
                window.location.href = data.goto;
                flag = 1;
            }
            if (flag == 1) return null;

        },
        complete: function () {
            window.location.reload();
        },
        error: function () {
            //请求出错处理
            alert("here is somethine Wrong !Sorry!");
        }
    });
}
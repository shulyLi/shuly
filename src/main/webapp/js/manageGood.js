/*


*/
var KEY;
function draw(data){
    $("#place").val( data.province+data.detailPlace);
    $("#shortMes").val(data.tag);
    $("#describe").val(data.mes);
    $("#name").val(data.goodname)
    $("#num").val(data.number);
    $("#price").val(data.price)
    $("#num").val(data.number);
    $("#price").val(data.price)

    $("#num").attr("disabled",false);
    $("#price").attr("disabled",false);
    $("#state").attr("disabled",false);
    if(data.tmp!="上架" && data.tmp!="下架"){
        $("#num").attr("disabled",true);
        $("#price").attr("disabled",true);
        $("#state").append(
            '<option selected="selected" value ="">'+data.tmp+'</option>'
        )
        $("#state").attr("disabled",true);
        $("#goodChangeSub").attr("disabled",true);
    }
    else{
        $("#state").html(
            '<option value ="0">下架</option>'+
            '<option value ="1">上架</option>'
        )
        $("#state").val(data.isshelf)
    }
    $("#goodPic").attr("src",data.pic_url);
    $("#passGood").unbind("click");
    $("#passGood").click(function (e) {
        $.ajax({
            url: "/key/good/opGood.json",    //请求的url地址
            dataType: "json",
            async: true,
            data: {
                "goodId":data.id,
                "ischeck":1
            },
            type: "get",
            traditional: true,
            beforeSend: function() {

            },
            success: function(data) {
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
            complete: function() {
                window.location.reload();
            },
            error: function() {

            }
        });
    })
    $("#deleteGood").unbind("click");
    $("#deleteGood").click(function (e) {
        $.ajax({
            url: "/key/good/opGood.json",    //请求的url地址
            dataType: "json",
            async: true,
            data: {
                "goodId":data.id,
                "ischeck":-1
            },
            type: "get",
            traditional: true,
            beforeSend: function() {

            },
            success: function(data) {
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
            complete: function() {
                window.location.reload();
            },
            error: function() {

            }
        });
    })
    $("#goodChangeSub").unbind("click");
    $("#goodChangeSub").click(function (e){
        $.ajax({
            url: "/key/good/updateGood.json",    //请求的url地址
            dataType: "json",
            async: true,
            data: {
                "goodId":data.id,
                "price":$("#price").val(),
                "number":$("#num").val(),
                "isshelf":$("#state").val()
            },
            type: "get",
            traditional: true,
            beforeSend: function() {

            },
            success: function(data) {
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
                draw(data.data);
            },
            complete: function() {
                window.location.reload();
            },
            error: function() {

            }
        });
    })
    $("#goodModle").modal();
}

function solve(Id){
    $.ajax({
        url: "/key/good/showGood.json",    //请求的url地址
        dataType: "json",
        async: true,
        data: {
            "goodId":Id
        },
        type: "get",
        traditional: true,
        beforeSend: function() {

        },
        success: function(data) {
            if(data.goto!=""){
                window.location.href=data.goto;
            }
            else if(data.msg!=""){
                alert(data.msg);
                return ;
            }
            draw(data.data);
        },
        complete: function() {

        },
        error: function() {

        }
    });
}

function  inint(url){
    if(url=="/key/good/allGood.json"){
        KEY=1;
    }
    else
        KEY=2;
    var table =$("#dataTable").DataTable({
        "lengthChange": false,
        "searching": true,
        "autoWidth": false,
        bJQueryUI:true,
        ajax: {
            url: url,
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
            {"data": "goodname" },
            {"data": "palce"},
            {"data": "state"},
            {"data": "price"},
            {"data": "number"},
            {"data": "point"},
            {"data": "tradeNum"},
            {"data": "judge"}
        ],
    });
    var str = '<div id="state_filter">'+
        '<label>状态查询 : ' +
        '<select class ="select2 col-sm-10">'+
        '<option value ="$">所有</option>'+
        '<option value ="等待审核">等待审核</option><option value ="驳回">驳回</option>'+
        '<option value="上架">上架</option><option value="下架">下架</option>'+
        '</select>'
    '</div>';
    $("#dataTable_wrapper > div:nth-child(1) > div:nth-child(1)").html(str);
    $("#state_filter select").change(function(){
        //alert($(this).val())
        if($(this).val()=="$"){
            table.column(2).search($(this).val(),true,true).draw();
        }
        else
            table.column(2).search($(this).val()).draw();
    })
    $(".select2").select2();

    $('#dataTable tbody').on( 'click', 'tr', function () {
        if ($(this).hasClass('selected') ) {
            var id = table.row( this ).id();
            solve(id)
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
}
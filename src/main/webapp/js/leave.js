function inint(){
    $("#leaveModle").modal("hide");
    var table =$("#dataTable").DataTable({
        "lengthChange": false,
        "searching": true,
        "autoWidth": false,
        bJQueryUI:true,
        ajax: {
            url: "/key/leave/getMyCanDo.json",
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
            {"data": "isRight"},
            {"data": "lever"},
            {"data": "msg"},
            {"data": "create_time"}
        ],
    });
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

function solve(id){
    //alert(id);
    $("#leaveModle").modal();
    $("#leverDoIt").unbind("click");
    $("#leverDoIt").click(function(){
        var L = $("#lever").val();
        var msg = $("#msg").val();
        if(L==-1000||msg ==""){
            alert("好好填写");
            return ;
        }
        $.ajax({
            url: "/key/leave/update.json",    //请求的url地址
            dataType: "json",   //返回格式为json
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data:{
                'id':id,
                'msg':msg,
                'lever':L
            },
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
        })
    })
}
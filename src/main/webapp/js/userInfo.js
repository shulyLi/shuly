

function login(){
    window.location.href="/html/login.jsp";
}
function userDetail(){
    window.location.href="/html/user.jsp";
}
function logout(){
    $.ajax({
        url: "/key/user/signout",    //请求的url地址
        dataType: "json",
        async: true,
        data: {},
        type: "post",
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
        },
        complete: function() {

        },
        error: function() {

        }
    });
}
var  monthArry=new Array();
monthArry=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
function noUser(){
    $("#username1").html("NoLogin");
    $("#username2").html("NoLogin");
    $("#userInfo").attr("onclick","login();");
}
function menueinit(){
    $.ajax({
        url: "/key/user/curUser",    //请求的url地址
        dataType: "json",
        async: true,
        data: {},
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
            data = data.data;

            if(data.id==-1)noUser();
            else {
                $("#username1").html(data.username);
                $("#username2").html(data.username);
                $(".UserPIC").attr("src",data.pic);
                var date = new Date(data.create_time);
                $("#create_time").html("Member since  " + monthArry[date.getMonth()] + "," + date.getFullYear());
            }
        },
        complete: function() {

        },
        error: function() {

        }
    });
    $("#logout").attr("onclick","logout();");
    $("#userDetail").attr("onclick","userDetail();");
}

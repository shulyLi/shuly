

function login(){
    window.location.href="/html/login.jsp";
}
function userDetail(){
    window.location.href="/html/user/user.jsp";
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
function setLever(L){
    if(L==-1) return ;
    $(".LOGINNEED").show()
    if((L&8)!=0) $(".ADMIN").show();
    if((L&2)!=0) $(".TRADER").show();
}
function menueinit(){

    $(".LOGINNEED").hide()

    $(".ADMIN").hide();

    $(".TRADER").hide();

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
            if(data.mail!=0)
                $("#mailNum").append('<span class="label label-primary pull-right">'+data.mail+'</span>')
            if(data.needGrade!=0)
                $("#gradeNum").append('<span class="label label-primary pull-right">'+data.needGrade+'</span>')
            data=data.user;
            if(data.id==-1)noUser();
            else {
                setLever(data.levelr);
                $("#username1").html(data.username);
                $("#username2").html(data.username);
                $(".UserPIC").attr("src",data.pic);
                var date = new Date(data.create_time);
                $("#create_time").html("Member since  " + monthArry[date.getMonth()] + "," + date.getFullYear());
                if( (data.levelr&8)!=0 ) {
                    $("#whatTheFuckerSay a span").text("超级管理员");
                }
                else if( (data.levelr&2)==0 ){
                    $("#whatTheFuckerSay a span").text("成为商人");
                    $("#whatTheFuckerSay").unbind("click");
                    $("#whatTheFuckerSay").click(function () {
                        $("#toBeManModle").modal("show")

                        $("#tobeMan").unbind("click");
                        $("#tobeMan").click(function(){
                            var name =$("#Manname").val();
                            var local=$("#Manlocal").val();
                            var tel =$("#Mantel").val();
                            var file=$("#Mandata").val();
                            if(name==""||local==""||tel==""||file==""){
                                alert("请认真補充数据");
                                return ;
                            }

                            $.ajax({
                                url: '/key/user/toBeMan',
                                type: 'POST',
                                cache: false,
                                data: new FormData($('#Manform')[0]),
                                processData: false,
                                contentType: false,
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
                                complete: function() { window.location.reload();},
                                error: function() {}
                            });
                        })
                    })
                }else{
                    $("#whatTheFuckerSay a span").text("商身份人");
                }
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

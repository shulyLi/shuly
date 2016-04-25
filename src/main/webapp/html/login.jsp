
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Web | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
    <!-- Font Awesome --><!-- Ionicons -->

    <link rel="stylesheet" href="/dist/font-awesome-4.4.0/css/font-awesome.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/dist/ionicons-2.0.1/css/ionicons.css">
        <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/AdminLTE.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="/index.jsp"><b>Web</b>登陆</a>
    </div><!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">帐号登陆</p>
        <form action="/key/user/login" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="text" name = "name" id = 'name'>
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name = "password" id ='pswd'>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> Remember Me
                        </label>
                    </div>
                </div>
                <div class="col-xs-4">
                    <button id ="loginSub" type="button" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
            </div>
        </form>

        <a href="#">shit!忘记密码了</a><br>
        <a href="/html/register.jsp" class="text-center">注册一个账户</a>

    </div><!-- /.login-box-body -->
</div><!-- /.login-box -->

<!-- jQuery 2.1.4 -->
<script src="/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/plugins/iCheck/icheck.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

    $("#loginSub").click(function () {

        var name= $("#name").val();
        var pswd= $("#pswd").val();
        if(name.length<4 || name.length >15){
            alert("名字长度[4,15]");
            return ;
        }
        if(pswd.length<5||pswd.length>20){
            alert("密码长度范围[5,20]")
            return ;
        }
        $.ajax({
            url:'/key/user/login',
            data :{
                "name":name,
                "password":pswd
            },
            dataType:"json",   //返回格式为json
            async:true, //请求是否异步，默认为异步，这也是ajax重要特性
            type:"post",   //请求方式
            traditional:true,
            beforeSend:function() {

            },
            success:function(data) {
                if(data.goto!=""){
                    window.location.href=data.goto;
                }
                else if(data.msg!=""){
                    alert(data.msg);
                    return ;
                }
            },
            complete:function() {
            },
            error:function() {
            }
        });
    })
</script>
</body>
</html>

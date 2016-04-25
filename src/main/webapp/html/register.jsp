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
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href=#"><b>Web</b>注册</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">注册帐号</p>
        <form id ="register"  method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="Full name" id="name" name="name">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">

                <input type="text"  onkeyup="this.value=this.value.replace(/\D/g,'')"
                       onafterpaste="this.value=this.value.replace(/\D/g,'')"
                       class="form-control" placeholder="Telnum" id="telnum" name="telnum">
                <span class="glyphicon  glyphicon-phone-alt form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" id="password" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id = "rewd" placeholder="Retype password" >
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 我同意该<a href="#">协议</a>
                        </label>
                    </div>
                </div><!-- /.col -->
                <div class="col-xs-4">
                    <button id="registerSub" type="button" class="btn btn-primary btn-block btn-flat">注册</button>
                </div><!-- /.col -->
            </div>
        </form>
        <a href="login.jsp" class="text-center">我已經有帐号了</a>
    </div><!-- /.form-box -->
</div><!-- /.register-box -->

<!-- jQuery 2.1.4 -->
<script src="/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    })
    $("#registerSub").click(function(){
        var name = $("#name").val();
        var telNum = $("#telnum").val();
        var pswd1 = $("#password").val();
        var rewd = $("#rewd").val();
        if(name.length<4 || name.length >15){
            alert("名字长度[4,15]");
            return ;
        }
        if(telNum.length!=11){
            alert("我们说的是手机号，谢谢中国大陆地区的手机号是11位");
            return ;
        }
        if(telNum<"130"||telNum>"199"){
            alert("这个号码目前不支持");
            return ;
        }
        if(pswd1 != rewd){
            alert("俩次密码不一样啊");
            return ;
        }
        if(pswd1.length<5||pswd1.length>20){
            alert("密码长度范围[5,20]")
            return ;
        }
        $.ajax( {
            url:'/key/user/register',
            data :{
                "name":name,
                "telnum":telNum,
                "password":pswd1
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

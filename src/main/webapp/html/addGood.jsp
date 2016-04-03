<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-3-28
  Time: 上午9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>addGood</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/js/jquery-2.2.2.min.js" rel="stylesheet" media="screen">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

    <![endif]-->

</head>

<body>
    <div class="container">
        <div class ="col-md-5 col-md-offset-3">
            <form class ="form-horizontal" role="form" enctype="multipart/form-data" method="post"
                action = "/key/good/add">
                    <div class="form-group">
                        <label for="name" >货物名称</label>
                        <input type="text" class="form-control" id="name" name = 'name'placeholder="输入">
                    </div>

                    <div class="form-group">
                        <label for="describe">Textarea</label>
                        <textarea class="form-control" rows="4" id = "describe" name="describe" placeholder="输入"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="pic">File input</label>
                        <input type="file" id="pic" name="pic">
                        <p class="help-block">图片格式PNG和JPG</p>
                    </div>
                    <div class="box-footer">
                        <button type="submit" class="btn btn-default">取消</button>
                        <button type="submit" class="btn btn-info pull-right">提交</button>
                    </div>
            </form>
        </div>
    </div>
    <script src="/js/jquery-2.2.2.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-3-23
  Time: 下午12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.shuly.tool.pojo.User" %>
<%@ page isELIgnored="false" %>
<html>
<meta charset="utf-8">
<head>
    <title>sucess/home/shuly/webShuly/pic</title>
</head>
<body>
<img src="/upload/pic/1459254728385m5szu2016-03-28屏幕截图.png1"  alt="上海鲜花港 - 郁金香" />
yeah
<%
    User user=(User)session.getAttribute("curUser");
    out.print(user.getEmailr());
%>
<p>${_123}</p>
</body>
</html>

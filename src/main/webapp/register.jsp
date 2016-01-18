<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-1-18
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="/register.html" method="get">
    <p>账户号码: <input type="text" name="name" /></p>
    <p>初始密码: <input type="password" name="psword" /></p>
    <p>密码确认: <input type="password" name="psword" /></p>
    <p>邮箱帐号: <input type="email" name="email" /></br>
    <p>电话号码: <input type="tel" name="tel" /></p>
    <p><input type="submit" value="Submit" /></p>
</form>
</body>
</html>

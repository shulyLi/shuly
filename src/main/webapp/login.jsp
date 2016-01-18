<%--
  Created by IntelliJ IDEA.
  User: shuly
  Date: 16-1-18
  Time: 下午3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>login</title>
</head>
<body>
    <h2>login</h2>

    <form action="/login.html" method="get">
        <p>账户: <input type="text" name="name" /></p>
        <p>密码: <input type="password" name="psword" /></p>
        <p><input type="checkbox" , id = "remember",name="remember" /> 记住帐号</p>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>

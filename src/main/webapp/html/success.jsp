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
<meta http-equiv="refresh" content="2;url = /index.jsp">
<head>
    <title>sucess</title>
</head>
<body>
yeah
<%
    User user=(User)session.getAttribute("curUser");
    if(user != null)
        out.print(user.getEmailr());
%>

</body>
</html>

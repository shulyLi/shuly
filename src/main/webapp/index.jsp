<%@ page language="java" contentType="text/html" %>
<html>
<head>
    <title>Browser Check</title>
</head>
<body bgcolor="white">
<%
    /*
    String userAgent = request.getHeader("User-Agent");
    out.println(userAgent);
    System.out.println(userAgent);

    System.out.println(request.getRemoteAddr());
    out.println(request.getRemoteAddr());

    System.out.println(request.getRemoteHost());
    out.println(request.getRemoteHost());

    System.out.println(request.getHeader("x-forwarded-for"));
    out.println(request.getHeader("x-forwarded-for"));
*/

    out.println(request);
    System.out.println(request);

%>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body bgcolor="white">
<%

    String userAgent = request.getHeader("User-Agent");
   // out.println(userAgent);
    System.out.println(userAgent);

    System.out.println(request.getRemoteAddr());
   // out.println(request.getRemoteAddr());

    System.out.println(request.getRemoteHost());
    //out.println(request.getRemoteHost());

    System.out.println(request.getHeader("x-forwarded-for"));
    //out.println(request.getHeader("x-forwarded-for"));
   // out.println(request);
    System.out.println(request);

%>
hi
</body>
</html>

<%--
  User: 月海
  Date: 2018/5/11
  Time: 12:09
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>您好！</title>
</head>
<body>
<h1>登录成功</h1>
<br>
<a href="<%=path%>views/login.jsp">返回</a>
</body>
</html>

<%--
  User: 月海
  Date: 2018/5/11
  Time: 12:04
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<form action="/login.do" method="post">
    <table align="center" border="2">
        <tr>
            <td>用户名：</td>
            <td><input type="text" title="用户名" name="username">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" title="密码" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" title="登录" name="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

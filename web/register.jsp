<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/2
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线考试系统</title>

</head>
<body style="align-content: center">
<form action="/OnlineTestSystem/web/servlet/RegisterServlet" method="post">
    <input name="nick_name" placeholder="请输入用户名"  type="text"  >
    <hr>
    <input name="password"  placeholder="请设置您的密码"  type="password">
    <hr>
    <input name="password2" placeholder="请确认密码"  type="password">
    <hr>
    <input name="email" placeholder="邮箱"  type="email">
    <hr>
    <input value="确认注册" type="submit">
    <hr>
    <a href = "#"><input type = "button" value = "返回" ></a>
    <hr>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/3
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线考试系统</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shj_js/Functions.js"></script>
</head>
<body class="login-bg">
<div class="login layui-anim layui-anim-up">
    <div class="message">在线考试系统登录</div>
        <div id="darkbannerwrap"></div>
        <form id='form' class="layui-form" action="${pageContext.request.contextPath}/LoginServlet" method="post" onsubmit="return checkLoginForm('${pageContext.request.contextPath}')">
            <input id="email"  name="email" placeholder="请输入您的注册邮箱"  type="email" lay-verify="required" class="layui-input" >
            <span id="email_tip" style="font-size: small; color: #FF5722"></span>
            <hr class="hr15">
            <input id="password" name="password" lay-verify="required" placeholder="请输入密码"  type="password" class="layui-input">
            <span id="password_tip" style="font-size: small; color: #FF5722"></span>
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
            <a href = "${pageContext.request.contextPath}/client/register.jsp"><input type = "button" value = "注册"  class = "layui-btn layui-btn-fluid"></a>
            <hr class="hr20" >
        </form>
    </div>
</body>
</html>

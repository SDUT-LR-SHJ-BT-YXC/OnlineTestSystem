<%--
  Created by IntelliJ IDEA.
  User: shangjin
  Date: 2019-12-08
  Time: 17:59
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shj_js/Ajax_Functions.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shj_js/Functions.js"></script>
</head>
<script>
    $(function () {
        layui.use("layer", function () {
            var layer = layui.layer;
            layer.msg("我们向您的邮箱发送了一个验证码用于密码修改，请注意查收");
        })
    })
</script>
<body class="login-bg">
<span id="code" style="display: none">${sessionScope.code}</span>
<div class="login layui-anim layui-anim-up" style="margin-top:25px;">
    <div class="message">修改密码</div>
    <div id="darkbannerwrap"></div>
    <form id="form" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/ChangePasswordServlet2" method="post" onsubmit="return checkChangePasswordForm()">
        <input name="code" placeholder="请输入验证码"  type="text" lay-verify="required" class="layui-input" >
        <span id="code_tip" style="font-size: small; color: #FF5722"></span>
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="请输入新密码"  type="password" class="layui-input">
        <span id="password1_tip" style="font-size: small; color: #FF5722"></span>
        <hr class="hr15">
        <input name="password2" lay-verify="required" placeholder="请确认新密码"  type="password" class="layui-input">
        <span id="password2_tip" style="font-size: small; color: #FF5722"></span>
        <hr class="hr15">
        <input value="确定" id="submit" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
        <a href = "${pageContext.request.contextPath}/client/personpage.jsp"><input type = "button" value = "返回"  class = "layui-btn layui-btn-fluid"></a>
        <hr class="hr20" >
    </form>
</div>
</body>
</html>

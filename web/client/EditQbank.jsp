<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/19
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改题库</title>
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

</head>
<body class="login-bg">
<div class="login layui-anim layui-anim-up">
    <div class="message">修改题库</div>
    <div id="darkbannerwrap"></div>
    <form id="form" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/EditQbankServlet2" method="post" onsubmit="return checkChangePasswordForm()">
        <label class="layui-form-label">题库ID</label>
        <input disabled="disabled" name="qbank_id" value="${ManageQbank.getQbankId()}"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <label class="layui-form-label">题库名称</label>
        <input name="qname" value="${ManageQbank.getName()}"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">

        <input value="确定" id="submit" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
        <a href = "${pageContext.request.contextPath}/client/ManageQbank.jsp"><input type = "button" value = "返回"  class = "layui-btn layui-btn-fluid"></a>
        <hr class="hr20" >
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ShangJin
  Date: 2019/12/23
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统个人首页</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body style="min-width: 1300px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item " style="margin: 0px 5%">
            <a href="">成绩分析</a>
        </li>
        <li class="layui-nav-item" >
            <a href="${pageContext.request.contextPath}/client/showqbank.jsp">在线测试</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/WrongAnswerRecordServlet">错题记录</a>
        </li>
        <li class="layui-nav-item layui-this" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/aboutus.jsp">关于我们</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/DownloadServlet">题库下载<span class="layui-badge-dot"></span></a>
        </li>
        <li class="layui-nav-item" lay-unselect="" style="float: right">
            <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="${pageContext.request.contextPath}/ChangePasswordServlet">修改密码</a></dd>
                <dd><a href="${pageContext.request.contextPath}/LogoutServlet">退了</a></dd>
            </dl>
        </li>
    </ul>
</div>

<div style="background-color: #393D49; height: 290px">
    <div style="padding: 30px 0">
        <p style="font-size: 30px; color: white" align="center">在线答题系统</p>
        <P style="position:relative; top: 30px; color: white;" align="center">本系统可实现在线测试、成绩分析、错题记录、题库管理。</P>
    </div>
    <div class="layui-card" style="width: 240px; float: left; position: relative; top: 60px; left: 400px">
        <div class="layui-card-header" style="margin: 0 auto">
            <img src="${pageContext.request.contextPath}/img/email.png" style="width:20px; height: 20px; ">
            <span>我们的邮箱</span>
        </div>
        <div class="layui-card-body">
            <p align="center">zaixianceshi@163.com</p>
        </div>
    </div>
    <div class="layui-card" style="width: 240px; float: right; position: relative; top: 60px; right: 400px" >
        <div class="layui-card-header" style="margin: 0 auto">
            <img src="${pageContext.request.contextPath}/img/penguin.png" style="width:20px; height: 20px; ">
            <span>QQ联系</span>
        </div>
        <div class="layui-card-body">
            <p align="center">20191227</p>
        </div>
    </div>
</div>

<div style="margin: 0 auto; padding-top: 30px">
    <p style="font-size: 20px; color: #01AAED" align="center">我们的特点</p>
    <div style="width: 1000px;height: 300px; margin: 0 auto; padding-top: 30px; ">
        <div class="layui-card" style="width: 200px; float: left;  margin-left: 100px; background-color:#eeeeee">
            <div class="layui-card-header">操作简单</div>
            <div class="layui-card-body">
                用户操作简单，只需简单动动手指即可使用<br>
                本系统满足您的日常需求
            </div>
        </div>
        <div class="layui-card" style="width: 200px; float: left; margin-left: 100px;  background-color:#eeeeee">
            <div class="layui-card-header">方便快捷</div>
            <div class="layui-card-body">
                在线测试秒出成绩，测试后即可查看结果<br>
                以及错题分析
            </div>
        </div>
        <div class="layui-card" style="width: 200px; float: left; margin-left: 100px;  background-color:#eeeeee">
            <div class="layui-card-header">直观明了</div>
            <div class="layui-card-body">
                在线考试系统综合分析考试成绩，错题全部记录<br>
                便于复习查漏补缺
            </div>
        </div>
    </div>


</div>








<!-- footer ---->
<div style="height: auto; padding-top: 20px; padding-bottom: 20px; width:100%;position: fixed; bottom: 0px" class="layui-bg-gray">

    <div style="margin: 0 auto; width:100%; text-align: center">
        All Rights Reserved.
    </div>
</div>
</body>
<script>
    <!-- 加载element模块 -->
    layui.use('element', function(){
        var element = layui.element;
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/12
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统下载中心</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body>
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/personpage.jsp">成绩分析</a>
        </li>
        <li class="layui-nav-item" >
            <a href="${pageContext.request.contextPath}/client/showqbank.jsp">在线测试</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/WrongAnswerRecordServlet">错题记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/aboutus.jsp">关于我们</a>
        </li>
        <li class="layui-nav-item layui-this" style="margin: 0px 5%">
            <a href="#">题库下载</a>
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
<div class="layui-container " style="margin-top:40px;height:100%;">
    <table class="layui-table" lay-even lay-skin="row" lay-size="lg">
        <tr>
            <th style="background-color:#DCDCDC;text-align:center;"><font size=4px;>题库类型</font></th>
            <th style="background-color:#DCDCDC;text-align:center;"><font size=4px;>下载</font></th>

        </tr>
        <c:forEach var = "qbank" items="${DownQbank}" >
            <tr>
                <th>${qbank.getName()}</th>
                <th><a class="layui-btn" href="${pageContext.request.contextPath}/DownloadServlet2?qbank_id=${qbank.getQbankId() }" target="_blank">点击下载</a></th>
            </tr>
        </c:forEach>


    </table>
    <br>
    <br>
    <hr class="layui-bg-green">
    <h3 style="text-align:center;color:#B22222;">更多题库敬请期待！</h3>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统错题记录</title>
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
        <li class="layui-nav-item layui-this" style="margin: 0px 5%">
            <a href="#">错题记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">关于我们</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/download.jsp">题库下载<span class="layui-badge-dot"></span></a>
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

    <div class="containt">
        <div class="layui-tab layui-tab-card" style="text-align: center">
            <ul class="layui-tab-title">
                <li class="layui-this">错题总览</li>
                <li>错题详情</li>
            </ul>
            <div class="layui-tab-content" style="height: 100px;">
                <div class="layui-tab-item layui-show" style="align-content: center; width: 70%;margin-left: 13%;margin-top: 1.5%;">
                    <p class="pfont" style="font-size: 18px;">单选题</p>
                    <div class="layui-progress layui-progress-big" lay-showpercent="true" style="margin-top: 11px;">
                        <div class="layui-progress-bar" lay-percent="${WAsum.get(0)} / ${Qsum.get(0)}"></div>
                    </div>
                    <p class="pfont" style="font-size: 18px; margin-top: 51px;">多选题</p>
                    <div class="layui-progress layui-progress-big" lay-showpercent="true" style="margin-top: 11px;">
                        <div class="layui-progress-bar layui-bg-orange" lay-percent="${WAsum.get(1)} / ${Qsum.get(1)}"></div>
                    </div>
                    <p class="pfont" style="font-size: 18px;margin-top: 51px">填空题</p>
                    <div class="layui-progress layui-progress-big" lay-showpercent="true" style="margin-top: 11px;">
                        <div class="layui-progress-bar layui-bg-blue" lay-percent="${WAsum.get(2)} / ${Qsum.get(2)}"></div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-container " style="margin-top:60px;height:100%;">

                        <table class="layui-table" lay-even lay-skin="row" lay-size="lg">
                            <tr>
                                <th style="background-color:#f6cec1;text-align:center;"><font size=4px;>题库ID</font></th>
                                <th style="background-color:#f6cec1;text-align:center;"><font size=4px;>题库名称</font></th>
                                <th style="background-color:#f6cec1;text-align:center;"><font size=4px;>题库总数</font></th>
                                <th style="background-color:#f6cec1;"></th>
                            </tr>

                            <c:forEach var = "WAqbank" items="${WAqbanks}" >
                                <tr>

                                    <th>${WAqbank.getQbankId()}</th>
                                    <th>${WAqbank.getName()}</th>
                                    <th>${WAqbank.getSingleChoiceNum()+WAqbank.getMultipleChoiceNum()+WAqbank.getBlanksNum() }</th>
                                    <th><a class="layui-btn" href="${pageContext.request.contextPath}/ShowWAServlet?qbank_id=${WAqbank.getQbankId() }" target="_blank">查看详情</a></th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

            </div>
            <script>

                layui.use('element', function(){
                    var element = layui.element;

                    //…
                });
            </script>
        </div>
    </div>
</body>
</html>


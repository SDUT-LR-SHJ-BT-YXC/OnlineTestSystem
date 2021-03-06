<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/12
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统错题详情</title>
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
            <a href="${pageContext.request.contextPath}/client/aboutus.jsp">关于我们</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/DownloadServlet">题库下载</a>
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
<div class="layui-container" style="margin-top: 20px;">
    <hr class="layui-bg-green" style="padding-top: 6px;">
    <h3 style="text-align:center;color:#B22222;">单选题</h3>
    <div class="layui-collapse" lay-accordion>
        <c:forEach var = "single" items="${ShowWAS}" >
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">${single.getQuestion_text()}</h2>
                <div class="layui-colla-content layui-show">
                A.${single.getAnswer1()}<br>
                B.${single.getAnswer2()}<br>
                C.${single.getAnswer3()}<br>
                D.${single.getAnswer4()}<br>
                您的答案为：&nbsp;&nbsp;&nbsp;&nbsp;${single.getWrong_answer()}<br>
                答题时间：&nbsp;&nbsp;&nbsp;&nbsp;${single.getTime()}
                </div>
            </div>
        </c:forEach>
    </div>
    <hr class="layui-bg-green" style="padding-top: 6px;">
    <h3 style="text-align:center;color:#B22222;">多选题</h3>
    <div class="layui-collapse" lay-accordion>
        <c:forEach var = "single" items="${ShowWAM}" >
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">${single.getQuestion_text()}</h2>
                <div class="layui-colla-content layui-show">
                        A.${single.getAnswer1()}<br>
                        B.${single.getAnswer2()}<br>
                        C.${single.getAnswer3()}<br>
                        D.${single.getAnswer4()}<br>
                    您的答案为：&nbsp;&nbsp;&nbsp;&nbsp;${single.getWrong_answer()}<br>
                    答题时间：&nbsp;&nbsp;&nbsp;&nbsp;${single.getTime()}
                </div>
            </div>
        </c:forEach>
    </div>

    <hr class="layui-bg-green" style="padding-top: 6px;">
    <h3 style="text-align:center;color:#B22222;">填空题</h3>
    <div class="layui-collapse" lay-accordion>
        <c:forEach var = "single" items="${ShowWAB}" >
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">${single.getQuestion_text()}</h2>
                <div class="layui-colla-content layui-show">

                    您的答案为：&nbsp;&nbsp;&nbsp;&nbsp;${single.getWrong_answer()}<br>
                    答题时间：&nbsp;&nbsp;&nbsp;&nbsp;${single.getTime()}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

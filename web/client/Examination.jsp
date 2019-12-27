<%--
  Created by IntelliJ IDEA.
  User: shangjin
  Date: 2019-12-04
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>在线测试</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/examination.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
    <script>
        $(function () {
            if(${empty sessionScope.endtime}){
                endExamimationMsg('${pageContext.request.contextPath}');
            }else{
                var date= new Date().getTime();
                var times = (${sessionScope.endtime} - date) / 1000;
                var interval = setInterval(function () {
                    if(times <= 0){
                        submitExamination($("#form"), '${pageContext.request.contextPath}');
                        clearInterval(interval);
                    }
                    $("#time").text("时间还剩：" + parseInt(times / 60) + "分" + parseInt(times) % 60 + "秒");
                    times -= 1;
                }, 1000);
            }
        });
    </script>
</head>
<body style="min-width: 1400px;">

<!-- 导航栏  -->
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item"  >
            <a href="#">在线测试</a>
        </li>
    </ul>
</div>

<!-- 显示试卷 --->
<div style="width: 80%; height: auto;margin: 0 auto">
    <div>
        <!--  倒计时 -->
        <div style="height: 30px;margin-bottom: 15px" >
            <div style="width: 300px;margin: 10px auto; font-size: 23px"><b>${sessionScope.paper.qbankname}</b>在线测试</div>
        </div>
        <div class="clearfix" style=" height:50px;  padding-right: 350px">
            <span id="time" style="float: right"></span>
        </div>

        <!--  试卷内容  -->
        <form action="${pageContext.request.contextPath}/CheckAnswerServlet" id="form" class="layui-form" method="post">
            <c:set var="bnum" value="${sessionScope.paper.blanktests.size()}"></c:set>
            <c:set var="snum" value="${sessionScope.paper.singlechoices.size()}"></c:set>
            <c:set var="mnum" value="${sessionScope.paper.multiplechoices.size()}"></c:set>
            <div style="width: 70%; margin: 0 auto;">
                <!---   填空题 ---->
                <c:forEach items="${sessionScope.paper.blanktests}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${status.count}.${test.questionText} <span style="font-style: oblique; color: #d2d2d2">&nbsp;&nbsp;&nbsp;[2分]</span></blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm" style="height: 30px;">
                        <span>答：</span>
                        <input type="text" name="b${status.index}"  placeholder="请输入答案" autocomplete="off" class="layui-input" style="width:95%;display: inline; ">
                    </blockquote>
                </c:forEach>

                <!-- 单选题 ---->
                <c:forEach items="${sessionScope.paper.singlechoices}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${bnum + status.count}.（单选）${test.questionText} <span style="font-style: oblique; color: #d2d2d2">&nbsp;&nbsp;&nbsp;[3分]</span></blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm"  style="padding: 5px 15px">
                        <div class="layui-form-item" style="margin-bottom: 0px">
                            <div class="layui-input-block" style="margin-left: 0px">
                                <input type="radio" name="s${status.index}" value="A" title="A.${test.answer1}">
                                <input type="radio" name="s${status.index}" value="B" title="B.${test.answer2}" >
                                <input type="radio" name="s${status.index}" value="C" title="C.${test.answer3}">
                                <input type="radio" name="s${status.index}" value="D" title="D.${test.answer4}">
                            </div>
                        </div>
                    </blockquote>
                </c:forEach>

                <!-- 多选题 -->
                <c:forEach items="${sessionScope.paper.multiplechoices}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${bnum + snum + status.count}.（多选）${test.questionText} <span style="font-style: oblique; color: #d2d2d2">&nbsp;&nbsp;&nbsp;[5分]</span></blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm"  style="padding: 5px 15px">
                        <div class="layui-form-item" style="margin-bottom: 0px;">
                            <div class="layui-input-block" style="margin-left: 0px;">
                                <input type="checkbox" style="line-height: 30px" name="m${status.index}" value="A" title="A.${test.answer1}" lay-skin="primary">
                                <input type="checkbox" style="line-height: 30px" name="m${status.index}" value="B" title="B.${test.answer2}" lay-skin="primary">
                                <input type="checkbox" style="line-height: 30px" name="m${status.index}" value="C" title="C.${test.answer3}" lay-skin="primary">
                                <input type="checkbox" style="line-height: 30px" name="m${status.index}" value="D" title="D.${test.answer4}" lay-skin="primary">
                            </div>
                        </div>
                    </blockquote>
                </c:forEach>
                
            </div>

            <div style="margin: 50px auto">
                <div class="layui-input-block" style="width: 15%; margin: 0 auto" >
                    <button id="submitbtn" type="button" class="layui-btn" onclick="confirmSubmit('#form')">提交试卷</button>
<%--                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>--%>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            return true;
        });
    });
</script>
</html>

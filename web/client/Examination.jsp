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
    <title>Title</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/examination.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
    <script>
        $(function () {
            var times = 30 * 60;
            var interval = setInterval(function () {
                if(times <= 0){
                    submitExamination($("#form"), '${pageContext.request.contextPath}');
                    clearInterval(interval);
                }
                $("#time").text("时间还剩：" + parseInt(times / 60) + "分" + times % 60 + "秒");
                times -= 1;
            }, 1000);
        });
    </script>
</head>
<body>
<div style="width: 100%; height: auto; min-width:1100px">
    <div class="layui-header" >
        <ul class="layui-nav">
            <li class="layui-nav-item"  >
                <a href="${pageContext.request.contextPath}/ShowQbankServlet">在线测试</a>
            </li>
        </ul>
    </div>
    <div>
        <div style="height: 30px;margin-bottom: 15px" >
            <div style="width: 150px;margin: 10px auto; font-size: 23px"><b>XX</b>在线测试</div>
        </div>
        <div class="clearfix" style=" height:50px;  padding-right: 350px">
            <span id="time" style="float: right"></span>
        </div>

        <!--  试卷内容  -->
        <form action="/" id="form" class="layui-form">
            <c:set var="bnum" value="${sessionScope.paper.blanktests.size()}"></c:set>
            <c:set var="snum" value="${sessionScope.paper.singlechoices.size()}"></c:set>
            <c:set var="mnum" value="${sessionScope.paper.multiplechoices.size()}"></c:set>
            <div style="width: 70%; margin: 0 auto;">
                <!---   填空题 ---->
                <c:forEach items="${sessionScope.paper.blanktests}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${status.count}.${test.questionText}</blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm" style="height: 30px;">
                        <span>答：</span>
                        <input type="text" name="b${status.index}" required  lay-verify="required" placeholder="请输入答案" autocomplete="off" class="layui-input" style="width:95%;display: inline; ">
                    </blockquote>
                </c:forEach>

                <!-- 单选题 ---->
                <c:forEach items="${sessionScope.paper.singlechoices}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${bnum + status.count}.${test.questionText}</blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <div class="layui-form-item" style="height: 15px">
                            <div class="layui-input-block" style="margin-left: 0px">
                                <input type="radio" name="s${status.index}" value="A" title="${test.answer1}">
                                <input type="radio" name="s${status.index}" value="B" title="${test.answer2}" >
                                <input type="radio" name="s${status.index}" value="C" title="${test.answer3}">
                                <input type="radio" name="s${status.index}" value="D" title="${test.answer4}">
                            </div>
                        </div>
                    </blockquote>
                </c:forEach>

                <!-- 多选题 -->
                <c:forEach items="${sessionScope.paper.multiplechoices}" var="test" varStatus="status">
                    <blockquote class="layui-elem-quote">${bnum + snum + status.count}.${test.questionText}</blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <div class="layui-form-item" style="height: 15px">
                            <div class="layui-input-block" style="margin-left: 0px">
                                <input type="checkbox" name="b${status.index}" value="A" title="A.${test.answer1}" lay-skin="primary" >
                                <input type="checkbox" name="b${status.index}" value="B" title="B.${test.answer2}" lay-skin="primary">
                                <input type="checkbox" name="b${status.index}" value="C" title="C.${test.answer3}" lay-skin="primary">
                                <input type="checkbox" name="b${status.index}" value="D" title="D.${test.answer4}" lay-skin="primary">
                            </div>
                        </div>
                    </blockquote>
                </c:forEach>
            </div>
            <div style="margin: 50px auto">
                <div class="layui-input-block" style="width: 15%; margin: 0 auto" >
                    <button type="submit" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>

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
    <title>测试结果</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/examination.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<script>
    console.log(${empty sessionScope.endtime});
    $(document).ready(function(e) {
        //禁止回退
        var counter = 0;
        if (window.history && window.history.pushState) {
            $(window).on('popstate', function () {
                window.history.pushState('forward', null, '#');
                //window.location.href="ad.html";   // 回退时跳转到新页面
                window.history.forward(1);
                msg(0, '我看到你了',"不要动小心思呦(^_−)☆");
            });
        }
        window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
        window.history.forward(1);
    });
</script>
<body style="min-width: 1024px; min-height: 790px">
<div style="width: 100%; height: auto; min-width:1100px">
    <div class="layui-header" >
        <ul class="layui-nav">
            <li class="layui-nav-item"  >
                <a href="">在线测试</a>
            </li>
        </ul>
    </div>
    <div>
        <div style="height: 30px;margin-bottom: 15px" >
            <div style="width: 150px;margin: 10px auto; font-size: 23px"><b>${sessionScope.paper.qbankname}</b>在线测试</div>
        </div>
        <div class="clearfix" style=" height:50px;  padding-right: 350px">
            <span style=" float: right; color: #FF5722; font-family:华文楷体; font-size: 25px">
                分数：${sessionScope.analyse.score}
            </span>
        </div>

        <!--  试卷内容  -->
        <form action="#" id="form" class="layui-form">
            <c:set var="bnum" value="${sessionScope.paper.blanktests.size()}"></c:set>
            <c:set var="snum" value="${sessionScope.paper.singlechoices.size()}"></c:set>
            <c:set var="mnum" value="${sessionScope.paper.multiplechoices.size()}"></c:set>
            <div style="width: 70%; margin: 0 auto;">
                <!---   填空题 ---->
                <c:forEach items="${sessionScope.paper.blanktests}" var="test" varStatus="status">
                    <c:set var="i" value="${status.index}"></c:set>
                    <blockquote class="layui-elem-quote">${status.count}.${test.questionText}
                        <span style="position: relative; left: 20px; color: #FF5722">${sessionScope.rawbanswer[i] == test.stdAnswer ? "(√)": "(×)"}</span>
                    </blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm" style="height: 30px;">
                        <span>你的答案：</span>
                        <span>${sessionScope.rawbanswer[i]}</span><p></p>
                        <span style="color: #FF5722">正确答案：</span>
                        <span style="color: #FF5722">${test.stdAnswer}</span>
                    </blockquote>
                </c:forEach>

                <!-- 单选题 ---->
                <c:forEach items="${sessionScope.paper.singlechoices}" var="test" varStatus="status">
                    <c:set var="i" value="${status.index}"></c:set>
                    <blockquote class="layui-elem-quote">${bnum + status.count}.${test.questionText}
                        <span style="position: relative; color: #FF5722">${sessionScope.rawsanswer[i] == test.stdAnswer ? "(√)": "(×)"}</span>
                    </blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm" style="padding: 7px 15px">
                        <div class="layui-form-item" style="height: 15px; margin-bottom: 20px">
                            <div class="layui-input-block" style="margin-left: 0px">
                                <input type="radio" name="s${status.index}" value="A" title="${test.answer1}">
                                <input type="radio" name="s${status.index}" value="B" title="${test.answer2}" >
                                <input type="radio" name="s${status.index}" value="C" title="${test.answer3}">
                                <input type="radio" name="s${status.index}" value="D" title="${test.answer4}">
                            </div>
                        </div>
                        <div>
                            <span >你的答案：</span>
                            <span>${sessionScope.rawsanswer[i]}</span><p></p>
                            <span style="color: #FF5722">正确答案：</span>
                            <span style="color: #FF5722">${test.stdAnswer}</span>
                        </div>
                    </blockquote>
                </c:forEach>

                <!-- 多选题 -->
                <c:forEach items="${sessionScope.paper.multiplechoices}" var="test" varStatus="status">
                    <c:set var="i" value="${status.index}"></c:set>
                    <blockquote class="layui-elem-quote">${bnum + snum + status.count}.${test.questionText}
                        <span style="position: relative; left: 20px; color: #FF5722">${sessionScope.rawmanswer[i] == test.stdAnswer ? "(√)": "(×)"}</span>
                    </blockquote>
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <div class="layui-form-item" style="height: 15px; margin-bottom: 20px">
                            <div class="layui-input-block" style="margin-left: 0px">
                                <input type="checkbox" name="b${status.index}" value="A" title="A.${test.answer1}" lay-skin="primary" >
                                <input type="checkbox" name="b${status.index}" value="B" title="B.${test.answer2}" lay-skin="primary">
                                <input type="checkbox" name="b${status.index}" value="C" title="C.${test.answer3}" lay-skin="primary">
                                <input type="checkbox" name="b${status.index}" value="D" title="D.${test.answer4}" lay-skin="primary">
                            </div>
                        </div>
                        <div>
                            <span >你的答案：</span>
                            <span>${sessionScope.rawmanswer[i]}</span><p></p>
                            <span style="color: #FF5722">正确答案：</span>
                            <span style="color: #FF5722">${test.stdAnswer}</span>
                        </div>
                    </blockquote>
                </c:forEach>
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
            return true;
        });
    });
</script>
</body>
</html>
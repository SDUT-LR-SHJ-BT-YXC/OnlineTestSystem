<%--
  Created by IntelliJ IDEA.
  User: shangjin
  Date: 2019-12-03
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择题库</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body style="min-width: 1024px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item " style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/personpage.jsp">成绩分析</a>
        </li>
        <li class="layui-nav-item layui-this" >
            <a href="${pageContext.request.contextPath}/client/showqbank.jsp">在线测试</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/WrongAnswerRecordServlet">错题记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">关于我们</a>
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

<!-- 展示所有科目的表格 --->
<div style="width: 1300px; height: 500px; margin: 50px auto">
    <table id="qbank_table" lay-filter="test"></table>
</div>


<!-- footer ---->
<div style="height: auto; padding-top: 20px; padding-bottom: 20px; width:100%;position: absolute; bottom: 0px" class="layui-bg-gray">

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

    /***   填充所有科目表格 ***/
    layui.use("table", function () {
        var table = layui.table;
        //执行渲染
        table.render({
            elem: '#qbank_table' //指定原始表格元素选择器（推荐id选择器）
            ,height: 450 //容器高度
            ,url: '${pageContext.request.contextPath}/ShowQbankServlet'
            ,page:true
            ,even:true
            ,cols: [
                [ //表头
                    {field: 'qbankId', title: 'ID', width:200, sort: true, fixed: 'left'}
                    ,{field: 'name', title: '题库名', width:200}
                    ,{field: 'singleChoiceNum', title: '单选题数目', width:200, sort: true}
                    ,{field: 'multipleChoiceNum', title: '多选题数目', width:200}
                    ,{field: 'blanksNum', title: '填空题数', width: 200}
                    ,{field: '', title: '操作', width: 300, templet: '#titleTpl'}
                ]
            ] //设置表头
        });
    })
</script>

<!-- 数据表格操作列引用模板  -->
<script type="text/html" id="titleTpl">
    <button class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="confirmExamination('${pageContext.request.contextPath}/ExaminationServlet?id={{d.qbankId}}')" >
        开始测试
    </button>
</script>
</html>

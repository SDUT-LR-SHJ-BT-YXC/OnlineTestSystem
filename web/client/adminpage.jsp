<%--
  Created by IntelliJ IDEA.
  User: yinxiaochen
  Date: 2019/12/16
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线答题系统管理员首页</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body style="min-width: 1026px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item layui-this" style="margin: 0 5%">
            <a href="#">操作记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/usermanagement.jsp">用户管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="#">题库管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="#">习题管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="#">导入习题</a>
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
<!-- 展示操作记录的表格 --->
<div style="width: 1300px; height: 500px; margin: 50px auto">
    <table id="OperationLog_table" lay-filter="test"></table>
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

    /***   填充所有科目表格 ***/
    layui.use("table", function () {
        var table = layui.table;
        //执行渲染
        table.render({
            elem: '#OperationLog_table' //指定原始表格元素选择器（推荐id选择器）
            ,height: 450 //容器高度
            ,url: '${pageContext.request.contextPath}/OperationLogServlet'
            ,page:true
            ,even:true
            ,cols: [
                [ //表头
                    {field: 'qbankId', title: '时间', width:150, sort: true, fixed: 'left'}
                    ,{field: 'name', title: '操作者', width:150}
                    ,{field: 'blanksNum', title: '操作', width: 1000}
                ]
            ] //设置表头
        });
    })
</script>
</body>
</html>
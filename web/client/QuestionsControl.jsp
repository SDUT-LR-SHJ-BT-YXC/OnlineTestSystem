<%--
  Created by IntelliJ IDEA.
  User: yinxiaochen
  Date: 2019/12/24
  Time: 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>习题管理</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
    <style>
        .TypeChoice label{
            width: 120px;
            height: 30px;
            line-height: 30px;
            font-size: 14px;
        }
        .TypeChoice input:checked + span {
            font-weight: bold;
            font-size: 18px;

        }
    </style>
    <script>

    </script>
</head>
<body style="min-width: 1026px; min-height: 650px">

<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/adminpage.jsp">用户管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/ManageQbank.jsp">题库管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/QuestionsControl.jsp">习题管理</a>
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

<!-- 表格上方选项 -->
<div style="margin: 20px auto; width: 1300px; margin-bottom: 10px;" class="TypeChoice">
    <label class="layui-btn layui-btn-sm"><input type="radio" hidden name="QuestionType" value="单选题" checked="checked"><span>单选题</span></label>
    <label class="layui-btn layui-btn-sm"><input type="radio" hidden  name="QuestionType" value="多选题"><span>多选题</span></label>
    <label class="layui-btn layui-btn-sm"><input type="radio" hidden  name="QuestionType" value="填空题"><span>填空题</span></label>
    <div style="float: right; margin-right: 100px;">
        <div class="layui-inline" style="margin-left: 50px;margin-right: 10px;">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="输入题库">
        </div>
        <button class="layui-btn" data-type="reload" style="margin-right: 50px;">搜索</button>
        <div class="layui-inline" style="margin-right: 10px;">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="输入题干">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>

</div>

<!-- 展示操作记录的表格 -->
<div style="width: 1300px; height: 500px; margin: auto">
    <table id="OperationLog_table" lay-filter="test"></table>
</div>


<!-- footer ---->
<div style="height: auto; padding-top: 20px; padding-bottom: 20px; width:100%;position: fixed; bottom: 0" class="layui-bg-gray">

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
            ,height: 500 //容器高度
            ,url: '${pageContext.request.contextPath}/UsermanagementServlet'
            ,page:true
            ,even:true
            ,cols: [
                [ //表头
                    {field: 'userId', title: 'ID', width:50, fixed: 'left', align:"center", unresize:"false"}
                    ,{field: 'power', title: '题库', width:200, fixed: 'left'}
                    ,{field: 'nickName', title: '昵称', width: 200}
                    ,{field: 'email', title: '邮箱', width: 600}
                    ,{field: '', title: '操作', width: 200, templet: '#titleTpl'}
                ]
            ] //设置表头
        });
    })
</script>

<!-- 数据表格操作列引用模板  -->
<script type="text/html" id="titleTpl">
    <button class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="confirmChangeRole('${pageContext.request.contextPath}/ChangeRoleServlet?id={{d.userId}}', '{{d.nickName}}', '{{d.power}}')">变更权限</button>
</script>

</body>
</html>

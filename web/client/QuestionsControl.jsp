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
        .layui-tab{
            width: 1300px;
            margin: 20px auto;
        }
    </style>
    <script>
        function confirmDelete(context) {
            layer.open({
                title: '警告'
                ,content: '确定要删除此试题？'
                ,btn: ['确定', '取消']
                ,btn1: function(index, layero){
                    location.href = context;
                }
            })
        }
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

<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">单选题</li>
        <li>多选题</li>
        <li>填空题</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <!-- 表格上方选项 -->
            <div style="margin-left: 1000px; width: 300px; margin-bottom: 10px;">
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="singleReload" autocomplete="off" placeholder="输入题干">
                </div>
                <button class="layui-btn" data-type="reload" id="searchsingle">搜索</button>
            </div>

            <!-- 展示操作记录的表格 -->
            <div style="width: 1300px; height: 450px; margin: auto">
                <table id="single_table" lay-filter="single_table"></table>
            </div>
        </div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
    </div>
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
    /***   填充全部表格 ***/
    layui.use("table", function () {
        var table = layui.table;
        //执行渲染
        //单选表格
        table.render({
            elem: '#single_table' //指定原始表格元素选择器（推荐id选择器）
            ,height: 450 //容器高度
            ,url: '${pageContext.request.contextPath}/SingleControlServlet'
            ,page:true
            ,even:true
            ,id:'single_table'
            ,cols: [
                [ //表头
                    {field: 'squestionId', title: 'ID', width:50, fixed: 'left', align:"center", unresize:"false"}
                    ,{field: 'qbankId', title: '题库ID', width: 100}
                    ,{field: 'name', title: '题库', width: 100}
                    ,{field: 'questionText', title: '题干', width: 200}
                    ,{field: 'answer1', title: '选项A', width: 150}
                    ,{field: 'answer2', title: '选项B', width: 150}
                    ,{field: 'answer3', title: '选项C', width: 150}
                    ,{field: 'answer4', title: '选项D', width: 150}
                    ,{field: 'stdAnswer', title: '正确答案', width: 150}
                    ,{field: '', title: '操作', width: 100, templet: '#singleTpl'}
                ]
            ] //设置表头
        });
        //单选搜索
        $("#searchsingle").click(function () {
            table.reload('single_table', {
                where: { //设定异步数据接口的额外参数，任意设
                    qtext: $('#singleReload').val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
    });
    layui.use('table', function(){
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(single_table)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            editQuestion('${pageContext.request.contextPath}', 'single', '1', '1', '1');
            layer.msg('[题目ID: '+ data.squestionId +'] ' + field + ' 字段更改为：'+ value);
        });
    });
</script>

<!-- 数据表格操作列引用模板  -->
<script type="text/html" id="singleTpl">
    <button class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="confirmDelete('${pageContext.request.contextPath}/DeleteQuestionServlet?id={{d.squestionId}}&type=single&qbankid={{d.qbankId}}')">删除</button>
</script>

</body>
</html>

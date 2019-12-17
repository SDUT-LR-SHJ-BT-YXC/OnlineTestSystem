<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/16
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>试题库管理</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,data:<%=request.getSession().getAttribute("Qbankjson") %>
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['', '', '', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: ''
            }]
            ,title: '用户数据表'
            ,cols: [[ //标题栏
                {field:'qbankId', title:'题库ID', width:140, sort: true}
                ,{field:'name', title:'题库名称', width:250}
                ,{field:'singleChoiceNum', title:'单选题总数', width:140, sort: true}
                ,{field:'multipleChoiceNum', title:'多选题总数', width:140, sort: true}
                ,{field:'blanksNum', title:'填空题总数', width:328, sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:140}
            ]]
            ,page: true
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('确认要删除此题库？', function(index){
                    var value = data.qbankId;
                    document.location.href="/${pageContext.request.contextPath}/DelQankServlet?qbankId="+value;

                    //layer.close(index);yinggai
                })
            }
            else if(obj.event === 'edit'){
                var value = data.qbankId;
                document.location.href="/${pageContext.request.contextPath}/EditQankServlet?qbankId="+value;
                /*
                layer.prompt({
                  formType: 2
                  ,value: data.email
                }, function(value, index){
                  obj.update({
                    email: value
                  });
                  layer.close(index);
                });*/
            }
            else if(obj.event === 'detail'){

            }
        });
    });
</script>
</body>
</html>

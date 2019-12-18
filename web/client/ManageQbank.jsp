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
<body style="min-width: 1026px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="#">操作记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/usermanagement.jsp">用户管理</a>
        </li>
        <li class="layui-nav-item layui-this" style="margin: 0 5%">
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
<div>
</div>
<div style="width: 100%;text-align: center">
    <div class="layui-inline">
        <a href="${pageContext.request.contextPath}/client/AddQbank.jsp"><button type="button" class="layui-btn" style="width: 115px;margin-right: -990px;margin-top: 10px;">
            <i class="layui-icon layui-icon-add-1">&#xe654;新增题库</i>
        </button>
        </a>
    <table class="layui-hide" id="test" lay-filter="test" style="margin: 0 auto"></table>
    </div>
</div>


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

            ,title: '用户数据表'
            ,cols: [[ //标题栏
                {field:'qbankId', title:'题库ID', width:200, sort: true}
                ,{field:'name', title:'题库名称', width:200}
                ,{field:'singleChoiceNum', title:'单选题总数', width:200, sort: true}
                ,{field:'multipleChoiceNum', title:'多选题总数', width:200, sort: true}
                ,{field:'blanksNum', title:'填空题总数', width:200, sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:120}
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
                    document.location.href="${pageContext.request.contextPath}/DelQankServlet?qbankId="+value;

                    //layer.close(index);
                })
            }
            else if(obj.event === 'edit'){
                var value = data.qbankId;
                document.location.href="${pageContext.request.contextPath}/EditQankServlet?qbankId="+value;
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

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
        function DelQuestion(path, id, type) {
            console.log("begin");
            $.ajax({
                url:path + "/Ajax_DeleteQuestionServlet",
                dataType:'text',//数据类型
                type:'GET',//类型
                timeout:2000,//超时
                data:{"id": id, "type": type},//后台可获取参数
                success:function (data, status) {
                    console.log("删除：" + status);
                },
                error:function(XMLHttpRequest,textStatus,errorThrown){
                    console.log(textStatus);
                    if(textStatus==='timeout'){
                        alert('請求超時');
                        setTimeout(function(){
                            alert('重新请求');
                        },2000);
                    }
                    //alert(errorThrown);
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
        <li class="layui-nav-item layui-this" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/QuestionsControl.jsp">习题管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/Upload.jsp">导入习题</a>
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
        <li id="tab1" class="layui-this">单选题</li>
        <li id="tab2">多选题</li>
        <li id="tab3">填空题</li>
    </ul>
    <div class="layui-tab-content">
        <!-- 单选 -->
        <div class="layui-tab-item layui-show">
            <!-- 表格上方选项 -->
            <div style="margin-left: 1000px; width: 300px; margin-bottom: 10px;">
                <div class="layui-inline">
                    <input class="layui-input" name="id" id="singleReload" autocomplete="off" placeholder="输入题干">
                </div>
                <button class="layui-btn" data-type="reload" id="searchsingle">搜索</button>
            </div>

            <!-- 展示操作记录的表格 -->
            <div style="width: 1300px; height: 650px; margin: auto">
                <table id="single_table" lay-filter="single_table"></table>
            </div>
        </div>
        <!-- 多选 -->
        <div class="layui-tab-item">
            <div class="layui-tab-item layui-show">
                <!-- 表格上方选项 -->
                <div style="margin-left: 1000px; width: 300px; margin-bottom: 10px;">
                    <div class="layui-inline">
                        <input class="layui-input" name="id" id="multipleReload" autocomplete="off" placeholder="输入题干">
                    </div>
                    <button class="layui-btn" data-type="reload" id="searchmultiple">搜索</button>
                </div>

                <!-- 展示操作记录的表格 -->
                <div style="width: 1300px; height: 650px; margin: auto">
                    <table id="multiple_table" lay-filter="multiple_table"></table>
                </div>
            </div>
        </div>
        <!-- 填空 -->
        <div class="layui-tab-item">
            <div class="layui-tab-item layui-show">
                <!-- 表格上方选项 -->
                <div style="margin-left: 1000px; width: 300px; margin-bottom: 10px;">
                    <div class="layui-inline">
                        <input class="layui-input" name="id" id="blankReload" autocomplete="off" placeholder="输入题干">
                    </div>
                    <button class="layui-btn" data-type="reload" id="searchblank">搜索</button>
                </div>

                <!-- 展示操作记录的表格 -->
                <div style="width: 1300px; height: 650px; margin: auto">
                    <table id="blank_table" lay-filter="blank_table"></table>
                </div>
            </div>
        </div>
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
                    {field: 'squestionId', title: 'ID', width:100, fixed: 'left', align:"center", unresize:"false"}
                    ,{field: 'qbankId', title: '题库ID', width: 100}
                    ,{field: 'name', title: '题库', width: 100}
                    ,{field: 'questionText', title: '题干', width: 200}
                    ,{field: 'answer1', title: '选项A', width: 150}
                    ,{field: 'answer2', title: '选项B', width: 150}
                    ,{field: 'answer3', title: '选项C', width: 150}
                    ,{field: 'answer4', title: '选项D', width: 150}
                    ,{field: 'stdAnswer', title: '正确答案', width: 100}
                    ,{field: '', title: '操作', width: 100, templet: '#singleTpl'}
                ]
            ] //设置表头
        });
        //多选表格
        table.render({
            elem: '#multiple_table' //指定原始表格元素选择器（推荐id选择器）
            ,height: 450 //容器高度
            ,url: '${pageContext.request.contextPath}/MultipleControlServlet'
            ,page:true
            ,even:true
            ,id:'multiple_table'
            ,cols: [
                [ //表头
                    {field: 'mquestionId', title: 'ID', width:100, fixed: 'left', align:"center", unresize:"false"}
                    ,{field: 'qbankId', title: '题库ID', width: 100}
                    ,{field: 'name', title: '题库', width: 100}
                    ,{field: 'questionText', title: '题干', width: 200}
                    ,{field: 'answer1', title: '选项A', width: 150}
                    ,{field: 'answer2', title: '选项B', width: 150}
                    ,{field: 'answer3', title: '选项C', width: 150}
                    ,{field: 'answer4', title: '选项D', width: 150}
                    ,{field: 'stdAnswer', title: '正确答案', width: 100}
                    ,{field: '', title: '操作', width: 100, templet: '#multipleTpl'}
                ]
            ] //设置表头
        });
        //填空表格
        table.render({
            elem: '#blank_table' //指定原始表格元素选择器（推荐id选择器）
            ,height: 450 //容器高度
            ,url: '${pageContext.request.contextPath}/BlankControlServlet'
            ,page:true
            ,even:true
            ,id:'blank_table'
            ,cols: [
                [ //表头
                    {field: 'bquestionId', title: 'ID', width:100, fixed: 'left', align:"center", unresize:"false"}
                    ,{field: 'qbankId', title: '题库ID', width: 100}
                    ,{field: 'name', title: '题库', width: 100}
                    ,{field: 'questionText', title: '题干', width: 550}
                    ,{field: 'stdAnswer', title: '正确答案', width: 320}
                    ,{field: '', title: '操作', width: 100, templet: '#blankTpl'}
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
        //多选搜索
        $("#searchmultiple").click(function () {
            table.reload('multiple_table', {
                where: { //设定异步数据接口的额外参数，任意设
                    qtext: $('#multipleReload').val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
        //填空搜索
        $("#searchblank").click(function () {
            table.reload('blank_table', {
                where: { //设定异步数据接口的额外参数，任意设
                    qtext: $('#blankReload').val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });

        //删除单选
        table.on('tool(single_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除么', function(index){
                    var id = data.squestionId;
                    var type = 'single';
                    obj.del();
                    DelQuestion('${pageContext.request.contextPath}', id, type);
                    layer.close(index);
                });
            }
        });
        //删除多选
        table.on('tool(multiple_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除么', function(index){
                    var id = data.mquestionId;
                    var type = 'multiple';
                    obj.del();
                    DelQuestion('${pageContext.request.contextPath}', id, type);
                    layer.close(index);
                });
            }
        });
        //删除填空
        table.on('tool(blank_table)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除么', function(index){
                    var id = data.bquestionId;
                    var type = 'blank';
                    obj.del();
                    DelQuestion('${pageContext.request.contextPath}', id, type);
                    layer.close(index);
                });
            }
        })
    });
</script>

<!-- 单选表格操作列引用模板  -->
<script type="text/html" id="singleTpl">
    <button lay-event="del" class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="">删除</button>
</script>
<!-- 多选表格操作列引用模板  -->
<script type="text/html" id="multipleTpl">
    <button lay-event="del" class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="">删除</button>
</script>
<!-- 填空表格操作列引用模板  -->
<script type="text/html" id="blankTpl">
    <button lay-event="del" class="layui-btn layui-btn-normal layui-btn-radius layui-btn-sm" onclick="">删除</button>
</script>

</body>
</html>

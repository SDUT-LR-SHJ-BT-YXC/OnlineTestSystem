<%--
  Created by IntelliJ IDEA.
  User: White
  Date: 2019/12/24
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>导入习题</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
</head>
<body style="min-width: 1026px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/client/adminpage.jsp">用户管理</a>
        </li>
        <li class="layui-nav-item layui-this" style="margin: 0 5%">
            <a href="${pageContext.request.contextPath}/ManageQbankServlet">题库管理</a>
        </li>
        <li class="layui-nav-item" style="margin: 0 5%">
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
<div>
</div>
<div class="layui-upload" style="margin-top: 30px;margin-left: 30px;">
    <button type="button" class="layui-btn layui-btn-normal" id="testList">选择文件</button>
    <div class="layui-upload-list">
        <table class="layui-table">
            <thead>
            <tr><th>文件名</th>
                <th>大小</th>
                <th>状态</th>
                <th>操作</th>
            </tr></thead>
            <tbody id="demoList"></tbody>
        </table>
    </div>
    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
</div>
<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //多文件列表示例
        var demoListView = $('#demoList')
            ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '${pageContext.request.contextPath}/UpLoadServlet'
            ,accept: 'file'
            ,multiple: false
            ,number:1
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                console.log("成功");
                if(res.code == 0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                console.log("失败");
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    });
</script>
</body>
</html>


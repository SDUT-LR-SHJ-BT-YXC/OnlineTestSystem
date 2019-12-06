<%--
  Created by IntelliJ IDEA.
  User: liurong
  Date: 2019/12/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线考试系统</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shj_js/Ajax_Functions.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/shj_js/Functions.js"></script>
    <style>
        .layui-nav .layui-nav-item a {
            padding:0 30px;
            color: #000;
        }
        .layui-nav * {
            font-size:15px;
        }
        .layui-tab-title li{
            font-size:16px;
            min-width:188px;
        }
    </style>
</head>
<body>
<div class="header">
    <ul class="layui-nav layui-bg-cyan" lay-filter="" style="text-align: center">
        <li class="layui-nav-item"><a href="">在线测试</a></li>
        <li class="layui-nav-item layui-this"><a href="">错题记录</a></li>
        <li class="layui-nav-item"><a href="">关于我们</a></li>
        <li class="layui-nav-item"><a href="">题库下载</a></li>
        <li class="layui-nav-item"><a href="">成绩分析</a></li>
        <!--
        <li class="layui-nav-item">
            <a href="javascript:;"></a>
            <dl class="layui-nav-child">
                <dd><a href=""></a></dd>
                <dd><a href=""></a></dd>
            </dl>
        </li>
        -->
    </ul>
    <script>
        layui.use('element', function(){
            var element = layui.element;

            //…
        });
    </script>
</div>

    <div class="containt">
        <div class="layui-tab layui-tab-card" style="text-align: center">
            <ul class="layui-tab-title">
                <li class="layui-this">错题总览</li>
                <li>错题详情</li>
            </ul>
            <div class="layui-tab-content" style="height: 100px;">
                <div class="layui-tab-item layui-show" style="width: 60%; margin-left:25px;padding-top:15px;">
                    <p class="pfont" style="font-size: 18px;">数据库</p>
                    <div class="layui-progress layui-bg-red layui-progress-big" lay-showpercent="true" >
                        <div class="layui-progress-bar" lay-percent="5 / 10"></div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-container " style="margin-top:60px;height:100%;">
                        <table class="layui-table" lay-even lay-skin="row" lay-size="lg">
                            <tr>
                                <th style="background-color:#FAFAD2;text-align:center;"><font size=4px;>题库ID</font></th>
                                <th style="background-color:#FAFAD2;text-align:center;"><font size=4px;>题库名称</font></th>
                                <th style="background-color:#FAFAD2;"></th>
                            </tr>

                            <c:forEach var = "type" items="${types }" >
                                <tr>
                                    <th>${type.typeID }</th>
                                    <th>${type.typename }</th>
                                    <th><a class="layui-btn layui-btn-warm" href="/LR_YJX/TestServlet?id=${type.typeID }">查看详情</a></th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>


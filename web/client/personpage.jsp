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
    <title>在线答题系统个人首页</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body style="min-width: 1026px; min-height: 710px">
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item layui-this" style="margin: 0px 5%">
            <a href="">成绩分析</a>
        </li>
        <li class="layui-nav-item" >
            <a href="${pageContext.request.contextPath}/client/showqbank.jsp">在线测试</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/WrongAnswerRecordServlet">错题记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="${pageContext.request.contextPath}/client/aboutus.jsp">关于我们</a>
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

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 900px;height:500px; margin: 50px auto; overflow:hidden"></div>
<script type="text/javascript">
    /****     绘制柱状图    *******/
    function drawGraph(ajax_data) {
        console.log("处理数据");
        ajax_data.map(function (record) {
            var date = new Date(record.time);
            record.date = date.getMonth() + "-" + date.getDate();
            return record;
        });
        var dates = [];
        var scores = [];
        var aver = [];
        var sum = 0;
        for(let i = ajax_data.length - 1, j = 0; i >=  0; i--, j++){
            dates.push(ajax_data[i].date);
            scores.push(ajax_data[i].score);
            sum += scores[j];
            aver.push(sum / (j + 1));
        }
        if(ajax_data.length < 10){
            for(let i = ajax_data.length; i <= 10; i++){
                dates.push("");
                scores.push(undefined);
                aver.push(undefined);
            }
        }

        console.log("开始绘图");
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '近期做题记录统计'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    label: {
                        backgroundColor: '#283b56'
                    }
                }
            },
            legend: {
                data:['平均分','分数']
            },
            // toolbox: {
            //     show: true,
            //     feature: {
            //         dataView: {readOnly: false},
            //         restore: {},
            //         saveAsImage: {}
            //     }
            // },
            xAxis: {
                data: dates
            },
            yAxis: {},
            series: [{
                name: '分数',
                type: 'bar',
                data: scores
            },
                {
                    name:'平均分',
                    type:'line',
                    data: aver
                }
            ],
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

    /******    ajax异步请求数据  *******/
    $.ajax({
        url:"${pageContext.request.contextPath}" + "/Ajax_RecentScoreRecord",
        dataType:"json",
        type:"GET",
        timeout:2000,
        data:{
            "userid":"${sessionScope.user.userId}"
        },
        success:function (data, status) {
            console.log("请求做题记录成功");
            /**  请求成功，绘制柱状图  **/
            drawGraph(data);
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            console.log("请求异常");
            if(textStatus=== 'timeout'){
                setTimeout(function () {
                    console.log("重新请求");
                }, 2000);
            }
        }
    });
</script>

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

</script>
</html>

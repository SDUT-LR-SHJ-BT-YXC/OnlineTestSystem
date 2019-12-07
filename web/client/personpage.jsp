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
    <title>Title</title>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script src="../js/echarts.min.js"></script>
    <script src="../js/shj_js/Functions.js"></script>
</head>
<body>
<div class="layui-header" >
    <ul class="layui-nav">
        <li class="layui-nav-item" >
            <a href="${pageContext.request.contextPath}/client/showqbank.jsp">在线测试</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">错题记录</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">关于我们</a>
        </li>
        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">题库下载<span class="layui-badge-dot"></span></a>
        </li>

        <li class="layui-nav-item" style="margin: 0px 5%">
            <a href="">错题分析</a>
        </li>

        <li class="layui-nav-item" lay-unselect="" style="float: right">
            <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">修改信息</a></dd>
                <dd><a href="javascript:;">安全管理</a></dd>
                <dd><a href="javascript:;">退了</a></dd>
            </dl>
        </li>
    </ul>
</div>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 900px;height:500px; margin: 50px auto; overflow:hidden"></div>
<script type="text/javascript">
    /****     绘制柱状图    *******/
    function drawGraph(ajax_data) {
        console.log("开始绘图");
        ajax_data.map(function (record) {
            var date = new Date(record.time);
            record.date = date.getMonth() + "-" + date.getDate();
            return record;
        });
        var dates = [];
        var scores = [];
        var aver = [];
        var sum = 0;
        for(let i = 0; i < 10; i++){
            dates[i] = ajax_data[i].date;
            scores[i] = ajax_data[i].score;
            sum += scores[i];
            aver[i] = sum / (i + 1);
        }
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '近期十次做题记录统计'
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

    <!--  轮播  -->
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '80%' //设置容器宽度
            ,height: '460px'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>
</html>

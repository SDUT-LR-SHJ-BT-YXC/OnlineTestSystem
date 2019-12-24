<!--   JSP引入该文件之前请先引入jquery文件 -->

/*** regiter.jsp   ***/
function judgeEmail(path) {
    console.log("begin");
    $.ajax({
        url:path + "/Ajax_IsExitEmailServlet",
        dataType:'text',//数据类型
        type:'GET',//类型
        timeout:2000,//超时
        data:{"email":$("input[name=email]").val()},//后台可获取参数
        success:function (data, status) {
            console.log("请求成功：" + status);
            if(data=== 'true'){
                $("#email_tip").text("该邮箱已被占用啦");
                $("#submit").prop("disabled","true");
            }
            else {
                $("#submit").prop("disabled ", "false");
            }
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

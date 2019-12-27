<!--   JSP引入该文件之前请先引入jquery文件 -->

function checkUserName(name) {
    if(name !== ''){
        return true;
    }
    return false;
}

function checkPassword(passwd) {
    re = /[a-zA-Z0-9\_]{6,16}/;
    if(re.test(passwd)){
        return true;
    }
    else{
        return  false;
    }
}

/**   register.jsp   **/
function checkForm() {
    var index = onload();
    var nick_name = $("input[name=nick_name]");
    var passwd = $("input[name=password]");
    var passwd2 = $("input[name=password2]");
    var submit = $("#submit");
    $("#nick_name_tip").text("");
    $("#password1_tip").text("");
    $("#password2_tip").text("");
    if(nick_name.val() === ''){
        $("#nick_name_tip").text("请输入用户名.");
        closeOnload(index);
        return false;
    }
    else if(!checkPassword(passwd.val())){
        $("#password1_tip").text("请输入6-16位密码，由数字、字母、下划线组成");
        closeOnload(index);
        return false;
    }
    else if(passwd.val() !== passwd2.val()){
        console.log(passwd);
        console.log(passwd2);
        $("#password2_tip").text("前后密码不一致");
        closeOnload(index);
        return  false;
    }
    closeOnload(index);
    return true;
}

/*** login.jsp  ***/
function  checkLoginForm(path) {
    var index = onload();
    var  email = $("#email").val().trim();
    var passwd = $("#password").val().trim();
    $('#email_tip').text("");
    $("#password_tip").text("");
    if(email === ''){
        $('#email_tip').text("邮箱不能为空");
        closeOnload(index);
        return false;
    }else if(passwd === ''){
        $("#password_tip").text("密码不能为空");
        closeOnload(index);
        return  false;
    }else{
        var flag = false;

        $.ajax({
            url: path + '/Ajax_GetPasswordByEmailServlet',
            dataType: 'text',
            type: 'GET',
            timeout: 2000,
            async: false,
            data:{'email': email},
            success:function (data, status) {
                console.log("请求成功，密码：" + data);
                if(data === passwd){
                    flag = true;
                }else{
                    flag = false;
                    $("#password_tip").text("账号不存在或密码错误。");
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("请求失败");
                if(textStatus === 'timeout'){
                    setTimeout(function () {
                        console.log("重新请求");
                    }, 2000)
                }
            }
        });
        closeOnload(index);
        return flag;
    }
    closeOnload(index);
}

/*** PersonCenter.jsp  ***/
function confirmExamination(context){
    //询问框
    layui.use("layer", function () {
        layer = layui.layer;
        var index = layer.confirm('开始测试后将无法暂停测试，是否继续开始测试？', {
            btn: ['开始','取消'] //按钮
        }, function(index, layero){
            layer.close(index);
            window.open(context);
        }, function(){

        });
    })
}


/*** Examination.jsp  ***/
function submitExamination(form, url) {
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.msg("时间到，停止答题，试卷即将提交。");
        setTimeout(function () {
            form.submit();
        },2000)
    });
}

function onload() {
    var index = null;
    layui.use('layer', function () {
        var layer = layui.layer;
        index = layer.load(0, {shade: false, time: 0}
        );
    })
    return index;
}

function closeOnload(index) {
    layui.use('layer', function () {
        layer.close(index);
    })
}

/** Examination.jsp ***/

function confirmSubmit(id) {
    var form = $(id);
    layui.use("layer", function () {
        layer = layui.layer;
        layer.confirm('请检查试题都已完成，确定要交卷吗？', {
            btn: ['确定','取消'] , //按钮
            fixed:true,
            offset:'150px',
        }, function(){
            window.localStorage.setItem("flag", true);
            form.submit();
        }, function(){
        });
    });
}

/*** changepassword.jsp ***/
function checkChangePasswordForm() {
    var index = onload();
    var code = $("#code");
    var inputedcode = $("input[name=code]");
    var passwd = $("input[name=password]");
    var passwd2 = $("input[name=password2]");
    var submit = $("#submit");
    $("#code_tip").text("");
    $("#password1_tip").text("");
    $("#password2_tip").text("");
    if(code.text() !== inputedcode.val()){
        $("#code_tip").text("验证码错误！");
        closeOnload(index);
        return false;
    }
    else if(!checkPassword(passwd.val())){
        $("#password1_tip").text("请输入6-16位密码，由数字、字母、下划线组成");
        closeOnload(index);
        return false;
    }
    else if(passwd.val() !== passwd2.val()){
        $("#password2_tip").text("前后密码不一致");
        closeOnload(index);
        return  false;
    }
    closeOnload(index);
    return true;
}

/*** Examination.jsp ***/
function banF5(){
    //禁用F5刷新
    document.onkeydown = function ()
    {
        if (event.keyCode === 116) {
            event.keyCode = 0;
            event.cancelBubble = true;
            return false;
        }
    }

//禁止右键弹出菜单
    document.oncontextmenu = function () {
        return false;
    }
}

/*** Examination.jsp ***/
function endExamimationMsg(path) {
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.open({
            title:'考试已关闭',
            content:"本考试已经关闭！",
            offset:"150px",
            yes: function(index, layero){
                window.location.href= path + '/client/personpage.jsp';
             },
            cancel:function (index, layero) {
                window.location.href= path + '/client/personpage.jsp';
            }
        })
    });
}

/*** examinationresult.jsp  ***/
function msg(type,t, text) {
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.open({
            title:t,
            offset:"150",
            content:text,
            }
        )
    })
}

/*** login.jsp  ***/
function forgetPasswordOnClick(context){
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.prompt({title: '请输入您的注册邮箱', formType: 0}, function(pass, index){
            layer.close(index);
            window.location.href = context + '/ForgetPasswordServlet?email=' + pass;
        });
    })
}
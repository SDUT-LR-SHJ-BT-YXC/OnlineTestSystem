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

    var nick_name = $("input[name=nick_name]");
    var passwd = $("input[name=password]");
    var passwd2 = $("input[name=password2]");
    var submit = $("#submit");
    $("#nick_name_tip").text("");
    $("#password1_tip").text("");
    $("#password2_tip").text("");
    if(nick_name.val() === ''){
        $("#nick_name_tip").text("请输入用户名.");
        return false;
    }
    else if(!checkPassword(passwd.val())){
        $("#password1_tip").text("请输入6-16位密码，由数字、字母、下划线组成");
        return false;
    }
    else if(passwd !== passwd2){
        $("#password2_tip").text("前后密码不一致");
        return  false;
    }
}

/*** login.jsp  ***/
function  checkLoginForm() {
    var  email = $("#email").val().trim();
    var passwd = $("#password").val().trim();
    $('#email_tip').text("");
    $("#password_tip").text("");
    if(email === ''){
        $('#email_tip').text("邮箱不能为空");
        return false;
    }else if(passwd === ''){
        $("#password_tip").text("密码不能为空");
        return  false;
    }
    return  true;

}

/*** PersonCenter.jsp  ***/
function confirmExamination(context){
    //询问框
    layui.use("layer", function () {
        layer = layui.layer;
        layer.confirm('开始测试后将无法暂停测试，是否继续开始测试？', {
            btn: ['开始','取消'] //按钮
        }, function(){
            window.open(context)
            layer.msg('的确很重要', {icon: 1});
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
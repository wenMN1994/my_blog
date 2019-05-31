$(function() {
    // 点击登录按钮
    $('#login-bt').click(function() {
        validateRule();
    });
    // 回车事件
    $('#username, #password').keypress(function (event) {
        if (13 == event.keyCode) {
            validateRule();
        }
    });
});

$.validator.setDefaults({
    submitHandler: function () {
        login();
    }
});

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}

// 登录
function login() {
    parent.layer.load(1, {shade: [0.1,'#fff']});//0.1透明度的白色背景
    $.ajax({
        url: '/sso/login',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val()
        },
        success: function (r) {
            if (r.code == 0) {
                location.href = '/system/index';
            } else {
                parent.layer.closeAll('loading'); //关闭加载层
                parent.layer.msg(r.msg);
            }
        },
        error: function(error){
            console.log(error);
        }
    });
}
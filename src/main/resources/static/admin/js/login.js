$(function() {
    // 点击登录按钮
    $('#login-bt').click(function() {
        login();
    });
    // 回车事件
    $('#username, #password').keypress(function (event) {
        if (13 == event.keyCode) {
            login();
        }
    });
});
// 登录
function login() {
    $.ajax({
        url: '/sso/login',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val()
        },
        beforeSend: function() {

        },
        success: function(json){
            if (json.code == 1) {
                location.href = json.data;
            } else {
                alert(json.data);
                if (10101 == json.code) {
                    $('#username').focus();
                }
                if (10102 == json.code) {
                    $('#password').focus();
                }
            }
        },
        error: function(error){
            console.log(error);
        }
    });
}
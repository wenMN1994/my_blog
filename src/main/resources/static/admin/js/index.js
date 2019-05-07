/**
 * 首页方法封装处理
 */
$(function () {
    // 全屏显示
    $('#fullScreen').on('click', function () {
        $('#wrapper').fullScreen();
    });

    // 双击选项卡全屏显示
    $('.J_menuTabs').on('dblclick', '.J_menuTab', activeTabMax);

    // tab全屏显示
    $('.J_tabMaxCurrent').on('click', function () {
        $('.page-tabs-content').find('.active').trigger("dblclick");
    });

    // 关闭全屏
    $('#ax_close_max').click(function () {
        $('#content-main').toggleClass('max');
        $('#ax_close_max').hide();
    })

    // 双击选项卡全屏显示
    function activeTabMax() {
        $('#content-main').toggleClass('max');
        $('#ax_close_max').show();
    }

    $(window).keydown(function (event) {
        if (event.keyCode == 27) {
            $('#content-main').removeClass('max');
            $('#ax_close_max').hide();
        }
    });

});
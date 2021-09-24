$(function() {
    var panehHidden = false;
    if ($(this).width() < 769) {
        panehHidden = true;
    }
    $('body').layout({ initClosed: panehHidden, west__size: 185 });
    // 回到顶部绑定
    if ($.fn.toTop !== undefined) {
        var opt = {
            win:$('.ui-layout-center'),
            doc:$('.ui-layout-center')
        };
        $('#scroll-up').toTop(opt);
    }
    $('.file-box').each(function () {
        animationHover(this, 'pulse');
    });
    queryFileList();
});

/**
 *
 * @param element
 * @param animation
 */
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        }
    );
}


/**
 * 查询文件列表
 */
function queryFileList() {

}

/**
 * 刷新文件分类
 */
$('#btnRefresh').click(function() {

});

/**
 * 文件分类点击事件
 */
$(".nav.ul-onclick").on("click", "li", function() {
    $(this).parent().children(".li-active").removeClass("li-active");
    $(this).addClass("li-active");
});

/**
 * 预览文件
 * @param obj
 * @param fileId
 */
function viewFile(obj, fileId) {
    $(obj).parent().addClass("file-active");
    $(obj).parent().parent().siblings().children().removeClass("file-active");
    alert("预览文件！");
}

/**
 * 删除文件
 * @param obj
 * @param fileId
 */
function deleteFile(obj, fileId) {
    $(obj).parent().addClass("file-active");
    $(obj).parent().parent().siblings().children().removeClass("file-active");
    alert("删除文件！");
}
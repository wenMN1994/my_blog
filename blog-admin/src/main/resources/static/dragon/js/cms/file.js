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
    queryFileList();
    $('.file-box').each(function () {
        animationHover(this, 'pulse');
    });
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
    let $fileItemContainer = $("#file-item-container");
    $fileItemContainer.html('');
    let formData = $("#file-form").serialize();
    $.ajax({
        url: prefix + "/list",
        type: 'POST',
        data: formData,
        cache: false,
        async: false,
        beforeSend: function () {
            $.modal.loading("正在查询中，请稍后...");
        },
        success: function (result) {
            if (result.code == web_status.SUCCESS) {
                let fileItem = result.result;
                $.each(fileItem,function(index,value){
                    let createTime = value.createTime;
                    let fileId = value.fileId;
                    let fileName = value.fileName;
                    let fileUrl = value.fileUrl;
                    let type = value.type;
                    let imgHtml = '<img alt="image" style="height: 100%;" class="img-responsive" src="'+fileUrl+'">';
                    let fileBoxDiv = $("#img-file-box").html();
                    if(type == 'image/png' || type == 'image/jpeg'){
                        fileBoxDiv = fileBoxDiv.replaceAll("_FILEID_", fileId).replaceAll("_FILEURL_", imgHtml).replaceAll("_FILENAME_", fileName).replaceAll("_CREATETIME_", createTime);
                    }
                    $fileItemContainer.append(fileBoxDiv);
                });
            } else {
                $.modal.alertError(result.msg);
            }
            $.modal.closeLoading();
        }
    });
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
 * 文件上传弹出框
 */
function uploadDialog() {
    $.modal.open("上传文件", prefix + '/upload','840');
}

/**
 * 预览文件
 * @param obj
 * @param fileId
 */
function viewFile(obj, fileId) {
    $(obj).parent().addClass("file-active");
    $(obj).parent().parent().siblings().children().removeClass("file-active");
}

/**
 * 删除文件
 * @param obj
 * @param fileId
 */
function deleteFile(obj, fileId) {
    $(obj).parent().addClass("file-active");
    $(obj).parent().parent().siblings().children().removeClass("file-active");
    $.modal.confirm("确认要删除这条数据吗?", function() {
        let data = { "ids": fileId };
        $.ajax({
            url: prefix + "/remove",
            type: 'POST',
            data: data,
            cache: false,
            async: false,
            beforeSend: function () {
                $.modal.loading("正在处理中，请稍后...");
            },
            success: function (result) {
                debugger;
                if (result.code == web_status.SUCCESS) {
                    $.modal.msgSuccess(result.msg);
                    queryFileList();
                } else {
                    $.modal.alertError(result.msg);
                }
                $.modal.closeLoading();
            }
        });
    });
}
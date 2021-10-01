$(document).ready(function () {
    // 多图上传
    $("#multipleFile").fileinput({
        language: 'zh',//中文
        uploadUrl: ctx + 'common/uploadsToOss', //上传的地址
        uploadAsync: false, //是否为异步上传
        showClose: false, //是否显示关闭按钮
        maxFileCount: 5, //允许同时上传的最大文件个数
        validateInitialCount:true,
        msgFilesTooMany: "选择上传的文件数量({n}个) 超过允许的最大数值{m}个！"
    }).on('fileuploaded', function(event, data, previewId, index) { //缩略图上传按钮-上传成功
        debugger;
        let response = data.response;
        let code = response.code;
        if(code == 0){
            $.each(response.result,function(index,value){
            });
            console.log('File uploaded triggered');
        }else {
            $.modal.alertError("文件上传失败！");
        }
    }).on('fileuploaderror', function(event, data, msg) {
        debugger;
        let response = data.response;
        console.log('File upload error：' + msg);
    }).on('filebatchuploadsuccess', function (event, data, previewId, index) { //批量上传按钮-上传成功
        debugger;
        let response = data.response;
        let code = response.code;
        if(code == 0){
            let successData = response.result.success;
            let errorData = response.result.error;
                $.each(successData,function(index,value){
                debugger;
                let fileName = value.fileName;

            });

            $.each(errorData,function(index,value){
                debugger;
                let fileName = value.fileName;
            });

            if(errorData.length > 0){
                $.modal.alertWarning("部分文件上传失败！");
            }
        }else {
            $.modal.alertError("文件上传失败！");
        }
    }).on('filebatchuploaderror', function(event, data, msg) { //批量上传按钮-上传失败
        debugger;
        console.log('文件上传失败！'+data.status);
    }).on('fileremoved', function (event, id, index) { //未上传文件-删除
        debugger;
        $("input[name='" + event.currentTarget.id + "']").val('')
    }).on('filesuccessremove', function(event, id) { //已上传文件-删除
        debugger;
        log.info("return filesuccessremove")
    })
});

/**
 * 确认
 */
function submitHandler() {
    let parent = activeWindow();
    $.modal.close();
    parent.queryFileList();
}
let uploadSuccessFile = [];
$(document).ready(function () {
    // 多图上传
    $("#multipleFile").fileinput({
        uploadUrl: ctx + 'common/uploadsToOss', //上传的地址
        uploadAsync: false, //是否为异步上传
        showClose: false, //是否显示关闭按钮
        maxFileCount: 5, //允许同时上传的最大文件个数
        validateInitialCount:true,
        msgFilesTooMany: "选择上传的文件数量({n}个) 超过允许的最大数值{m}个！"
    }).on('fileuploaded', function(event, data, previewId, index) { //缩略图上传按钮-上传成功
        debugger;
        let response = data.response;
        $.each(response.result,function(index,value){
            uploadSuccessFile.push(response.result[index]);
        });
        console.log('File uploaded triggered');
    }).on('fileuploaderror', function(event, data, msg) {
        let response = data.response;
        console.log('File upload error：' + msg);
    }).on('filebatchuploadsuccess', function (event, data, previewId, index) { //批量上传按钮-上传成功
        debugger;
        let response = data.response;
        $.each(response.result,function(index,value){
            debugger;
            uploadSuccessFile.push(response.result[index]);
        });
        log.info("return uploadSuccessFile：" + uploadSuccessFile)
    }).on('filebatchuploaderror', function(event, data, msg) { //批量上传按钮-上传失败
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
    debugger;
    let parent = activeWindow();
    $.modal.close();
    parent.queryFileList();
}
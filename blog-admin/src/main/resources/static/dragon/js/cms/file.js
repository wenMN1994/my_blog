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
});

/**
 * 查询文件列表
 */
function queryFileList() {
    var options = {
        url: prefix + "/list",
        createUrl: prefix + "/add",
        updateUrl: prefix + "/edit/{id}",
        removeUrl: prefix + "/remove",
        exportUrl: prefix + "/export",
        importUrl: prefix + "/importData",
        importTemplateUrl: prefix + "/importTemplate",
        sortName: "createTime",
        sortOrder: "desc",
        modalName: "用户",
        columns: [{
            checkbox: true
        },
            {
                field: 'userId',
                title: '用户ID'
            },
            {
                field: 'loginName',
                title: '登录名称',
                sortable: true
            },
            {
                field: 'userName',
                title: '用户名称'
            },
            {
                field: 'dept.deptName',
                title: '部门'
            },
            {
                field: 'email',
                title: '邮箱',
                visible: false
            },
            {
                field: 'phonenumber',
                title: '手机'
            },
            {
                visible: editFlag == 'hidden' ? false : true,
                title: '用户状态',
                align: 'center',
                formatter: function (value, row, index) {
                    return statusTools(row);
                }
            },
            {
                field: 'createTime',
                title: '创建时间',
                sortable: true
            },
            {
                title: '操作',
                align: 'center',
                formatter: function(value, row, index) {
                    if (row.userId != 1) {
                        var actions = [];
                        actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="javascript:void(0)" onclick="$.operate.editTab(\'' + row.userId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                        actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.userId + '\')"><i class="fa fa-remove"></i>删除</a> ');
                        var more = [];
                        more.push("<a class='btn btn-default btn-xs " + resetPwdFlag + "' href='javascript:void(0)' onclick='resetPwd(" + row.userId + ")'><i class='fa fa-key'></i>重置密码</a> ");
                        more.push("<a class='btn btn-default btn-xs " + editFlag + "' href='javascript:void(0)' onclick='authRole(" + row.userId + ")'><i class='fa fa-check-square-o'></i>分配角色</a>");
                        actions.push('<a tabindex="0" class="btn btn-info btn-xs" role="button" data-container="body" data-placement="left" data-toggle="popover" data-html="true" data-trigger="hover" data-content="' + more.join('') + '"><i class="fa fa-chevron-circle-right"></i>更多操作</a>');
                        return actions.join('');
                    } else {
                        return "";
                    }
                }
            }]
    };
    $.table.init(options);
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
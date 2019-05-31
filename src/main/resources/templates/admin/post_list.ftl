<#include "module/macro.ftl">
<@header></@header>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-12 column">
            <div class="panel-body" style="padding-bottom:0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="postTitle" placeholder="文章名称">
                                </div>
                                <div class="col-sm-4" style="text-align:left;">
                                    <button type="button" id="btn_query" class="btn btn-primary" onclick="search();">查询</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div id="toolbar" class="btn-group">
                    <button id="btn_add" type="button" class="btn btn-default" onclick="addRow();">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    </button>
                    <button id="btn_edit" type="button" class="btn btn-default" onclick="editRow();">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                    </button>
                    <button id="btn_delete" type="button" class="btn btn-default" onclick="deleteRows();">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </button>
                </div>
            <table id="postTable" data-mobile-responsive="true"></table>
            </div>
        </div>
    </div>
</div>

<@footer>
<script>
$(function() {

	// 初始化表格
	var bTable = new TableInit();
	bTable.Init();

});

var TableInit = function () {
	var bTableInit = new Object();
    bTableInit.Init = function () {
        $('#postTable').bootstrapTable({
            url: '/admin/post/list',
            method: 'post',                     				//请求方式（*）
            toolbar: '#toolbar',                				//工具按钮用哪个容器
            striped: true,                      				//是否显示行间隔色
            cache: false,                       				//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   				//是否显示分页（*）
            sortable: false,                    				//是否启用排序
            sortOrder: "asc",                   				//排序方式
            queryParams: bTableInit.queryParams,				//传递参数（*）
            sidePagination: "server",           				//分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                      				//初始化加载第一页，默认第一页
            pageSize: 10,                       				//每页的记录行数（*）
            pageList: [10, 50, 100, 500],        				//可供选择的每页的行数（*）
            search: false,                       				//是否显示表格搜索，此搜索是客户端搜索，不会进服务端，感觉意义不大
            strictSearch: false,
            showColumns: false,                  				//是否显示所有的列
            showRefresh: true,                  				//是否显示刷新按钮
            minimumCountColumns: 2,             				//最少允许的列数
            clickToSelect: true,                				//是否启用点击选中行
            height: 500,                        				//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "postId",                 				//每一行的唯一标识，一般为主键列
            showToggle: false,                  				//是否显示详细视图和列表视图的切换按钮
            cardView: false,                    				//是否显示详细视图
            detailView: false,                  				//是否显示父子表
            contentType: "application/x-www-form-urlencoded",	//post方法
            columns: [{
                checkbox: true
            }, {
                field: 'postId',
                title: '编号'
            }, {
                field: 'postTitle',
                title: '标题'
            }, {
                field: 'postUrl',
                title: '链接'
            }, {
                field: 'postSummary',
                title: '摘要'
            },]

        });
    };

    //得到查询的参数
    bTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一致
            pageSize: params.limit,   //页面大小，变量名与控制器一致
            pageNum: params.offset / params.limit + 1, //页码，变量名与控制器一致
            postTitle: $("#postTitle").val(),
        };
        return temp;
    };
    return bTableInit;

};

function addRow() {
    window.location.href="/admin/post/toAdd";
}

function editRow() {
    var selected = $('#postTable').bootstrapTable('getSelections');
    if (selected.length == 1) {
        window.location.href="/admin/post/toEdit?postId="+selected[0].postId;
    }else {
        alert('请选中选中一行记录');
        return false;
    }
}

function deleteRows() {
    var selected = $('#postTable').bootstrapTable('getSelections');
    if (selected.length == 0) {
        alert('请至少选中一行记录');
        return false;
    }
    var postIds = "";
    for (var i = 0; i < selected.length; i++) {
        postIds += selected[i].postId;
        if (i != (selected.length - 1)) postIds += ",";
    }
    $MB.confirm({
        text: "确定删除选中的记录？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post("/admin/post/delete", { "postIds": postIds }, function(r) {
            if (r.code == 0) {
                alert(r.msg);
                window.location.reload();
            } else {
                alert(r.msg);
            }
        });
    });
};
</script>
</@footer>

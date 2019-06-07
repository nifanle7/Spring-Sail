<#include "module/macro.ftl">
<@header></@header>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-12 column">
            <div class="panel-body" style="padding-bottom:0px;">
                <div class="demoTable">
                    <div class="layui-inline">
                        <input class="layui-input" name="id" id="postSearch" autocomplete="off">
                    </div>
                    <button class="layui-btn" data-type="reload">搜索</button>
                </div>
                <table id="postTable" lay-filter="postTable"></table>
            </div>
        </div>
    </div>
</div>

<@footer>
<script>
    layui.use('table', function(){

        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#postTable'
            ,height: 530
            ,url: '/admin/post/list' //数据接口
            ,method: 'post'
            ,page: true //开启分页
            ,limit: 10
            ,limits: [10,100,500]
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'postId', title: '编号', width:80, sort: true}
                ,{field: 'postTitle', title: '标题', width:200}
                ,{field: 'categories', title: '分类', width:100}
                ,{field: 'tags', title: '标签', width:100}
                ,{field: 'postUpdateTime', title: '时间', width:100}
            ]]
            ,toolbar: 'default'

        });

        //监听工具条
        table.on('toolbar(postTable)', function(obj){ //注：tool是工具条事件名，postTable是table原始容器的属性 lay-filter="对应的值"

            var data = table.checkStatus('postTable').data; //表格id
            switch(obj.event){
                case 'add':
                    addRow();
                    break;
                case 'update':
                    updateRow(data);
                    break;
                case 'delete':
                    deleteRow(data);
                    break;
            };
        });


        function addRow() {
            window.location.href="/admin/post/toAdd";
        }

        function updateRow(data) {
            if (data.length == 1) {
                window.location.href="/admin/post/toEdit?postId="+data[0].postId;
            }else {
                layer.msg('请选中一行记录');
            }
        }

        function deleteRow(data) {
            if (data.length > 0){
                var postIds = '';
                for(var i=0;i<data.length;i++){
                    postIds += data[i].postId+",";
                    layer.confirm('确定删除？', function(){
                        //向服务端发送删除指令
                        $.ajax({
                            type: 'post',
                            url: '/admin/post/delete',
                            data: {postIds: postIds},
                            success: function () {
                                layer.msg('删除成功啦', { icon: 1 }, { time: 2000 });
                                table.reload('postTable',{});
                            },
                            error: function () {
                                layer.msg('连接网络失败，请检查网络设置或联系管理员', { icon: 2 }, { time: 2000 });
                            }
                        });
                    });
                }
            }else{
                layer.msg('请至少选中一条记录');
            }
        }

        var $ = layui.$, active = {
            reload: function(){
                var postSearch = $('#postSearch');
                //执行重载
                table.reload('postTable', {
                    url: '/admin/post/search',
                    where: {
                        postTitle: postSearch.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
</@footer>

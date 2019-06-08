<div class="side layui-bg-black" id="sidebar-nav">
    <div class="side-logo">
        <h1><a href="/admin"><i class="fa fa-home"></i><span> Sail</span></a></h1>
    </div>
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree layui-inline"  lay-filter="nav">
            <li class="layui-nav-item">
                <a class="nav-item-a" href="javascript:;">
                    <i class="fa fa-fw fa-smile-o"></i><span>文章管理</span>
                    <span class="layui-nav-more"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/admin/post"><i class="fa fa-circle-o fa-fw"></i><span>文章列表</span></a></dd>
                    <dd><a href="/admin/post/toAdd"><i class="fa fa-circle-o fa-fw"></i><span>文章发布</span></a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
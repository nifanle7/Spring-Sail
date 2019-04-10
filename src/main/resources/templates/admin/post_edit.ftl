<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form id="postForm">
                <div class="form-group">
                    <label for="postTitle">标题</label>
                    <div>
                        <input name="postTitle" type="text" class="form-control" placeholder="标题" id="postTitle">
                    </div>
                </div>
                <div class="form-group">
                    <label for="postUrl">链接</label>
                    <input name="postUrl" type="text" class="form-control" placeholder="固定链接" id="postUrl">
                </div>
                <div class="form-group">
                    <label for="postSummary">摘要</label>
                    <input name="postSummary" type="text" class="form-control" placeholder="摘要" id="postSummary">
                </div>
                <div class="form-group">
                    <label for="postContent">内容</label>
                    <textarea name="postContent" class="form-control" placeholder="内容" id="postContent"></textarea>
                </div>
                <button type="submit" class="btn btn-primary" onclick="savePost();" data-toggle="modal" data-target="#myModal">保存</button>
            </form>
        </div>
    </div>
</div>
</body>

<script type="application/javascript">
    function savePost() {
        $.ajax({
            url:"/admin/post/add",
            type:"post",
            data:$("#postForm").serialize(),//formId
            dataType: "json",//预期服务器返回的数据类型
            contentType: "application/x-www-form-urlencoded",//自动封装为对象，不能application/json
            success: function (result) {
                if (result.code="0") {
                    alert(result.msg);
                } else {
                    alert("失败");
                }
            }
        });
    }
</script>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
	<form action="/admin/posts/save" method="post">
		<div class="form-group">
            <input name="postTitle" type="text" class="form-control" placeholder="标题">
		</div>
		<div class="form-group">
            <textarea name="postContent" class="form-control" placeholder="内容"></textarea>
		</div>
		<button type="submit" value="提交" class="btn btn-primary">保存</button>
	</form>
</body>
</html>
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
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form action="/admin/posts/save" method="post">
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
						<label for="postContent">内容</label>
						<textarea name="postContent" class="form-control" placeholder="内容" id="postContent"></textarea>
					</div>
					<button type="submit" value="提交" class="btn btn-primary">保存</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
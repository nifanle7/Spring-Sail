<#include "module/macro.ftl">
<@header></@header>

<div class="container-fluid">
    <div class="row-fluid">
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
                <div class="box box-primary">
                    <!-- Editor.md编辑器 -->
                    <div class="box-body pad">
                        <div id="markdown-editor">
                            <textarea id="editorarea" style="display:none;"></textarea>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary" onclick="savePost();">保存</button>
            </form>
        </div>
    </div>
</div>

<@footer>
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
            },
            failed:function (result) {
                alert("异常");
            }
        });
    }
    /**
     * 加载编辑器
     */
    var simplemde = new SimpleMDE({
        element: document.getElementById("editorarea"),
        autoDownloadFontAwesome: false,
        autofocus: true,
        autosave: {
            enabled: true,
            uniqueId: "editor-temp",
            delay: 10000
        },
        renderingConfig: {
            codeSyntaxHighlighting: true
        },
        previewRender: function(plainText) {
            var preview = document.getElementsByClassName("editor-preview-side")[0];
            preview.innerHTML = this.parent.markdown(plainText);
            preview.setAttribute('id','editor-preview');
            MathJax.Hub.Queue(["Typeset",MathJax.Hub,"editor-preview"]);
            return preview.innerHTML;
        },
        showIcons: ["code", "table"],
        status: ["autosave", "lines", "words"],
        tabSize: 4
    });

</script>
</@footer>

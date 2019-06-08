layui.use('element', function(){
    var element = layui.element;

});

$('.side-switch').on('click',
    function() {
        $('.side-switch i').toggleClass("fa-dedent");
        $('.side-switch i').toggleClass("fa-indent");
        $('.layui-body').toggleClass("layui-body-50");
        // $('.layui-footer').toggleClass("layui-footer");
        // $('.layui-footer').toggleClass("layui-footer-50");
        $('.layui-layout-left').toggleClass("layui-body-50");
        $('.side').toggleClass("side-sm");
        $('.layui-nav-item').removeClass("layui-nav-itemed");
        $('.nav-item-a').toggleClass("nav-item-b");
        $('.nav-item-b').on('click',
            function() {
                $('.side').removeClass("side-sm");
                $('.layui-body').removeClass("layui-body-50");
                // $('.layui-footer').toggleClass("layui-footer");
                // $('.layui-footer').removeClass("layui-footer-50");
                $('.side-switch i').toggleClass("fa-dedent");
                $('.side-switch i').toggleClass("fa-indent")
            });
        $('.layui-nav-tree .layui-nav-item').on('click',
            function() {
                $('.layui-layout-left').removeClass("layui-body-50");
                $('.nav-item-a').removeClass("nav-item-b");
                $('.side-switch i').addClass("fa-dedent");
                $('.side-switch i').removeClass("fa-indent")
            })
    });
$('.side-btn').on('click',
    function() {
        $("body").toggleClass("showMenu");
        $('.nav-item-b').on('click',
            function() {
                $('.side').removeClass("side-sm");
                $('.layui-body').removeClass("layui-body-50")
            });
        $(".layui-body").toggleClass("layui-body-200");
        $('.mask').on('click',
            function() {
                $('body').removeClass('showMenu modal-open')
            })
    });


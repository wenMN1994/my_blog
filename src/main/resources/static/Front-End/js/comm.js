$(document).ready(function() {
    //nav     
    var obj = null;
    var As = document.getElementById('starlist').getElementsByTagName('a');
    obj = As[0];
    for (i = 1; i < As.length; i++) {
        if (window.location.href.indexOf(As[i].href) >= 0) obj = As[i];
    }
    obj.id = 'selected';
    //nav
    $("#mnavh").click(function() {
        $("#starlist").toggle();
        $("#mnavh").toggleClass("open");
    });
    //search  
    $(".searchico").click(function() {
        $(".search").toggleClass("open");
    });
    //searchclose 
    $(".searchclose").click(function() {
        $(".search").removeClass("open");
    });
    //banner
    $('#banner').easyFader();
    //nav menu   
    $(".menu").click(function(event) {
        $(this).children('.sub').slideToggle();
    });
    //tab
    $('.tab_buttons li').click(function() {
        $(this).addClass('newscurrent').siblings().removeClass('newscurrent');
        $('.newstab>div:eq(' + $(this).index() + ')').show().siblings().hide();
    });

    //弹出分享层

    $(".fx-btn").click(function (e) {

        $(".arc-bdfx").show();

        $(document).one("click", function () {
            
            $(".arc-bdfx").hide();
            
        });

        e.stopPropagation();

    });

    $(".side-fx").click(function (e) {

        $(".side-bdfx").show();

        $(".mail-dy").hide();

        $(document).one("click", function () {
            
            $(".side-bdfx").hide();

            $(".mail-dy").hide();
            
        });

        e.stopPropagation();
        
    });

    $(".el-remove").click(function () {

        $(".arc-bdfx").hide();

        $(".mail-dy").hide();

        $(".side-bdfx").hide();
        
    });

    //返回顶部
    $(function () {

        $(window).scroll(function () {

            if ($(this).scrollTop() >= 500) {

                $('.top').fadeIn();

            } else {

                $('.top').fadeOut();

            }

        });
        
        $('.top').click(function () {

            $('body,html').animate({scrollTop: 0}, 800);

        });

    });
});
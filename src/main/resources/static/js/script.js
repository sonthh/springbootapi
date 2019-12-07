$(document).ready(function () {
    //từ vị trí cách trên 100px và opacity = 0
    TweenMax.staggerFrom($('.item'), 0.5, {top: 100, opacity: 0}, 0.4);


    //khi body lên 0 thì nút mờ dần, khi xuống thì hiện ra
    $(window).scroll(function () {
        if ($(this).scrollTop() != 0) {
            $('#scroll-top').fadeIn();
        } else {
            $('#scroll-top').fadeOut();
        }
    });

    //backtotop
    $('#scroll-top').on('click', function (event) {
        $('html, body').animate({
            scrollTop: 0
        }, 'slow', 'easeOutExpo');
    });
});
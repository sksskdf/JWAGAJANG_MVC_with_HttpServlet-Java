// 스크롤
$(function() {
    $(".detail_anchor, .review_anchor, .top_btn").click(function() {
        $('html, body').animate({
            scrollTop: $(this.hash).offset().top}, 400);
    });
});

// 댓글 창 크기 자동 조절
function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (obj.scrollHeight) + 'px';
}

// 푸터 네비 바 나타나기
$(window).scroll(function() {
    if($(this).scrollTop() < 300) {
        $(".footnav").hide();
    } else {
        $(".footnav").show();
    }
}); 

$(function() {
    $(".detail_anchor, .review_anchor").click(function() {
        $('html, body').animate({
            scrollTop: $(this.hash).offset().top}, 400);
    });
});

function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (obj.scrollHeight) + 'px';
}
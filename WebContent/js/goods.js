// 스크롤
$(function() {
    $(".detail_anchor, .review_anchor, .top_btn").click(function() {
        $('html, body').animate({
            scrollTop: $(this.hash).offset().top}, 400);
    });
});

$(function() {
	$('.ctgry_list a').click(function(){
		$('.ctgry_list a').removeClass()
			$(this).addClass('on')
	});
});

// 주문수량 버튼
/*
// 숫자 타입에서 쓸 수 있도록 format() 함수 추가
Number.prototype.format = function(){
    if(this==0) return 0;
 
    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');
 
    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
 
    return n;
};
 
// 문자열 타입에서 쓸 수 있도록 format() 함수 추가
String.prototype.format = function(){
    var num = parseFloat(this);
    if( isNaN(num) ) return "0";
 
    return num.format();
};
*/
function change_qty(btn) {
    var min_qty = 1;
    var this_qty = $("#goods_qty").val()*1;
    var max_qty = '10'

    if(btn=="minus") {
        this_qty -= 1;
        if(this_qty < min_qty) {
            alert("수량은 1개 이상 입력해주세요.")
            return;
        }
    } else if(btn=="plus") {
        this_qty += 1;
        if(this_qty > max_qty) {
            alert("재고가 부족합니다.");
            return;
        }
    }
    
    var basic_amount = parseInt('1760');
    var show_total_amount = basic_amount * this_qty;

    $("#goods_qty").val(this_qty);
    $(".total_qty").html(this_qty.format());
    $(".total_cost").html(show_total_amount.format());
	
}

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

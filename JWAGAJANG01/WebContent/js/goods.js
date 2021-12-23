// 스크롤
$(function() {
    $(".detail_anchor, .review_anchor, .top_btn").click(function() {
        $('html, body').animate({
            scrollTop: $(this.hash).offset().top}, 400);
    });

	
	var form = $("form");
	$(".favbtn").on("click",function(e){
		e.preventDefault();
		var mdcode = $("input[name='mdcode']").val();
		var userid = $("input[name='user_id']").val();
		var query = { mdcode:mdcode,userid:userid};
		$.ajax({
			type: "POST",
			url: "/favadd.do",
			data: query,
			success: function(data) {
				alert("해당상품이 찜목록에 추가되었습니다!");
			}
		});
	});
});

/*
$(function() {
	$('.ctgry_list a').click(function(){
		$('.ctgry_list a').removeClass()
			$(this).addClass('on')
	});
});*/

function change_qty(btn) {
    var min_qty = 1;
    var this_qty = $("#goods_qty").val()*1;
    var max_qty = $("goods_qty").attr("min");

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

// 장바구니 추가-------------------------------------------
/*$(document).ready(function(){
	$(".cartbtn").click(function() {
		var buyer = $("#buyer").val();
		var book_kind = $("#book_kind").val();
		var query = {book_id:$("#book_id").val(),
				     buy_count:$("#buy_count").val(),
				     book_image:$("#book_image").val(),
				     book_title:$("#book_title").val(),
				     buy_price:$("#buy_price").val(),
				     buyer:buyer};		
		$.ajax({
 		     type: "POST",
 		     url: "/shoppingmall/insertCart.do",
 		     data: query,
 		     success: function(data){
 		    	 alert("장바구니에 담겼습니다."); 
 		     }
 		});
	});
});*/

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







	


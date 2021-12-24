$(function() {
	// 스크롤
    $(".detail_anchor, .review_anchor, .top_btn").click(function() {
        $('html, body').animate({
            scrollTop: $(this.hash).offset().top}, 400);
    });

	
	$(".favbtn").on("click",function(e){
		e.preventDefault();
		var mdcode = $("input[name='mdcode']").val();
		var favdupchk = $("input[name='favdupchk']").val();
		var userid = $("input[name='user_id']").val();
		var grade = $("input[name='grade']").val();
		var query = { mdcode:mdcode,userid:userid};
		$.ajax({
			type: "POST",
			url: "/favadd.do",
			data: query,
			success: function(data) {
				if(favdupchk === mdcode){
					alert("이미 찜 한 상품입니다!");
				}else if(grade == 1){
					alert('관리자계정은 이용하실 수 없습니다!');
					location.href='goods.do?md_code='+md_code;
				}else{
					alert("해당상품이 찜목록에 추가되었습니다!");
					 location.href = "goods.do?md_code="+mdcode;
				}
			}
		});
	});

	// 정렬
	$(".orderBy").on("click", function(e) {
		// 대분류와 소분류를 구한다.
		var $ultag=$(this).parent().parent();
		var c1=$ultag.attr("data-c1");
		var c2=$ultag.attr("data-c2");
		var order=$(this).data("oper");
		
		var query={category_main:c1, category_sub:c2, order:order};
			// order는 정렬순서 1.최신순 2.판매량순 3.상품평순 4.낮은가격 5.높은가격
		
		$.ajax({
			type: 'post',
			url: "list.do",
			data: query,
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			success: function(data) {
				$('.goods').html(data);
			},
			error: function(request, status, error) {
				alert(error);
			}
		});
	});
	
	// 리뷰 등록
	$("#submitbtn").on("click", function(e) {
		var md_code = $("input[name='md_code']").val();
		var user_id = $("#writer").val();
		var stars = $("#stars").val();
		var writervw = $("#writervw").val();
		
		var query = {md_code:md_code, user_id:user_id, review_rate:stars, review_content:writervw};
		
		$.ajax({
			type: 'post',
			url: "reviewWrite.do",
			data: query,
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			success: function(data) {
				$('.review_list').append(data);
			},
			error: function(request, status, error) {
				alert(error);

			}
		});
	});

	$(".cartbtn").on("click",function(e){
		e.preventDefault();
		var userid = $("input[name='user_id']").val();
		var grade = $("input[name='grade']").val();
		var md_code = $("input[name='mdcode']").val();
		var user_id = $("input[name='user_id']").val();
		var md_name = $(".goods_title").text();
		var img_main = $(".goods_img").attr("src");
		var md_price = $(".price").text();
		var md_dc = $(".dc").text();
		var md_count = $("#goods_qty").val();
		var query = { md_code:md_code,user_id:user_id, md_name:md_name, 
				img_main:img_main, md_price:md_price, md_dc:md_dc, md_count:md_count};
		$.ajax({
			type: "POST",
			url: "/cartPut.do",
			data: query,
			success: function(data) {
				if(userid === null || userid === ''){
					alert("로그인 후 이용하실 수 있습니다!");
					location.href='login.do';
				}else if(grade == 1){
					alert('관리자계정은 이용하실 수 없습니다!');
					location.href='goods.do?md_code='+md_code;
				}else{
					
					alert("장바구니에 추가되었습니다!");
					location.href='cartPut.do';
				}
				
				
			}
		});
	});
});



/*
// 리뷰 등록
$(document).ready(function() {
    $("#submitbtn").click(function() {
    	  var book_id = $("#book_id").val();

  		  var query = {qna_content:$("#qnaCont").val(),
  				       qna_writer:$("#qna_writer").val(),
  				       book_title:$("#book_title").val(),
  				       book_id:book_id,
  				       qora:$("#qora").val()};
  		  
  		  $.ajax({
  		     type: "POST",
  		     url: "/shoppingmall/qnaPro.do",
  		     data: query,
  		     success: function(data){
  		    	var str1 = '<p id="ck">';
	    		var loc = data.indexOf(str1);
	    		var len = str1.length;
	    		var check = data.substr(loc+len,1);
	    		if(check == "1"){//
	    			alert("QnA가 등록되었습니다.");
 		    		var query = "/shoppingmall/bookContent.do?book_id="+book_id;
 		    		query += "&book_kind="+book_kind;
 		    		window.location.href=query;
	    	     }else
	    	    	 alert("QnA 등록 실패");
  		     }
  		  });
	});*/
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
	
};

// 댓글 창 크기 자동 조절
function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (obj.scrollHeight) + 'px';
};

// 푸터 네비 바 나타나기
$(window).scroll(function() {
    if($(this).scrollTop() < 300) {
        $(".footnav").hide();
    } else {
        $(".footnav").show();
    }
});
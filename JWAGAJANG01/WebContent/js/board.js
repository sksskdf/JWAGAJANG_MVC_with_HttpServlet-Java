function noticeCheck() {
	if (document.frm.notice_label.value.length == 0) {
	alert("분류를 선택하세요.");
	return false;
	}
	if (document.frm.notice_title.value.length == 0) {
	alert("제목을 입력하세요.");
	return false;
	}
	if (document.frm.notice_content.value.length == 0) {
	alert("내용을 입력하세요.");
	return false;
	}
	return true;
}

function searchCheck(){
	if (document.searchfrm.searchkeyword.value.length == 0) {
	alert("검색어를 입력하세요.");
	return false;
	}
	return true;
}

function qnaCheck() {
	if (document.qnafrm.qna_title.value.length == 0) {
	alert("제목을 입력하세요.");
	return false;
	}
	if (document.qnafrm.qna_content.value.length == 0) {
	alert("내용을 입력하세요.");
	return false;
	}
	return true;
}


function qnasearchCheck(){
	if (document.srcfrm.searchkeyword.value.length == 0) {
	alert("검색어를 입력하세요.");
	return false;
	}
	return true;
}

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
				$('.noReview').hide();
			},
			error: function(request, status, error) {
				alert(error);

			}
		});
	});

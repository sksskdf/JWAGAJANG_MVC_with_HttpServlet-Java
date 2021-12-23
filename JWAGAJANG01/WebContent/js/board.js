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

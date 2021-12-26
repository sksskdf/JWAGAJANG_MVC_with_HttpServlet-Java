<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="img/favicon/favicon.ico">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="css/header_footer.css">
<title>좌가장 : Q&amp;A</title>
</head>
<body>
	<!-- 헤더영역    -->
	<jsp:include page="H&F/header.jsp" />

	<section>
		<div class="pagenav">
			<a href="index.jsp">홈</a>
			<span class="navarrow"></span>
			<a href="qnaList.do?&p=1">게시판</a>
			<span class="navarrow"></span>
			<a href="qnaList.do?&p=1">Q&amp;A</a>
		</div>
		
		<div class="notice">
			<h1>Q&amp;A</h1>
						<div class="list">
				<input type="submit" value="수정" class="upbtn" onclick="location.href='qnaUpdate.do?qna_code=${param.qna_code}'">
				<input type="submit" value="삭제" class="delbtn" onclick="location.href='qnaDelete.do?qna_code=${param.qna_code}'">
				<input type="submit" value="목록" class="listbtn" onclick="location.href='qnaSearch.do?p=${param.p}&searchkeyword=${param.q}'">
			</div>
			<table class="brdView">	
				<tr class="qnaViewbox">
					<th class="qnaView_label">${board.qna_label}</th>
					<th>${board.qna_title}</th>
					<th>${board.user_id}</th>
					<th><fmt:formatDate value="${board.qna_regdate}"/></th>
					<th>${board.qna_count}</th>
				</tr>
				<tr>
					<td class="content" colspan="5"><pre>${board.qna_content}</pre></td>
				</tr>
			</table>
			<table class="replelist">
			<c:if test="${param.qna_reply != NULL }">
			<tr>
			<td id="hang1">답변</td>
			<td id="hang2">${param.qna_reply}</td>
			<td id="hang3">관리자</td>
			<td id="hang4">작성일</td>
			</tr>
			</c:if>
			</table>
			<%-- <c:if test="${sessionScope.member.grade == 1}">  --%>
			<form class="reply" action="repleWrite.do?qna_code=${param.qna_code}">
				<textarea class="replybox" style="resize: none;"></textarea>
				<div class="replybtn">
				<input type="submit" id="regist" value="등록"></button>
						<input type="button" value="수정" id="replyup"></button>
						<input type="button" value="삭제" id="replydle"></button>
				</div>
			</form>
			<%-- </c:if> --%> 
		</div>
	</section>
	<jsp:include page="H&F/footer.html" />
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>
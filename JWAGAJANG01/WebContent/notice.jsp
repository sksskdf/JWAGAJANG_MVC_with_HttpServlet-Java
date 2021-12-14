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
<link rel="stylesheet" href="css/notice.css">
<link rel="stylesheet" href="css/header_footer.css">
<title>좌가장 : 공지사항</title>
</head>
<body>
	<!-- 헤더영역    -->
	<jsp:include page="H&F/header.jsp" />
	<!-- 섹션 영역 -->
	<section>
		<div class="pagenav">
			<a href="index.jsp">홈</a>
			<span class="navarrow"></span>
			<a href="noticeList.do">게시판</a>
			<span class="navarrow"></span>
			<a href="noticeList.do">공지사항</a>
		</div>
		<div class="notice">
			<h1>공지사항</h1>
			<table>
				<tr class="brdbox">
					<th>구분</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			
				<c:forEach var="board" items="${listModel.noticeList}"> 
					<tr class="record">
						<td class="record_1">${board.notice_label }</td>
						<td class="record_2"><a href="noticeView.do?notice_code=${board.notice_code}"> ${board.notice_title} </a></td>
						<td class="record_3"><fmt:formatDate value="${board.notice_regdate}" /></td>
						<td class="record_4">${board.notice_count}</td>
					</tr>
				</c:forEach>

			</table>
			<div class="writebox">
				<a href="noticeWrite.do"><input type="submit" value="글쓰기" name="write" class="writebtn"></a>
			</div>
		</div>
		
		
		<div class="paging">
		<c:set var="paging" value="${listModel.paging}"></c:set> <!-- 변수 선언 -->
			<c:if test="${paging.startPageNo > paging.sizeOfPage}">
				<a href="<c:url value="/noticeList.do?&p=${paging.prevPageNo}"/>"><span class="prev"> </span></a>
			</c:if>
			<c:forEach var="pno" begin="${paging.startPageNo}" end="${paging.endPageNo}">
				<a href="<c:url value="/noticeList.do?&p=${pno}" />">[${pno}]</a>
			</c:forEach>
			<c:if test="${paging.endPageNo < paging.finalPageNo}">
				<a href="<c:url value="/noticeList.do?&p=${paging.nextPageNo}"/>"><span class="next"></span></a>
				</c:if>  
		</div>
		<div class="noticeSrc">
			<input class="searchtext" type="text" name="search" value="검색할 제목, 내용을 입력하세요.">
			<input class="searchbtn" value="찾기" type="submit">
		</div>
	</section>
	
	
	<!-- 푸터영역 -->
	<jsp:include page="H&F/footer.html" />
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>
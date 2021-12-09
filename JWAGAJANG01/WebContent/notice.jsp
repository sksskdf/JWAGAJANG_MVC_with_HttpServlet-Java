<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="img/favicon/favicon.ico">
<title>좌가장 : 공지사항</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/notice.css">
<link rel="stylesheet" href="css/header_footer.css">

</head>
<body>
	<!-- 헤더영역    -->
  <jsp:include page="H&F/header.html"/>
	<!-- 섹션 영역 -->
	<section>
		<div class="pagenav">
			홈<span class="navarrow"></span>게시판<span class="navarrow"></span>공지사항
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
			</table>
			<div class="writebox">
				<input type="submit" value="글쓰기" name="write" class="writebtn">
			</div>
		</div>
		<div class="paging">
			<span class="prev"></span> <span class="next"></span>
		</div>
		<div class="noticeSrc">
			<input class="searchtext" type="text" name="search"> <input
				class="searchbtn" value="찾기" type="submit">
		</div>
	</section>
	<!-- 푸터영역 -->
	<jsp:include page="H&F/footer.html" />
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>
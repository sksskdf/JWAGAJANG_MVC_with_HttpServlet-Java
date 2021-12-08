<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="../img/favicon/favicon.ico">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/reset.css" type="text/css">
<link rel="stylesheet" href="../css/notice.css" type="text/css">
<title>좌가장 : 공지사항</title>

</head>

<body>
  <jsp:include page="H&F/header.html"/>
	<section>
		<div class="pagenav">
			홈<span class="navarrow"></span>게시판<span class="navarrow"></span>공지사항
		</div>
		<div class="notice">
			<h1>공지사항</h1>
			<table class="brdWritebox">
				<tr>
					<th>분류</th>
				</tr>
				<tr>
				<th>제목</th>
				</tr>
				<tr>
				<th>작성일</th>
				</tr>
			</table>
			<div class="list">
				<input type="button" value="수정" name="update" class="upbtn">
				<input type="button" value="삭제" name="delete" class="delbtn">
				<input type="button" value="목록" name="list" class="listbtn">
			</div>
		</div>
		<div class="paging">
			<span class="prev"></span> <span class="next"></span>
		</div>
		<div class="search">
			<input class="searchtext" type="text" name="search"> <input
				class="searchbtn" value="찾기" type="button">
		</div>
	</section>
	<jsp:include page="H&F/footer.html"/>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/index.js"></script>
</body>

</html>
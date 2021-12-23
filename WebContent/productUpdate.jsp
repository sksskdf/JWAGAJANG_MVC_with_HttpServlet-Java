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
<link rel="stylesheet" href="css/productWrite.css">
<title>좌가장 : 제품수정</title>
</head>

<body>
   <!-- 헤더영역    -->
                <jsp:include page="H&F/header.jsp" />
	<!-- 제품수정 -->
<section>
		
		<div class="pagenav">
			<a href="index.jsp">홈</a>
			<span class="navarrow"></span>
			<a href="productList.do">마이페이지</a>
			<span class="navarrow"></span>
			<a href="productList.do">제품관리</a>
			<span class="navarrow"></span>
			<a href="productUpdate.do">제품수정</a>
		</div>
		
		
		<div class="productUpdate">
			<h1>제품수정</h1>
			<form name="frm" method="post" action="productUpdate.do">
			<table class="prodWritebox">
				<tr>
					<th width="150px">구분</th>
					<th>
						<select class="sortinput" name="notice_label">
							<option>대분류</option>
							<option>채소·과일</option>
							<option>쌀·견과류</option>
							<option>수산·해산</option>
							<option>정육·계란</option>
						</select>
						<select class="sortinput" name="notice_label">
							<option>소분류</option>
							<option>채소·과일</option>
							<option>쌀·견과류</option>
							<option>수산·해산</option>
							<option>정육·계란</option>
						</select>
					</th>
				</tr>
				<tr>
					<th width="150px">상품</th>
					<th><input class="titleinput" type="text" name="title" placeholder="기존 상품명" style="border: 0px"></th>
				</tr>
				<tr>
					<th width="150px">상품가격</th>
					<th><input class="titleprice" type="text" name="price" placeholder="기존 가격" style="border: 0px"></th>
				</tr>
				<tr>
					<th width="150px">할인율</th>
					<th><input class="titledc" type="text" name="dc" style="width: 90px"> % </th>
				</tr>
				<tr>
					<th width="150px">재고</th>
					<th><input class="titlestock" type="text" name="stock" style="width: 90px"></th>
				</tr>
				<tr>
					<th width="150px">배송비</th>
					<th><input class="titledeliprice" type="hidden" name="deliprice">&nbsp;&nbsp;&nbsp;&nbsp;  2,500원</th>
				</tr>
				<tr>
					<th width="150px">메인 이미지 첨부</th>
					<th><input class="titleimg" type="file" name="img"></th>
				</tr>
				<tr>
					<th width="150px">상세 이미지 첨부</th>
					<th><input class="subimg" type="file" name="img2"></th>
				</tr>
			</table>
			
			<div class="productWritebtn">
				<input type="reset" value="다시쓰기" name="reset" class="resetbtn">
				<input type="submit" value="등록" name="send" class="sendbtn">
				<input type="button" value="목록" name="writelist" class="writelistbtn" onclick="location.href='productList.jsp'">
			</div>
			</form>
		</div>
	</section>

                <!-- 푸터영역 -->
                <jsp:include page="H&F/footer.html" />
                <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
                <script src="js/jquery.min.js"></script>
                <script src="js/index.js"></script>
                <script src="js/product.js"></script>
            </body>

            </html>
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
                <link rel="stylesheet" href="css/prodcutList.css">
                <link rel="stylesheet" href="css/reset.css">
                <link rel="stylesheet" href="css/notice.css">
                <link rel="stylesheet" href="css/header_footer.css">
                <link rel="stylesheet" href="css/productList.css">
				<title>상품 삭제</title>

</head>

	<body>
		<!-- 헤더영역    -->
        <jsp:include page="H&F/header.jsp" />

	<div id="wrap" align="center">
		<h1>상품 삭제 - 관리자 페이지</h1>
		<form action="delete.do" method="post">
			<table>
				<tr>
					<td>
				<c:choose>
					<c:when test="${empty product.pictureUrl}">
						<img src="img/best2.jpg">
					</c:when>
					<c:otherwise>
						<img src="../upload/${product.pictureUrl}">
					</c:otherwise>
				</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상 품 명</th>
								<td>${product.name}</td>
							</tr>
							<tr>
								<th>가 격</th>
								<td>${product.price}원</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><div style="height: 220px; width: 100%">
										${product.description}</div></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="code" value="${product.code}">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</form>
	</div>
	
  <!-- 푸터영역 -->
                <jsp:include page="H&F/footer.html" />
                <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
                <script src="js/jquery.min.js"></script>
                <script src="js/index.js"></script>
</body>

</html>
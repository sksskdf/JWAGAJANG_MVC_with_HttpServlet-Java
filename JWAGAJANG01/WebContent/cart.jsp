<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="img/favicon/favicon.ico">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header_footer.css">
<link rel="stylesheet" href="css/cart.css" />
<title>장바구니</title>
</head>
<body>
	<div id="pagewrap">
		<jsp:include page="H&F/header.jsp" />
		<section>
			<div class="pagenav">
				홈<span class="navarrow"></span>장바구니
			</div>
			<div id="cartwrap">
				<h1>장바구니</h1>
				<div class="cartnav">
					<span class="nowpage">1. 장바구니</span><span class="navarrow"></span>
					2. 주문서 작성 / 결제<span class="navarrow"></span> 3. 주문완료
				</div>
				<form action="#" class="cartform">
					<table class="cartconts">
						<thead>
							<tr>
								<th width="8.3945435%"><input type="checkbox" id="allchk"/></th>
								<th width="49.162644%">상품명</th>
								<th width="11.962224%">구매수량</th>
								<th width="18.258132%">주문금액</th>
								<th width="11.962224%">선택</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${empty cartList}">
							<tr>
								<td colspan="5">장바구니가 비었습니다.</td>
							</tr>
						</c:if>
							<c:if test="${!empty cartList}">
							<c:forEach items="${cartList }" var="cart">
							<tr>
								<td><input type="checkbox" class="mdchk" value="   "/></td>
								<td class="md" style="text-align: left"><img
									src="${cart.img_main }" /> <span class="mddesc"><a href="#">${cart.md_name }</a></span></td>
								<td><span class="stepper">
										<button>–</button> <input type="number" id="stepper" value="${cart.md_count }"
										min="0" max="100" step="1" readonly>
										<button>+</button>
								</span></td>
								<td><span class="originprice"><fmt:formatNumber pattern="#,##0" value="${cart.md_price }"/>원</span><br />
								<span class="saleprice"><fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(cart.md_price-(cart.md_price*cart.md_dc/100), '.')}"/>원</span></td>
								<td><input type="button" class="colorbtn" value="바로구매" />
									<input type="button" class="normalbtn" value="삭제"
									style="margin-top: 5px" /></td>
							</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>
					<div class="pricewrap">
						<div class="pricelist">
							<span class="pricedesc">주문 금액</span><br /> <span class="price">1,760원</span>
						</div>
						<div class="operator">+</div>
						<div class="pricelist">
							<span class="pricedesc">배송비</span><br /> <span class="price">1,760원</span>
						</div>
						<div class="operator">=</div>
						<div class="pricelist">
							<span class="pricedesc">총 주문금액</span><br /> <span class="price">1,760원</span>
						</div>
					</div>
					<div class="buttonsec">
						<div class="btnsecL">
							<input type="button" class="normalbtn" value="선택삭제" /> <input
								type="button" class="normalbtn" value="찜하기" />
						</div>
						<div class="btnsecR">
							<input type="submit" class="colorbtn" value="선택 상품 주문하기" /> <input
								type="button" class="normalbtn" value="계속 쇼핑하기" />
						</div>
					</div>
				</form>
			</div>
		</section>
		<jsp:include page="H&F/footer.jsp" />
	</div>
	<script src="js/cart.js"></script>
</body>
</html>
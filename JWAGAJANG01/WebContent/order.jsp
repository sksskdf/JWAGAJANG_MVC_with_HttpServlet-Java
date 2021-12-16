	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="img/favicon/favicon.ico">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/header_footer.css">
<link rel="stylesheet" href="css/order.css" />
<title>주문하기</title>
</head>
<body>
	<div id="pagewrap">
	<jsp:include page="H&F/header.jsp"/>
	<section>
	<div class="pagenav">홈<span class="navarrow"></span>장바구니<span class="navarrow"></span>주문서 작성</div>
	<div id="orderwrap">
	<h1>주문서 작성 / 결제</h1>
    	<div class="cartnav">1. 장바구니<span class="navarrow"></span>
    	<span class="nowpage">2. 주문서 작성 / 결제</span><span class="navarrow"></span>
    	3. 주문완료</div>
    	<table class="orderlist">
    	<tr>
    		<td>주문상품</td>
    		<td>[민선지] 맛있는 채소주스 외 2건 </td>
    	</tr>
   		</table>
    	<form action="ppppay.do" class="orderform" name="orderfrm" method="post">
    	<table class="ordertable">
    		<tr>
    			<td>배송지 정보</td>
    			<td style="text-align: right;"><input type="checkbox" />주문자 정보와 동일</td>
    		</tr>
    		<tr>
    			<td>수령인</td>
    			<td><input type="text" name="name" id="name"/></td>
    		</tr>
    		<tr>
    			<td>휴대폰번호</td>
    			<td><input type="text" name="phone" placeholder="'-' 포함 입력" /></td>
    		</tr>
    		<tr>
    			<td >주소</td>
    			<td><input type="text" id="postnum" name="postnum" placeholder="우편번호" readonly="readonly"/><input type="button" value="우편번호 찾기" class="findpostnum" onclick="execDaumPostcode()"/> <br />
    			<input type="text" id="address" name="address" placeholder="주소" readonly="readonly"/><br />
    			<input type="text" id="addDetail" name="addDetail" placeholder="상세주소"/></td>
    		</tr>
    		<tr>
    			<td>배송요청사항</td>
    			<td><input type="text" /></td>
    		</tr>
    	</table>
    	<input type="button" value="결제하기" class="paybutton" onclick="orderCheck()"/>
    	</form>
    </div>
	</section>
	<jsp:include page="H&F/footer.jsp"/>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/order.js"></script>
</body>
</html>
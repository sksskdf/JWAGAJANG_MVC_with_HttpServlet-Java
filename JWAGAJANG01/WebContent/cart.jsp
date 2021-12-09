<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="H&F/header.jsp"/>
    <div class="pagenav">홈<span class="navarrow"></span>장바구니</div>
    <div id="cartwrap">
    	<h1>장바구니</h1>
    	<div class="cartnav"><span class="nowpage">1. 장바구니</span><span class="navarrow"></span>
    	2. 주문서 작성 / 결제<span class="navarrow"></span>
    	3. 주문완료</div>
    	<form action="" class="cartform">
    	<table class="cartconts">
    		<thead>
    		<tr>
    			<th width="8.3945435%"><input type="checkbox" /></th>
    			<th width="49.162644%">상품명</th>
    			<th width="11.962224%">구매수량</th>
    			<th width="18.258132%">주문금액</th>
    			<th width="11.962224%">선택</th>
    		</tr>
    		</thead>
    		<tbody>
    		<tr>
    			<td><input type="checkbox" /></td>
    			<td class="md" style="text-align : left"><img src="img/md01.jpg"/>
    			<span class="mddesc"><a href="#">[민선지] 맛있는 채소주스</a></span></td>
    			<td><!-- 구매수량 input --></td>
    			<td><span class="originprice">2,200원</span><br /><span class="saleprice">1,760원</span></td>
    			<td><input type="button" class="colorbtn" value="바로구매" />
    			<input type="button" class="normalbtn" value="삭제" style="margin-top:5px"/></td>
    		</tr>
    		</tbody>
    	</table>
    	<div class="pricewrap">
    		<div class="pricelist"><span class="pricedesc">주문 금액</span><br />
    		<span class="price">1,760원</span></div>
    		<div class="operator">+</div>
    		<div class="pricelist"><span class="pricedesc">배송비</span><br />
    		<span class="price">1,760원</span></div>
    		<div class="operator">=</div>
    		<div class="pricelist"><span class="pricedesc">총 주문금액</span><br />
    		<span class="price">1,760원</span></div>
    	</div>
    	</form>
    </div>
<jsp:include page="H&F/footer.html"/>
</body>
</html>
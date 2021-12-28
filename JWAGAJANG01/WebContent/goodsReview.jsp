<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<tr>
	<td class="review_name">${review.user_id}</td>
	<td class="review_rate">${review.review_rate} / 5</td>
	<td class="review_content">${review.review_content}</td>
	<td class="review_date"><fmt:formatDate value="${review.review_regdate}" pattern="yyyy-MM-dd"/></td>
</tr>
    
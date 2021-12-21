<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="img/favicon/favicon.ico">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/notice.css">
<link rel="stylesheet" href="css/header_footer.css">
<link rel="stylesheet" href="css/productList.css">
<title>좌가장 : 제품관리</title>

</head>

<body>
   <!-- 헤더영역    -->
                <jsp:include page="H&F/header.jsp" />

                <!-- 제품 관리-->
                <section>
                    <form name="frm" method="post" action="productList.do">
                                             
                        <div class="pagenav">
						<a href="index.jsp">홈</a>
						<span class="navarrow"></span>
						<a href="productList.do">마이페이지</a>
						<span class="navarrow"></span>
						<a href="productList.do">제품관리</a>
						</div>
						
                        <div class="titleproductList">
                            <h1>제품관리        &nbsp;&nbsp;
                                <input type="button" value="제품등록" onclick="location.href='productWrite.jsp'">
                            </h1>
                        </div>
                        <div class="sort">
                            <select id="selBoxFirst" name="selBox" title="대분류" onChange="javascript:onFirstSelectChanged(this)">
						<option value="0" name="" selected>대분류</option>
							<option>채소·과일</option>
							<option>쌀·견과류</option>
							<option>수산·해산</option>
							<option>정육·계란</option>
						</select>
                            <select id="selBoxSecond" name="selBox" title="소분류" onChange="javascript:onSecondSelectChanged(this)">
						<option value="0" selected>소분류</option>
							<option>채소·과일</option>
							<option>쌀·견과류</option>
							<option>수산·해산</option>
							<option>정육·계란</option>
							</select>

                            <div class="sortlist">
                                <table class="sort2">
                                    <tbody>
                                        <tr>
                                            <td>판매량순</td>
                                            <td>낮은가격</td>
                                            <td>높은가격</td>
                                            <td>최신상품</td>
                                            <td>상품평</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <br>

                        <!-- th만 작성시 가로로 데이터 작성됨-->
                        <div class="productList">
                            <table class="productListtable">
                                <colgroup>
                                    <col style="width: 300px; height:300px;">
                                    <col style="width: 900px; height:300px;">
                                    <col style="width: 200px; height:300px;">
                                    <col style="width: 400px; height:300px;">
                                    <col style="width: 400px; height:300px;">
                                    <col style="width: 179px; height:300px;">
                                </colgroup>

                                <tr class="tabletitle">
                                    <th colspan="2">상품명</th>
                                    <th>재고</th>
                                    <th>제품등록일</th>
                                    <th>제품금액</th>
                                    <th>리뷰</th>
                                </tr>
                                <tr>
                                    <td><img src="img/best2.jpg"></td>
                                    <td>[민선지] 빨간 세척 당근</td>
                                    <td>78</td>
                                    <td>2021-12-03</td>
                                    <td>1,760원</td>
                                    <td><input type="button" value="수정" class="editbtn" onclick="location.href='productUpdate.jsp'">
                                        <br><input type="button" value="삭제" class="deletebtn"></td>
                                </tr>
                                <tr>
                                    <td><img src="img/best1.jpg"></td>
                                    <td>[박민지] 맛좋은 청경채</td>
                                    <td>203</td>
                                    <td>2021-12-03</td>
                                    <td>1,760원</td>
                                    <td><input type="button" value="수정" class="editbtn" onclick="location.href='productUpdate.jsp'">
                                        <br><input type="button" value="삭제" class="deletebtn"></td>
                                </tr>
                                <tr>
                                    <td><img src="img/best3.jpg"></td>
                                    <td>[길기훈] 신선한 고등어</td>
                                    <td>23</td>
                                    <td>2021-12-03</td>
                                    <td>1,760원</td>
                                    <td><input type="button" value="수정" class="editbtn" onclick="location.href='productUpdate.jsp'">
                                        <br><input type="button" value="삭제" class="deletebtn"></td>
                                </tr>
                                 <tr>
                                    <td><img src="img/best4.jpg"></td>
                                    <td>[남현우] 달고 맛있는 대추토마토</td>
                                    <td>23</td>
                                    <td>2021-12-03</td>
                                    <td>1,760원</td>
                                    <td><input type="button" value="수정" class="editbtn" onclick="location.href='productUpdate.jsp'">
                                        <br><input type="button" value="삭제" class="deletebtn"></td>
                                </tr>
                            </table>
                        </div>
						<br>
						<div class="pg_wrap">
						 <!-- 변수 선언 -->
				
								<a class="pg_prev" href="/productList.do?&amp;p=0">
								<span class="prev"></span></a>
								
								<a href="/productList.do?&amp;p=1&amp;f=">
								<input type="button" class="pg_currpno" value="1"></a>
							
								<a href="/productList.do?&amp;p=2&amp;f=">
								<input type="button" class="pg_currpno" value="2"></a>
							
								<a href="/productList.do?&amp;p=3&amp;f=">
								<input type="button" class="pg_currpno" value="3"></a>
							
								<a href="/productList.do?&amp;p=4&amp;f=">
								<input type="button" class="pg_currpno" value="4"></a>
							
								<a href="/productList.do?&amp;p=5&amp;f=">
								<input type="button" class="pg_currpno" value="5"></a>
							
								<a href="/productList.do?&amp;p=6&amp;f=">
								<input type="button" class="pg_currpno" value="6"></a>
							
								<a href="/productList.do?&amp;p=7&amp;f=">
								<input type="button" class="pg_currpno" value="7"></a>
							
								<a href="/productList.do?&amp;p=8&amp;f=">
								<input type="button" class="pg_currpno" value="8"></a>
							
								<a href="/productList.do?&amp;p=9&amp;f=">
								<input type="button" class="pg_currpno" value="9"></a>
							
								<a href="/productList.do?&amp;p=10&amp;f=">
								<input type="button" class="pg_currpno" value="10"></a>
							
								<a class="pg_next" href="/productList.do?&amp;p=11">
								<span class="next"></span></a>

						</div>
						
                    </form>
                </section>


                <!-- 푸터영역 -->
                <jsp:include page="H&F/footer.html" />
                <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
                <script src="js/jquery.min.js"></script>
                <script src="js/index.js"></script>
            </body>

            </html>
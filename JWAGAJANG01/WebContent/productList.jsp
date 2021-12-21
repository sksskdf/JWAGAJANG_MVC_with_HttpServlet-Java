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
                <link rel="stylesheet" href="css/productList.css">
                <title>좌가장 : 제품관리</title>

            </head>

            <body>
                <!-- 헤더영역    -->
                <jsp:include page="H&F/header.jsp" />

                <!-- 제품 관리-->
                <section>
                    <form>
                        <div class="pagenav">
                            홈<span class="navarrow"></span>마이페이지<span class="navarrow"></span>제품관리
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

                        <!--css 호버 사용 pagination-->
                        <div class="hover-slider">
                            <ul>
                                <li><a type="button" class="prev" onclick="plusSlides(-1)">❮</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">6</a></li>
                                <li><a href="#">7</a></li>
                                <li><a href="#">8</a></li>
                                <li><a href="#">9</a></li>
                                <li><a href="#">10</a></li>
                                <li><a type="button" class="next" onclick="plusSlides(1)">❯</a></li>
                            </ul>
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
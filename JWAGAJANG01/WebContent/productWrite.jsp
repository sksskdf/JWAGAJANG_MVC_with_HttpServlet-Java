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
                <link rel="stylesheet" href="css/productWrite.css">
                <title>좌가장 : 제품등록</title>

            </head>

            <body>
                <!-- 헤더영역    -->
                <jsp:include page="H&F/header.jsp" />

                <!-- 상품등록 -->

                <section>
                    <form>
                        <div class="pagenav">
                            홈<span class="navarrow"></span>마이페이지<span class="navarrow"></span>제품등록
                        </div>

                        <div class="titleproductWrite">
                            <h1>제품등록</h1>
                            <!-- 테이블 -->

                            <table>
                                <tr class="box1">
                                    <th>구분</th>
                                    <td>
                                        <select id="selBoxFirst" name="selBox" title="대분류" onChange="javascript:onFirstSelectChanged(this)">
                <option value="0" name="" selected>전체</option>
                <!-- 여기에 추가됨(아래와 같은 식으로) -->
                <!--
                <option value="0" name="optInFirstSelBox"></option>
                 -->            
            </select>
                                    </td>
                                    <td>
                                        <select id="selBoxSecond" name="selBox" title="중분류" onChange="javascript:onSecondSelectChanged(this)">
                <option value="0" selected>전체</option>
                <!-- 여기에 추가됨(아래와 같은 식으로) -->
                <!--
                <option value="0" name="optInSecondSelBox"></option>
                -->            
            </select>
                                    </td>
                                    <td>
                                        <select id="selBoxThird" name="selBox" title="소분류" onChange="javascript:onThirdSelectChanged(this)">
                <option value="0" selected>전체</option>
                <!-- 여기에 추가됨(아래와 같은 식으로) -->
                <!--
                <option value="0" name="optInThirdSelBox"></option>
                -->            
            </select>
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr class="box2">
                                    <th>상품</th>
                                    <td>
                                            <input type="text" name="productName" placeholder='제목을 입력해주세요.'>
                                    </td>
                                </tr>
                            </table>
                            <table>
                                <tr class="box3">
                                    <th>상품가격</th>
                                    <td>
                                        <input type="text" name='productPrice' placeholder='가격을 입력해주세요.'>
                    </td>

                    </tr>
                    </table>
                    <table>
                        <tr class="box4">
                            <th>할인율</th>
                            <td>
                                <input type="text">
                            </td>
                            <td>%</td>

                        </tr>
                    </table>
                    <table>
                        <tr class="box5">
                            <th>재고</th>
                            <td>
                                <input type="text">
                            </td>
                            <td></td>
                        </tr>
                    </table>
                    <table>
                        <tr class="box6">
                            <th>배송비</th>
                            <td>2,500원</td>

                        </tr>
                    </table>
                    <table>
                        <tr class="box7">
                            <th>메인이미지 첨부</th>
                            <td> <input type="file" name="file" id="imageFileOpenInput" accept="image/*"></td>

                        </tr>
                    </table>
                    <table>
                        <tr class="box8">
                            <th>상세이미지 첨부</th>
                            <td> <input type="file" name="file" id="imageFileOpenInput" accept="image/*"></td>
                        </tr>
                    </table>
                    <br>

                    <div class="productWrite_button">
                        <input type='reset' value="다시쓰기">
                        <input type='submit' value="등록">
                        <input type='button' value="목록" onclick="location.href='productList.jsp'">
                    </div>
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
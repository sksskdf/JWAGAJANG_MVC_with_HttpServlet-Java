<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/goods.css">
    <link rel="stylesheet" href="css/header_footer.css">
    <link rel="shortcut icon" href="img/favicon/favicon.ico">
    <script src="js/jquery.min.js"></script>
    <script src="js/goods.js"></script>
    <title>좌가장</title>
</head>
<body>
	<div id="top"></div>
    <!-- 헤더 -->
    <jsp:include page="H&F/header.jsp"/>
    <!-- 본문  -->
    <div id="wrap">
        <div class="pagenav">
	       <a href="/index.do">홈</a>
	       <span class="navarrow"></span>
           <a href="#">시금치 · 쌈채소 · 나물</a>
	       <span class="navarrow"></span>
           <a href="#">청경채</a>
        </div>
        <div class="goods">
            <img src="${md.img_main}" class="goods_img">
            <%-- <div class="goods_info"> 총 금액 반영되는거 바꾸고 삭제할 것
                <p class="goods_title">${md.md_name}</p>
                <p class="goods_price">
                    <span class="price"><fmt:formatNumber pattern="#,##0" value="${md.md_price}"/>원</span>
                    <span class="goods_dc">
                        <span class="cost"><fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/>원</span>
                        <span class="dc">${md.md_dc}%</span>
                    </span>
                </p>
                <hr>
                <dl class="shipping">
                    <dt><p>택배배송</p></dt>
                    <dd>
                        <p>2,500원 <span class="orderpay">(주문시 결제)</span></p>
                        <p class="addshipping">제주, 도서지역 추가 5,000원</p>
                    </dd>
                </dl>
                <dl class="count">
                    <dt><p>주문수량</p></dt>
                    <dd>
                        <span class="countbtn">
                            <button type="button" class="minusbtn"><a href="javascript:change_qty('minus')">-</a></button>
                            <input type="number" id="goods_qty" readonly="readonly" min="1" max="10" value="1">
                            <button type="button" class="plusbtn"><a href="javascript:change_qty('plus')">+</a></button>
                        </span>
                    </dd>
                </dl>
                <hr>
                <dl class="total">
                    <dt>구매금액</dt>
                    <dd>
                        <em><fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/></em>원 &nbsp; x &nbsp;
                        <em class="total_qty">1</em>개
                    </dd>
                </dl>
                <div class="total_price">
                    <p class="won"><span class="total_cost">
                    <fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/></span>원</p>
                </div>
                <div class="btn">
                    <button type="button" class="buynowbtn">바로구매</button>
                    <button type="button" class="cartbtn">장바구니</button>
                    <button type="button" class="favbtn">찜하기</button>
                </div>
            </div> --%>
            <div class="goods_info">
                <p class="goods_title">${md.md_name}</p>
                <p class="goods_price">
                    <span class="price"><fmt:formatNumber pattern="#,##0" value="${md.md_price}"/>원</span>
                    <span class="goods_dc">
                        <span class="cost"><fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/>원</span>
                        <span class="dc">${md.md_dc}%</span>
                    </span>
                </p>
                <hr>
                <dl class="shipping">
                    <dt><p>택배배송</p></dt>
                    <dd>
                        <p>2,500원 <span class="orderpay">(주문시 결제)</span></p>
                        <p class="addshipping">제주, 도서지역 추가 5,000원</p>
                    </dd>
                </dl>
                <dl class="count">
                    <dt><p>주문수량</p></dt>
                    <dd>
                        <span class="countbtn">
                            <button type="button" class="minusbtn"><a href="javascript:change_qty('minus')">-</a></button>
                            <input type="number" id="goods_qty" readonly="readonly" min="1" max="${md.md_stock}" value="1">
                            <button type="button" class="plusbtn"><a href="javascript:change_qty('plus')">+</a></button>
                        </span>
                    </dd>
                </dl>
                <hr>
                <dl class="total">
                    <dt>구매금액</dt>
                    <dd>
                        <em><fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/></em>원 &nbsp; x &nbsp;
                        <em class="total_qty">1</em>개
                    </dd>
                </dl>
                <div class="total_price">
                    <p class="won"><span class="total_cost">
                    <fmt:formatNumber pattern="#,##0" value="${fn:substringBefore(md.md_price-(md.md_price*md.md_dc/100), '.')}"/></span>원</p>
                </div>
                <div class="btn">
                    <button type="button" class="buynowbtn">바로구매</button>
                    <button type="button" class="cartbtn">장바구니</button>
                    <button type="button" class="favbtn">찜하기</button>
                </div>
            </div>
            
            
            
            
            <div id="goods_detail">
                <ul class="goods_tab">
                    <li><a href="#goods_detail" class="tab_on detail_anchor">상품 상세 정보</a></li>
                    <li><a href="#goods_review" class="tab_off review_anchor">상품평 (${count}건)</a></li>
                </ul>
                <img src="img/mddetailimg.png" class="goods_img_detail">
            </div>
            <div id="goods_review">
                <ul class="goods_tab">
                    <li><a href="#goods_detail" class="tab_off detail_anchor">상품 상세 정보</a></li>
                    <li><a href="#goods_review" class="tab_on review_anchor">상품평 (${count}건)</a></li>
                </ul>
                <div class="review_title">
                    <p class="review_tit">상품평</p>
                    <p class="review_desc">· 상품에 대한 후기를 남기는 공간입니다. 상품평 운영원칙 및 법령에 위반되는 경우에는 해당 상품평에 대한 필요한 조치가 취해질 수 있습니다.</p>
                </div>
                <table class="review_list">
                <c:if test="${count == 0}">
                	<p class="noReview">등록된 상품평이 없습니다.</p>
                </c:if>
                <c:if test="${count > 0}">
	                <c:forEach var="review" items="${reviewList}">
	                	<tr>
	                        <td class="review_name">${review.user_name}</td>
	                        <td class="review_rate">${review.review_rate}</td>
	                        <td class="review_content">${review.review_content}</td>
	                        <td class="review_date"><fmt:formatDate value="${review.review_regdate}" pattern="yyyy-MM-dd"/></td>
	                    </tr>
	                </c:forEach>
				</c:if>
                </table>
                <table class="review_write">
				<c:if test="${empty sessionScope.id}">
					<p class="reveiwLogin">상품평을 작성하시려면 <a href="/login.do">로그인</a> 하세요</p>	<%-- 로그인하고 다시 돌아올 수 있나? --%>
				</c:if>
				
				
				
				<%-- <c:if test="${!empty sessionScope.id}"> --%>
					<tr>
                        <td class="write_name">
                            <input type="text" id="writer">
                        </td>
                        <td class="write_rate">
                            <input type="text" id="stars" placeholder="★★★★★"
                                onfocus="this.placeholder=''" onblur="this.placeholder='★★★★★'">
                        </td>
                        <td class="write_content">
                            <textarea type="text" id="writervw" placeholder="상품평을 작성해주세요."
                                onfocus="this.placeholder=''" onblur="this.placeholder='상품평을 작성해주세요.'"
                                onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
                        </td>
                        <td class="write_submit">
                            <input type="submit" id="submitbtn" value="등록"></button>
                        </td>
                    </tr>
				<%-- </c:if> --%>
               
                
                
                    <!-- <tr> 로그인 후 리뷰 등록되는지 확인하고 지우면 됨 
                        <td class="write_name">
                            <input type="text" id="writer" placeholder="작성자" 
                                onfocus="this.placeholder=''" onblur="this.placeholder='작성자'">
                        </td>
                        <td class="write_rate">
                            <input type="text" id="stars" placeholder="★★★★★"
                                onfocus="this.placeholder=''" onblur="this.placeholder='★★★★★'">
                        </td>
                        <td class="write_content">
                            <textarea type="text" id="writervw" placeholder="상품평을 작성해주세요."
                                onfocus="this.placeholder=''" onblur="this.placeholder='상품평을 작성해주세요.'"
                                onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
                        </td>
                        <td class="write_submit">
                            <input type="submit" id="submitbtn" value="등록"></button>
                        </td>
                    </tr> -->
                </table>
            </div>
        </div>
        <div class="footnav">
            <div class="footnav_list">
                <ul>
                    <a href="/index.do"><li>홈</li></a>
                    <div class="line"></div>
                    <a href="#"><li>장바구니</li></a>
                    <div class="line"></div>
                    <a href="#"><li><a href="#">찜리스트</li></a>
                </ul>
            </div>
            <div class="footnav_latest">
                <p>최근 본 상품</p>
                <ul>
                    <li><a href=""><img src="img/best1.jpg"></a></li>
                </ul>
                <a href="#top" class="top_btn"><img src="img/up.png"></a>
            </div>
        </div>
    </div>
    <!-- 푸터 -->
    <jsp:include page="H&F/footer.html"/>
    <script src="js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/goods.css">
    <title>좌가장</title>
</head>
<body>
    <!-- 헤더 -->
    <jsp:include page="H&F/header.html"/>
    <!--  본문 -->
    <section id="wrap">
        <div class="pagenav">
            홈<span class="navarrow"></span>
            게시판<span class="navarrow"></span>
            공지사항
        </div>
        <div class="goods">
            <img src="img/best1.jpg" class="mdimg">
            <div class="goods_info">
                <p class="goods_title">[박민지] 외로운 청경채</p>
                <p class="goods_price">
                    <span class="price">2,200원</span>
                    <span class="goods_dc">
                        <span class="cost">1,760원</span>
                        <span class="dc">20%</span>
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
                    <dd class="countbtn">
                        <button type="button" class="minusbtn">-</button>
                        <input type="text" class="goods_qty">
                        <button type="button" class="plusbtn">+</button>
                    </dd>
                </dl>
                <hr>
                <dl class="total">
                    <dt>구매금액</dt>
                    <dd>
                        <em>1,760</em>원 &nbsp; x &nbsp;
                        <em>10</em>개
                    </dd>
                </dl>
                <div class="total_price">
                    <p class="won"><span class="total_cost">17,600</span>원</p>
                </div>
                <div class="btn">
                    <button type="button" class="buynowbtn">바로구매</button>
                    <button type="button" class="cartbtn">장바구니</button>
                    <button type="button" class="favbtn">찜하기</button>
                </div>
            </div>
        </div>
    </section>
    <!-- 푸터 -->
    <jsp:include page="H&F/footer.html"/>
    <script src="js/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/header_footer.css">
    <link rel="shortcut icon" href="img/favicon/favicon.ico">
    <link rel="stylesheet" href="css/swiper-bundle.css">
    <link rel="stylesheet" href="css/index.css">
    <title>좌가장</title>
</head>
<body>

<jsp:include page="H&F/header.jsp"/>
    <!--슬라이더 영역-->
    <div class="swiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="img/slider1.jpg"></div>
        <div class="swiper-slide"><img src="img/slider2.jpg"></div>
        <div class="swiper-slide"><img src="img/slider3.jpg"></div>
      </div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-button-next"></div>
      <div class="swiper-pagination"></div>
   </div>

   <div id="contentwrap">
    <div class="bestTitle">
      <h1>BEST</h1><p><a href="#"> 더보기 > </a></p>
    </div>
    <div class="bestContents">
    <div class="bItem1"><img src="img/best1.jpg">
    <p><span class="title">[박민지] 맛 좋은 청경채</span><br>
      <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
      <span class="price">2,200원</span></p>
    </div>
    <div class="bItem2"><img src="img/best2.jpg">
      <p><span class="title">[민선지] 빨간 세척 당근</span><br>
        <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
          <span class="price">2,200원</span></p>
    </div>
    <div class="bItem3"><img src="img/best3.jpg">
      <p><span class="title">[길기훈] 신선한 고등어</span><br>
        <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
      <span class="price">2,200원</span></p>
    </div>
    <div class="bItem4"><img src="img/best4.jpg">
      <p><span class="title">[남현우] 달고 맛있는 대추토마토</span><br>
        <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
      <span class="price">2,200원</span></p>
      </div>
    </div>
    
      <div class="newTitle">
        <h1>NEW</h1><p><a href="#"> 더보기 > </a></p>
      </div>
      <div class="newContents">
      <div class="nItem1"><img src="img/best1.jpg">
      <p><span class="title">[박민지] 맛 좋은 청경채</span><br>
        <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
        <span class="price">2,200원</span></p>
      </div>
      <div class="nItem2"><img src="img/best2.jpg">
        <p><span class="title">[민선지] 빨간 세척 당근</span><br>
          <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
          <span class="price">2,200원</span></p>
      </div>
      <div class="nItem3"><img src="img/best3.jpg">
        <p><span class="title">[길기훈] 신선한 고등어</span><br>
          <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
        <span class="price">2,200원</span></p>
      </div>
      <div class="nItem4"><img src="img/best4.jpg">
        <p><span class="title">[남현우] 달고 맛있는 대추토마토</span><br>
          <span class="salerate">20%</span> <span class="saleprice">1,760원</span><br>
        <span class="price">2,200원</span></p>
      </div>
    </div>
  </div>
<jsp:include page="H&F/footer.html"/>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
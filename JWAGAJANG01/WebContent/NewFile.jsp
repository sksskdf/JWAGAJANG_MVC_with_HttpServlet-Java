<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
</head>
<body>

<div id="wrap">
    <header>
    <div class="logo">
      <a href="index.html"><img src="img/logo.svg" alt="로고"></a>
    </div>
    <form class="search">
      <input type="text" id="schText" name="schText"><input type="image" src="img/search.svg" id="schButton" name="schButton">
    </form>
    <nav class="nav">
      <ul class="gnb">
        <li><a href="#">로그인</a></li>
        <li><a href="#">장바구니</a></li>
        <li><a href="#">마이페이지</a></li>
      </ul>
    </nav>
    <nav class="nav">
      <ul class= "mainmenu">
        <li><a href="#" class="allctgry"><img src="img/allctgrybtn.svg">  전체상품</a>
          <ul class="bigclass">
            <li>채소·과일
              <ul class="subclass">
                <li><a href="#">고구마·감자·당근</a></li>
                <li><a href="#">시금치·쌈채소·나물</a></li>
                <li><a href="#">브로콜리·파프리카·양배추</a></li>
                <li><a href="#">양파·마늘·대파·배추</a></li>
                <li><a href="#">오이·호박·고추</a></li>
                <li><a href="#">콩나물·버섯</a></li>
                <li><a href="#">과일</a></li>
              </ul>
            </li>
            <li>쌀·견과류
              <ul class="subclass">
                <li><a href="#">쌀·잡곡</a></li>
                <li><a href="#">견과류 </a></li>
              </ul>
            </li>
            <li>수산·해산
              <ul class="subclass">
                <li><a href="#">생선류</a></li>
                <li><a href="#">해산물·조개류</a></li>
                <li><a href="#">김·미역·해조류</a></li>
              </ul>
            </li>
            <li>정육·계란
              <ul class="subclass">
                <li><a href="#">소고기·돼지고기</a></li>
                <li><a href="#">닭·오리고기</a></li>
                <li><a href="#">계란</a></li>
              </ul>
            </li>
          </ul>
        
        </li>
        <li class="cate"><a href="#">카테고리</a></li>
        <li class="cate"><a href="#">카테고리</a></li>
        <li class="cate"><a href="#">카테고리</a></li>
        <li class="cate" ><a href="#">카테고리</a></li>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">문의게시판</a></li>
      </ul>
    </nav>
  </header>
  </div>
  
  <div class="container-fluid bg d-flex mt-3">
  	<div class="container d-flex justify-content-center" id="bg-white">
      <form  method="post" action="">
        <h5 class="lfb" style="text-align: center; margin-top: 34px;">로그인</h5>
        <input class="lib d-block lis mt-4 py-3 ps-3 cfs"  type="text" placeholder="아이디">
        <input class="lib d-block lis py-3 ps-3 mt-2 cfs" type="password" placeholder="비밀번호">
        <input class="lib d-block btn btn-login cfs" style="margin-top: 27px;" type="submit" value="LOGIN">
        <a class="lib d-block btn mt-2 jbs cfs d-flex justify-content-center align-items-center" href="join.html">회원가입</a>
      </form>
  	</div>
  </div>

  <!-- 푸터 -->
  <footer>
    <img src="img/logo.svg">
    <p>두드림아카데미(주) | 경기 용인시 기흥구 신구로12번길 32 씨케이솔루션빌딩 3층 | 
      고객센터 031-281-3688<br>
      Copyright ⓒ 2021 좌가장 All rights reserved.
    </p>
    <div class="topbtn"><a href="#header"><img src="img/arrowUp.png" alt="위로"></a></div>
  </footer>
  <a href="#" class="position-fixed bottom-0 end-0 me-5 mb-5"><img src="img/up.svg" alt="" width="50"></a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
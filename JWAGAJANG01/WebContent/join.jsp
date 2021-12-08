<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon/favicon.ico">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/custom.css">

  <title>좌가장</title>
</head>
<body>
  <!-- 헤더 -->
  <jsp:include page="H&F/header.html"/>
  <!-- 본문 -->
  <div class="container-fluid bg d-flex mt-3">
  	<div class="container d-flex justify-content-center" id="bg-white-join">
      <form  method="post" action="./MemberJoinAction.me" name="fr">
        <h5 class="lfb" style="text-align: center; margin-top: 38px; font-size: 20px/23px;">회원가입</h5>
        <div class="container row d-flex mt-5" style="margin-top: 13px;">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">아이디</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="id" type="text" placeholder="아이디를 입력하세요.">
          </div>
          <div class="col-md-2 d-flex align-items-center">
            <input class="join-button-font btn jbs cfs" type="button" value="중복확인">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">비밀번호</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="password" type="password" placeholder="비밀번호를 입력하세요.">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">비밀번호 확인</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" type="password" placeholder="비밀번호를 한번 더 입력하세요.">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">이메일</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="email" type="email" placeholder="이메일을 입력하세요.">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">연락처</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="contact" type="text" placeholder="연락처를 입력하세요.">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">주소</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="address1" type="text" placeholder="우편번호">
          </div>
          <div class="col-md-2 d-flex align-items-center">
            <input class="join-button-font btn jbs cfs" type="button" value="주소찾기">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="address2" type="text" placeholder="주소">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="address3" type="text" placeholder="상세주소">
          </div>
        </div>

        <div class="row d-flex justify-content-center">
          <input class="lib btn btn-login cfs" style="margin-top: 27px;" type="submit" value="회원가입">
        </div>
      </form>
  	</div>
  </div>

  <!-- 푸터 -->
<jsp:include page="H&F/footer.html"/>
  <script src="js/jquery.min.js"></script>
  <script src="js/index.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  
</body>
</html>
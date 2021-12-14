<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon/favicon.ico">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/custom.css">
  <link rel="stylesheet" href="../css/header_footer.css">

  <title>좌가장</title>
</head>
<body>
  <!-- 헤더 -->
  <jsp:include page="../H&F/header.jsp"/>
  <!-- 본문 -->
  <div class="container d-flex mt-5 mb-5 mypagesec">
      <div class="row">
      <div class="col-2 sidebar ms-5 d-flex justify-content-center">
      	<ul class="nav d-flex flex-column align-content-center justify-content-center">
      		<li class="nav-item">
      			<a class="nav-link mpa nf" href="mypage.do">회원 정보 수정</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link nf" href="#">주문내역</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link nf" href="#">찜목록</a>
      		</li>
      	</ul>
      </div>
      <div class="col-7" style="margin-left:40px;">
        <h5 class="mph" style="margin-top: 38px;">회원 정보 수정</h5>
      <form id="joinForm" method="post" action="/mypage.do" style="margin-left:268px;">
        <div class="container row d-flex mt-5" style="margin-top: 13px;">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">아이디</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="id" type="text" value="${sessionScope.id}" autocomplete="off" readonly >
          </div>
        </div>
        <div class="container row d-flex justify-content-center align-items-center">
        <p id="idcheck" style="margin-top:10px;"></p>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">비밀번호</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="pwd" id="pwd" type="password" placeholder="비밀번호를 입력해주세요.">
          </div>
        </div>
        <p id="pwdcheck" style="margin-top:10px;"></p>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">비밀번호 확인</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="pwd2" id="pwd2" type="password" placeholder="비밀번호를 확인해주세요.">
          </div>
        </div>
        <p id="pwd2check" style="margin-top:10px;"></p>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">이메일</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="email" id="email" type="email" placeholder="이메일을 입력하세요."autocomplete="off">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">연락처</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" name="mobile" id="mobile" type="text" placeholder="연락처를 입력하세요."autocomplete="off">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
            <label class="join-label-font">주소</label>
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" id="sample4_postcode" type="text" placeholder="우편번호" autocomplete="off">
          </div>
          <div class="col-md-2 d-flex align-items-center">
            <input class="join-button-font btn jbs cfs" type="button" value="주소찾기" onclick="sample4_execDaumPostcode()">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" type="text" id="sample4_roadAddress" placeholder="도로명 주소" autocomplete="off">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" type="text" id="sample4_extraAddress" placeholder="참고 항목" autocomplete="off">
          </div>
        </div>
        <div class="container row d-flex">
          <div class="col-md-3 d-flex align-items-center">
          </div>
          <div class="col-md-7 d-flex align-items-center">
            <input class="join-label-font lib lis py-3 ps-3 cfs" type="text" id="sample4_jibunAddress" placeholder="상세주소" autocomplete="off">
          </div>
        </div>

        <div class="row d-flex justify-content-center">
          <input class="lib btn btn-update cfs" style="margin-top: 27px;" id="submit" type="submit" value="회원 정보 수정" >
        </div>
      </form>
      </div>
  	</div>
  </div>

  <!-- 푸터 -->
<jsp:include page="../H&F/footer.jsp"/>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
            
        }
    }).open();
}
</script>
  <script src="../js/jquery.js"></script>
  <script src="../js/index.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script src="../js/join.js"></script>
  
</body>
</html>
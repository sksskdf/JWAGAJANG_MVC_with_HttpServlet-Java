<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<header>   
       <div class="headerwrap">
        <div class="logo">
          <a href="/main.do"><img class="logo_img" src="../img/logo.svg" alt="로고"></a>
        </div>
        <form class="search">
          <input type="text" id="schText" name="schText"><input type="image" src="../img/search.svg" id="schButton" name="schButton">
        </form>
        <nav>
          <ul class="gnbmy">
            <c:if test="${sessionScope.id == null}">
            <li><a href="/login.do">로그인</a></li>
            </c:if>
            <c:if test="${sessionScope.id != null}">
            <li><a href="/logout.do">로그아웃</a></li>
            </c:if>
            <c:if test="${sessionScope.id != null}">
            <li><a href="#">장바구니</a></li>
            </c:if>
            <c:if test="${sessionScope.id == null}">
            <li><a href="/join.do">회원가입</a></li>
            </c:if>
            <c:if test="${sessionScope.id != null}">
            <li><a href="/mypage.do">마이페이지</a></li>
            </c:if>
            <c:if test="${sessionScope.id == null}">
            </c:if>
          </ul>
        </nav>
        <nav>
          <ul class=gnb>
            <li class="gnb_li"><a href="/list.do?category_main=All" class="ctgry"><img src="../img/allctgrybtn.svg" style="height: 12px;"> 전체상품</a>
              <table class="lnb">
                <tr class="lnb_tr"><th class="lnb_th"><a href="/list.do?category_main=100">채소·과일</a></th></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=110">고구마·감자·당근</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=120">시금치·쌈채소·나물</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=130">브로콜리·파프리카·양배추</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=140">양파·마늘·대파·배추</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=150">오이·호박·고추</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=160">콩나물·버섯</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=100&category_sub=170">과일</a></td></tr>
                <tr class="lnb_tr"><th class="lnb_th"><a href="/list.do?category_main=200">쌀·견과류</th></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=200&category_sub=210">쌀·잡곡</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=200&category_sub=220">견과류</a></td></tr>
                <tr class="lnb_tr"><th class="lnb_th"><a href="/list.do?category_main=300">수산·해산</th></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=300&category_sub=310">생선류</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=300&category_sub=320">해산물·조개류</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=300&category_sub=330">김·미역·해조류</a></td></tr>
                <tr class="lnb_tr"><th class="lnb_th"><a href="/list.do?category_main=400">정육·계란</th></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=400&category_sub=410">소고기·돼지고기</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=400&category_sub=420">닭·오리고기</a></td></tr>
                  <tr><td class="lnb_td"><a href="/list.do?category_main=400&category_sub=430">계란</a></td></tr>
              </table>
            
            </li>
            <li class="cate gnb_li"><a class="ctgry" href="#">카테고리</a></li>
            <li class="cate gnb_li"><a class="ctgry" href="#">카테고리</a></li>
            <li class="cate gnb_li"><a class="ctgry" href="#">카테고리</a></li>
            <li class="cate gnb_li" ><a class="ctgry" href="#">카테고리</a></li>
            <li class="gnb_li"><a class="ctgry" href="notice.jsp">공지사항</a></li>
            <li class="gnb_li"><a class="ctgry" href="#">문의게시판</a></li>
          </ul>
        </nav>
       </div>
    </header>
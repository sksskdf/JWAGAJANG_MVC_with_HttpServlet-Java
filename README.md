# JWAGAJANG

12.07 -----
-notice.html -> notice.jsp 로 변경.

-파일정리를 위해 Header와 Footer를 제외한 HTML 파일들은 WebContent/WEB-INF/view 경로로 일괄 이동시켜놓음.

-Header와 Footer는 WebContent/H&F 에 옮겨둠.
JSP파일마다 jsp:inclue 경로도 재설정해놓음.


-notice.jsp body가 다른페이지들에 비해 조금씩 오른쪽으로 밀려서 
임시로 body태그에 인라인css로 position:relative; left:-8px; 설정해놓음.

후에 서버작업을 위해 필요한 jar파일들은 WEB-INF/lib 에 넣어놓음.

!! META-INF/Context.xml에 DB접속용 Resource작성해놓았으니 서버작업하기전에 꼭 확인. !!

##123123



$(function() {
	var idFlag = false;
	var pw1Flag = false;
	var pw2Flag = false;
	var midFlag = false;
	var hostFlag = false;
	var passId = false;
	

	$("#id").on("keyup", function(e) {
		//정규표현식 알파벳 대소문자 상관없이 숫자는 0~9까지 조합한 6자 이상 20자 이하의 문자열
		var regEx = /^[a-zA-Z0-9]{6,20}$/;
		var idVal = $("#id").val();
		if(idVal.length > 0 && !regEx.test(idVal)) {
			$("#id").css("color", "red");
			$("#idcheck").text("6자 이상 20자 이하의 아이디를 입력해주세요!");
			idFlag = false;
		} else {
			$("#id").css("color", "blue");
			$("#idcheck").text("");
			idFlag = true;
		}
		if(idVal.length == 0){
			$("#idcheck").text("");
		}
	});
	
	$("#pwd").on("keyup", function(e) {
		var regEx = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
		var pwVal = $("#pwd").val();
		if(pwVal.length > 0 && !regEx.test(pwVal)) {
			$("#pwd").css("color", "red");
			$("#pwdcheck").text("올바른 비밀번호를 입력해주세요!")
			pw1Flag = false;
		} else {
			$("#pwd").css("color", "blue");
			$("#pwdcheck").text("");
			pw1Flag = true;
		}
		if(pwVal.length == 0){
			$("#pwdcheck").text("");
		}
	});
	
	$("#pwd2").on("keyup", function(e) {
		var regEx = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
		var pwVaal = $("#pwd").val();
		var pwVal = $("#pwd2").val();
		if(pwVal != pwVaal && !regEx.test(pwVal) && pwVal.length != pwVaal.length) {
			$("#pwd2").css("color", "red");
			$("#pwd2check").text("비밀번호를 확인해주세요!")
			pw2Flag = false;
		} else if(pwVaal == pwVal){
			$("#pwd2").css("color", "blue");
			$("#pwd2check").text("");
			pw2Flag = true;
		}
		if(pwVal.length == 0){
			$("#pwd2check").text("");
		}
		
		
	});
	

	
	$("#duplicateCheck").on("click", function(e) {
		var id = $("#id").val();
		
		if(id.length == 0) {
			alert("아이디를 입력해 주세요!");
			return;
		}
		if(idFlag == false) {
			alert("아이디를 올바르게 입력해 주세요!");
			return;
		}
		var query = { id: id };
		$.ajax({
			type: "POST",
			url: "/idCheck.do",
			data: query,
			success: function(data) {
				if(data == "using") {	// id 존재
					alert("이미 존재하는 아이디 입니다.");
					passId = false;
					$("#id").css("color", "red");
					$("#idcheck").text("이미 존재하는 아이디 입니다!");
				}
				else {
					alert("사용 가능한 아이디 입니다.");
					passId = true;
				}
			}
		});
	});
	
	$("#styleShop + span").on("click", function(e) {
		$("#tt1").css("display", "block");
		setTimeout(function() {
			$("#tt1").css("display", "none");
		}, 1000);
	});
	
	$("#openShop + span").on("click", function(e) {
		$("#tt2").css("display", "block");
		setTimeout(function() {
			$("#tt2").css("display", "none");
		}, 1000);
	});
	
	$("#emailCom").on("change", function(e) {
		var value = $("#emailCom option:selected").val();
		$("#host").val(value);
		/* $("#host").trigger("keyup"); */
	});
	
	var joinForm = $("#joinForm");
	$("#styleShop").on("click", function(e) {
		if(checkInputValidity() == false) {
			return false;
		}
		e.preventDefault();
		joinForm.append('<input type="hidden" name="grade" value="1">');
		joinForm.submit();
	});
	
	$("#openShop").on("click", function(e) {
		if(checkInputValidity() == false) {
			return false;
		}
		e.preventDefault();
		joinForm.append('<input type="hidden" name="grade" value="2">');
		joinForm.submit();
	});
	
	$("#cancelBtn").on("click", function(e) {
		e.preventDefault();
		if(confirm("가입을 취소하시겠습니까?")) {
			location.href = "/index.do";
		}
	});
	
	function checkInputValidity() {
		if($("#name").val().length == 0) {
			alert("이름을 입력해 주세요!");
			$("#name").focus();
			return false;
		}
		if(nameFlag == false) {
			alert("이름을 작성 정책에 맞게 입력해 주세요!");
			$("#name").focus();
			return false;
		}
		if($("#id").val().length == 0) {
			alert("아이디를 입력해 주세요!");
			$("#id").focus();
			return false;
		}
		if(idFlag == false) {
			alert("아이디를 작성 정책에 맞게 입력해 주세요!");
			$("#id").focus();
			return false;
		}
		if(passId == false) {
			alert("아이디 중복검사를 진행해 주세요!");
			return false;
		}
		if($("#pwd1").val().length == 0) {
			alert("비밀번호를 입력해 주세요!");
			$("#pwd1").focus();
			return false;
		}
		if(pw1Flag == false) {
			alert("비밀번호 생성규칙에 맞게 다시 입력해 주세요!");
			$("#pwd1").focus();
			return false;
		}
		if($("#pwd2").val().length == 0) {
			alert("비밀번호를 입력해 주세요!");
			$("#pwd2").focus();
			return false;
		}
		if(pw2Flag == false) {
			alert("비밀번호 생성규칙에 맞게 다시 입력해 주세요!");
			$("#pwd2").focus();
			return false;
		}
		if($("#pwd1").val() != $("#pwd2").val()) {
			alert("비밀번호가 일치하지 않습니다. 비밀번호를 다시 입력해 주세요!");
			$("#pwd2").focus();
			return false;
		}
		if($("#mid").val().length == 0) {
			alert("이메일을 입력해 주세요!");
			$("#mid").focus();
			return false;
		}

		if($("#host").val().length == 0) {
			alert("이메일을 입력해 주세요!");
			$("#host").focus();
			return false;
		}

		var emailVal = $("#mid").val() + "@" + $("#host").val();
		var emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		if(!emailReg.test(emailVal)) {
			alert("이메일 주소를 형식에 맞게 입력해 주세요!");
			$("#mid").focus();
			return false;
		}
		if($("#rcv").prop("checked") == false) {
			alert("이메일 수신여부를 선택해 주세요!");
			$("#rcv").focus();
			return false;
		}
		return true;
	}
});


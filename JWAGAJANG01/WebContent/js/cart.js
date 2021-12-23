//구매수량 number input
var inc = document.getElementsByClassName("stepper");
	for (i = 0; i < inc.length; i++) {
	  var incI = inc[i].querySelector("input"),
	    id = incI.getAttribute("id"),
	    min = incI.getAttribute("min"),
	    max = incI.getAttribute("max"),
	    step = incI.getAttribute("step");
	  document
	    .getElementById(id)
	    .previousElementSibling.setAttribute(
	      "onclick",
	      "stepperInput('" + id + "', -" + step + ", " + min + ")"
	    ); 
	  document
	    .getElementById(id)
	    .nextElementSibling.setAttribute(
	      "onclick",
	      "stepperInput('" + id + "', " + step + ", " + max + ")"
	    ); 
	}
	
function stepperInput(id, s, m) {
	  var el = document.getElementById(id);
	  if (s > 0) {
	    if (parseInt(el.value) < m) {
	      el.value = parseInt(el.value) + s;
	    }
	  } else {
	    if (parseInt(el.value) > m) {
	      el.value = parseInt(el.value) + s;
	    }
	  }
	}

//전체 체크 및 일부 체크 해제 시 전체체크 해제되는 메소드
$(function() {
	$("#allchk").click(function() {
		if($("#allchk").is(":checked")) {
			$("input[name=mdchk]").prop("checked", true);
			totalSum();
		}
		
		else {
			$("input[name=mdchk]").prop("checked", false);
			totalSum();
		}
	});
	
	$("input[name=mdchk]").click(function() {
		var total = $("input[name=mdchk]").length;
		var checked = $("input[name=mdchk]:checked").length;
		
		if(total != checked){
			$("#allchk").prop("checked", false);
			totalSum();
		}
		else {
			$("#allchk").prop("checked", true); 
			totalSum();
		}
	});
	
	//주문금액이 3만원이 넘을 시 배송비 0원으로 만드는 메소드
	//if($("#"))
	
});
//금액 총 합계.
function totalSum() {
    var str = "";
    var sum = 0;
    var count = $(".mdchk").length;
    for (var i = 0; i < count; i++) {
        if ($(".mdchk")[i].checked == true) {
            sum += parseInt($(".mdchk")[i].value);
        }
    }
    $("#totalOrderPrice").html(sum);
}

//선택한 항목 삭제
$("#selectDelete").click(function () {
	 var checkArr = new Array();

     $("input[class='mdchk']:checked").each(function () {
         checkArr.push($(this).attr("data-cartnum"));
     });

    if(checkArr.length==0) alert("선택된 상품이 없습니다.");
    else {
	    var confirm_val = confirm("선택한 상품을 삭제하시겠습니까?");
	    if (confirm_val) {
	        $.ajax({
	            url: "cartSelectDelete.do",
	            type: "post",
	            data: { chbox: checkArr },
	            success: function () {
	                location.href = "cart.do";
	            }
	        });
	    }
    }
});

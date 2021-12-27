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
	            data: { checkArr: checkArr },
	            success: function () {
	                location.replace("cart.do");
	            }
	        });
	    }
    }
});
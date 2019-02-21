
	//判断按钮是否可用
	function ifButtonAbled() {
		if ($(".nowpage").text() == 1) {
			$(".uppage").attr("disabled", true);
			$(".firstpage").attr("disabled", true);
		}
		if ($(".nowpage").text() == $(".allpage").text()) {
			$(".nextpage").attr("disabled", true); 
			$(".lastpage").attr("disabled", true);
		}
		if ($(".nowpage").text() != 1) {
			$(".uppage").attr("disabled", false);
			$(".firstpage").attr("disabled", false);
		}
		if ($(".nowpage").text() != $(".allpage").text()) {
			$(".nextpage").attr("disabled", false); 
			$(".lastpage").attr("disabled", false);
		}
	};

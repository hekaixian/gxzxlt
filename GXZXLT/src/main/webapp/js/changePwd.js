$(function(){
	$(".changepwd").addClass("changecolor"); 
	$(".submitPwd").click(function() {
		var oldPwd = $(".oldPwd").val();
		var newPwd = $(".newPwd").val();
		var comfirm = $(".comfirmPwd").val();
		if (oldPwd == null || oldPwd.length == 0) {
			alert("原密码不能为空");
			return;
		}
        if (newPwd == null || newPwd.length == 0) {
        	alert("新密码不能为空");
			return;
		}
        if (comfirm == null || comfirm.length == 0) {
        	alert("确认密码不能为空");
			return;
        }
		if (newPwd != comfirm) {
			alert("新密码输入不一致，请重新输入！");
			return;
		}
		if (oldPwd == newPwd) {
			alert("新密码与原密码一致");
			return;
		}
		$.ajax({
			url : "toChange.do",
			type : 'POST',
			data : {'oldPwd' : oldPwd, "newPwd" : newPwd},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == 1) {
					alert("修改密码成功");
				}
				if (result.status == 0) {
					alert("原密码输入错误");
				}
				if (result.status == 2) {
					alert("修改密码失败");
				}
			}
		});
		
	});
})
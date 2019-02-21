$(function () {
            $('#submit').on('click', function () {
            	var username = $('#username').val();
                var password = $('#password').val();
                if (username.length == 0) {
                	alert("用户名不能为空");
                	$('#username').focus();
                	return false;
                }
                if (password.length == 0) {
                	alert("密码不能为空");
                	$('#password').focus();
                	return false;
                }
            	$.ajax({
            		url:"toLogin",
            		type:"post",
            		dateType:"json",
            		data:{"loginname":username,"password":password},
            		success:function(result){
            			var status = result.status;
            			if (status == 0) {
            				$('.tip').show();
            				$('#username').val("");
            				$('#password').val("");
            				$('#username').focus();
            			} else if (status == 1) {
            				window.location.href = "toIndex";
            			} else {
            				window.location.href = "Login";
            			}
            		},
            		error:function(){
            			alert("登录失败，请重新登录...");
            			window.location.href = "";
            		}
            	});
                
                
            })
})
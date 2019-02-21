$(function() {
	getAllUser(1);
	$(".usermanager").addClass("changecolor"); 
	$(".addPage").hide();
	$(".upDatePage").hide();
	$(".addPage button").addClass("thebutton");
	$(".upDatePage button").addClass("thebutton");
	
	$(".addUser").click(function () {
		$(".addPage").show();
		$(".all").addClass("tohide");
	});
	
	$(".usersubmit").click(function() {
		var loginname = $(".loginname").val();
		var username = $(".username").val();
		var password = $(".password").val();
		if (loginname.trim().length == 0) {
			alert("登录名不能为空！");
			return;
		}
		if (username.trim().length == 0) {
			alert("用户名不能为空！");
			return;
		}
		if (password.trim().length == 0) {
			alert("密码不能为空！");
			return;
		}
		$.ajax({
			url : "toAddUser.do",
			type : 'POST',
			data : {'loginname' : loginname, "username" : username, "password" : password},
			dataType : 'JSON',
			success : function(result) {
				if (result == 1) {
					alert("新增成功");
					hide();
					getAllUser(1);
				}
				if (result == 3) {
					alert("该登录名已被使用");
				}
				if (result == 0) {
					alert("新增失败");
				}
			}
		});
	});
	
	$(".usersubmit_1").click(function() {
		var userid = $(".userid_1").val();
		var loginname = $(".loginname_1").val();
		var username = $(".username_1").val();
		var password = $(".password_1").val();
		var type = $(".type_1").val();
		if (loginname.trim().length == 0) {
			alert("登录名不能为空！");
			return;
		}
		if (username.trim().length == 0) {
			alert("用户名不能为空！");
			return;
		}
		if (password.trim().length == 0) {
			alert("密码不能为空！");
			return;
		}
		if (type > 1) {
			alert("类型必须为0(管理员)或1(普通用户)！");
			return;
		}
		$.ajax({
			url : "toUpDateUser.do",
			type : 'POST',
			data : {"userid" : userid,'loginname' : loginname, "username" : username, "password" : password, "type" : type},
			dataType : 'JSON',
			success : function(result) {
				if (result == 1) {
					alert("修改成功");
					$(".upDatePage").hide();
					$(".all").removeClass("tohide");
					getAllUser(1);
				}
				if (result == 0) {
					alert("修改失败");
				}
			}
		});
		
	});
	
	$(".usercancel").click(function() {
		hide();
	});
	
	$(".usercancel_1").click(function() {
		$(".upDatePage").hide();
		$(".all").removeClass("tohide");
	});
	
	function hide() {
		$(".loginname").val("");
		$(".username").val("");
		$(".password").val("");
		$(".addPage").hide();
		$(".all").removeClass("tohide");
	}
	
	//首页
	$(".firstpage").click(function () {
		getAllUser(1);
		$(".nowpage").html("1");//给span标签赋值
		ifButtonAbled();
	});
	//末页
	$(".lastpage").click(function () {
		var lastPage = $(".allpage").text();
		getAllUser(lastPage);
		$(".nowpage").html(lastPage);//给span标签赋值
		ifButtonAbled();
	});
	//上一页
	$(".uppage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) - 1;
		getAllUser(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	//下一页
	$(".nextpage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) + 1;
		getAllUser(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	function getAllUser(pageno) {
		$.ajax({
			url : "toGetUser.do",
			type : 'POST',
			data : {'pageno' : pageno},
			dataType : 'JSON',
			success : function(result) {
				showUsers(result);
			}
		});
	}
	
	function showUsers(result) {
		$(".postusers").empty();
		for (var i = 0; i < result.length; i++) {
			var type = "普通用户";
			if (result[i].type == 0) {
				type = "管理员";
			}
			$(".postusers").append("<div class='allusers'><span class='span_1'>"
					+ result[i].id +"</span><span class='span_2'>" 
					+ result[i].loginname + "</span><span class='span_3'>" 
					+ result[i].username + "</span><span class='span_4'>" 
					+ result[i].password + "</span><span class='span_5'>" 
					+ type + "</span><a href='javascript:void(0);' onclick='toDelete(this);' id='"
					+ result[i].id +"'>删除</a><a href='javascript:void(0);' onclick='toUpDate(this);' id='"
					+ result[i].id +"'>修改</a></div>");
		}
		$(".allpage").html(result[0].userpages);
		ifButtonAbled();
	}
	
	toUpDate = function(obj) {
		$(".upDatePage").show();
		$(".all").addClass("tohide");
		$(".userid_1").val(obj.id);
		$.ajax({
			url : "toGetUserById.do",
			type : 'POST',
			data : {'userid' : obj.id},
			dataType : 'JSON',
			success : function(result) {
				$(".loginname_1").val(result.loginname);
				$(".username_1").val(result.username);
				$(".password_1").val(result.password);
				$(".type_1").val(result.type);
			}
		});
	}
	
	toDelete = function(obj) {
		var messages = confirm("确定删除吗？");
		  if (messages == true) {
			  $.ajax({
					url : "toDeleteUser.do",
					type : 'POST',
					data : {'userid' : obj.id},
					dataType : 'JSON',
					success : function(result) {
						if (result == 1) {
							alert("删除成功");
							location.reload();
						} else {
							alert("删除失败");
						}
					}
				});
		  } else {
			  
		  }
	}
	
})
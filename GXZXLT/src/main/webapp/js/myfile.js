$(function () {
	getBbs(1);
	$(".myfile").addClass("changecolor"); 
	$(".mybbss").addClass("changecolor"); 
	var type = 1;
	//我的帖子
	$(".mybbss").click(function() {
		type = 1;
		$(".nowpage").html("1");
		getBbs(1);
		$(".mybbss").addClass("changecolor"); 
		$(".myfiles").removeClass("changecolor");
		$(".mybbss").attr("disabled", true);
		$(".myfiles").attr("disabled", false);
	});
	//我的文件
    $(".myfiles").click(function() {
		type = 2;
		$(".nowpage").html("1");
		getFile(1);
		$(".myfiles").addClass("changecolor"); 
		$(".mybbss").removeClass("changecolor");
		$(".myfiles").attr("disabled", true);
		$(".mybbss").attr("disabled", false);
	});
	
    //首页
	$(".firstpage").click(function () {
		if (type == 1) {
			getBbs(1);
		}
		if (type == 2) {
			getFile(1);
		}
		
		$(".nowpage").html("1");//给span标签赋值
		ifButtonAbled();
	});
	//末页
	$(".lastpage").click(function () {
		var lastPage = $(".allpage").text();
		if (type == 1) {
			getBbs(lastPage);
		}
		if (type == 2) {
			getFile(lastPage);
		}
		$(".nowpage").html(lastPage);//给span标签赋值
		ifButtonAbled();
	});
	//上一页
	$(".uppage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) - 1;
		if (type == 1) {
			getBbs(pagenum);
		}
		if (type == 2) {
			getFile(pagenum);
		}
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	//下一页
	$(".nextpage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) + 1;
		if (type == 1) {
			getBbs(pagenum);
		}
		if (type == 2) {
			getFile(pagenum);
		}
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
    
	function getBbs(pagenum) {
		$.ajax({
			url : "getBbsByUserid.do",
			type : 'POST',
			data : {'pageno' : pagenum},
			dataType : 'JSON',
			success : function(result) {
				showBbs(result);
			}
		});
	};
	function getFile(pagenum) {
		$.ajax({
			url : "getFilesByUserid.do",
			type : 'POST',
			data : {'pageno' : pagenum},
			dataType : 'JSON',
			success : function(result) {
				showFile(result);
			}
		});
	};
	
	function showBbs(result) {
		$(".filebody").empty();
		for (var i = 0; i < result.length; i++) {
			$(".filebody").append("<div class='bbs'><h3><a href='toBbs?bbsid="+ result[i].id +"'>"
					+ result[i].title +"</a></h3><span><a href='javascript:void(0);' onclick='toDelete(this);' id='"
					+ result[i].id +"'>删除</a></span><div><p class='contentless'>" 
					+ result[i].content + "</p></div><p>" + result[i].username 
					+ " | "+ result[i].createtime +"<span>评论：" 
					+ result[i].replycount +"</span></p></div>");
		}
		$(".allpage").html(result[0].bbspages);
		ifButtonAbled();
	};
	
    toDelete = function (obj){
		  var messages = confirm("确定删除吗？");
		  if (messages == true) {
			  $.ajax({
					url : "toDeleteBbs.do",
					type : 'POST',
					data : {'bbsid' : obj.id},
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
	};
	
	function showFile(result) {
		$(".filebody").empty();
		for (var i =0; i < result.length; i++) {
			$(".filebody").append("<div class='bbs'><h3><a href='toFile?fileId="+ result[i].id +"'>"
					+ result[i].title +"</a></h3><p class='contentless'>" 
					+ result[i].filedescribe + "</p><p>" + result[i].username 
					+ " | "+ result[i].uploadtime +"<span>下载量：" 
					+ result[i].loadcount +"</span></p></div>");
		}
		$(".allpage").html(result[0].filepages);
		ifButtonAbled();
	}
	
});
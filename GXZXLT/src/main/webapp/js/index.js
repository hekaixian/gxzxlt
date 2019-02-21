$(function () {
	getBbs(1);
	$(".first").addClass("changecolor"); 
	//首页
	$(".firstpage").click(function () {
		getBbs(1);
		$(".nowpage").html("1");//给span标签赋值
		ifButtonAbled();
	});
	//末页
	$(".lastpage").click(function () {
		var lastPage = $(".allpage").text();
		getBbs(lastPage);
		$(".nowpage").html(lastPage);//给span标签赋值
		ifButtonAbled();
	});
	//上一页
	$(".uppage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) - 1;
		getBbs(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	//下一页
	$(".nextpage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) + 1;
		getBbs(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	function getBbs(pagenum) {
		$.ajax({
			url : "getBbss.do",
			type : 'POST',
			data : {'pageno' : pagenum},
			dataType : 'JSON',
			success : function(result) {
				showBbs(result);
			}
		});
	};
	function showBbs(result) {
		$(".postbbs").empty();
		for (var i = 0; i < result.length; i++) {
			$(".postbbs").append("<div class='bbs'><h3><a href='toBbs?bbsid="+ result[i].id +"'>"+ result[i].title +"</a></h3><p class='contentless'>" + result[i].content + "</p><p>" + result[i].username + " | "+ result[i].createtime +"<span>评论：" + result[i].replycount +"</span></p></div>");
		}
		$(".allpage").html(result[0].bbspages);
		ifButtonAbled();
	};
	
})
$(function() {
	getFile(1);
	$(".filecenter").addClass("changecolor"); 
	//首页
	$(".firstpage").click(function () {
		getFile(1);
		$(".nowpage").html("1");//给span标签赋值
		ifButtonAbled();
	});
	//末页
	$(".lastpage").click(function () {
		var lastPage = $(".allpage").text();
		getFile(lastPage);
		$(".nowpage").html(lastPage);//给span标签赋值
		ifButtonAbled();
	});
	//上一页
	$(".uppage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) - 1;
		getFile(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	//下一页
	$(".nextpage").click(function () {
		var nowpage = $(".nowpage").text();
		var pagenum = parseInt(nowpage) + 1;
		getFile(pagenum);
		$(".nowpage").html(pagenum);
		ifButtonAbled();
	});
	function getFile(pagenum) {
		$.ajax({
			url : "getFiles.do",
			type : 'POST',
			data : {'pageno' : pagenum},
			dataType : 'JSON',
			success : function(result) {
				showFile(result);
			}
		});
	};
	function showFile(result){
		$(".postfile").empty();
		for (var i = 0; i < result.length; i++) {
			$(".postfile").append("<div class='bbs'><h3><a href='toFile?fileId="+ result[i].id +"'>"+ result[i].title +"</a></h3><p class='contentless'>" + result[i].filedescribe + "</p><p>" + result[i].username + " | "+ result[i].uploadtime +"<span>下载量：" + result[i].loadcount +"</span></p></div>");
		}
		$(".allpage").html(result[0].filepages);
		ifButtonAbled();
	};
});
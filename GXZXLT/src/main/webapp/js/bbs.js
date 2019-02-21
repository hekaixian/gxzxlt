$(function() {
	var count = 1;
	getReply(1);
	
	toGetMoreReply = function() {
		count = parseInt(count) + 1;
		getReply(count);
	}
	
	$(".toPostComment").click(function() {
		var content = $(".postComment").val();
		var bbsid = $(".titlehead").attr("id");
		if (content.trim().length == 0) {
			alert("发表内容不能为空");
			return;
		}
		$.ajax({
			url : "toAddReply.do",
			type : 'POST',
			data : {'bbsid' : bbsid, "content" : content},
			dataType : 'JSON',
			success : function(result) {
				if (result == 1) {
					alert("发表成功");
					getReply(1);
					count = 1;
					$(".getmore").show();
					$(".postComment").val("");
				} else {
					alert("发表失败");
				}
			}
		});
	});
	
	function getReply(pagenum) {
		var bbsid = $(".titlehead").attr("id");
		$.ajax({
			url : "getReply.do",
			type : 'POST',
			data : {'pageno' : pagenum, "bbsid" : bbsid},
			dataType : 'JSON',
			success : function(result) {
				if (pagenum == 1) {
					$(".comments").empty();
				}
				showBbs(result);
			},
			error : function() {
				$(".getmore").hide();
				$(".comments").append("<p class='noreply'>暂无评论</p>");
			}
		});
	}
	
	function showBbs(result) {
		for (var i = 0; i < result.length; i++) {
			$(".comments").append("<div class='reply'><div class='replycontent'>&#12288&#12288"+  result[i].content +"</div><div class='replyinfo'><span class='replyname'>" + result[i].username + "</span><span class='replytime'>"+ result[i].replytime +"</span></div></div>");
		}
	}
});
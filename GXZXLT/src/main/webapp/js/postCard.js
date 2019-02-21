$(function() {
	$(".posting").addClass("changecolor"); 
	$(".toPost").click(function() {
		var title = $(".title").val();
		var content = $(".postText").val();
		if (title == null || title.trim().length == 0) {
			alert("标题不能为空！");
			return;
		}
		if (content == null || content.trim().length == 0) {
			alert("内容不能为空！");
			return;
		}
		$.ajax({
			url : "toPost.do",
			type : 'POST',
			data : {'title' : title, "content" : content},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == 1) {
					alert("发表成功");
					$(".title").val("");
					$(".postText").val("");
				}
				if (result.status == 0) {
					alert("发表失败");
				}
				
			}
		});
	});
	
	
	
});
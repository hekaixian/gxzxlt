$(function(){	
	$(".uploadfile").addClass("changecolor"); 
	$("#submitFrame").load(function(){		
	     var tempText = $(this);		
	     var result = tempText[0].contentDocument.body.textContent;  
	    //从后台传过来的数据，拿到就可以做相应的业务代码了		
        if (result == 0) {
        	alert("上传成功！");
        	location.reload();
        }
        if (result == 1) {
        	alert("上传发生错误");
        }
        if (result == 2) {
        	alert("该类型的文件不允许上传");
        }
        if (result == 3) {
        	alert("上传文件大小超过限制，文件大小不能超过4M");
        }
        if (result == 5) {
        	alert("描述不能为空");
        }
        if (result == 6) {
        	alert("上传文件不能为空");
        }

	});
	$(".upload_image").click(function() {
		$("#file").click();
	});
	$("#file").change(function() {
//		$(".images").hide();
		var fileDir = $("#file").val();
		$(".filename").val(fileDir.substr(fileDir.lastIndexOf("\\")+1));
	});
})


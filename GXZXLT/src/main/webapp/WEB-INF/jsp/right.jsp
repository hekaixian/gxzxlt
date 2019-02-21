<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/right.css">
</head>
<body>
   <div class="lists">
          <div class="fileList">
            <p class="newupload">最新上传</p>
            <c:forEach var="file" items="${fileNewList}">
              <p><a href="javascript:void(0);" onclick="toFile(this);" id="${file.id}">${file.title}</a><span>${file.uploadtime.toLocaleString().substring(0,15)}</span></p>
            </c:forEach>
          </div>
          <div class="postList">
            <p class="downLists">下载排行榜</p>
            <c:forEach var="file" items="${fileDownList}">
              <p><a href="javascript:void(0);" onclick="toFile(this);" id="${file.id}">${file.title}</a><span>${file.loadcount}</span></p>
            </c:forEach>
          </div>
   </div>
   <script>
      $(function(){
    	  toFile = function (obj){
    		  window.location.href = "toFile?fileId=" + obj.id;
    	  }
      })
   </script>
</body>
</html>
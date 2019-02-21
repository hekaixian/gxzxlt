<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/upLoadFile.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.min.js"></script>
<script src="${pageContext.request.contextPath}/js/upLoadFile.js"></script>

</head>
<body>
   <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <form action="upload.do" enctype="multipart/form-data" method="post" id="uploadFile " target="submitFrame">
             <div class="upload_1"><p>上传资源</p></div>
             <div class="upload_image"><img class="images" src="${pageContext.request.contextPath}/images/upload.png"></div>
             <p class="upload_2">您可以上传小于4M的资源</p>
             <input type="file" name="file" id="file"><br/>
             <p>资源名称：<input type="text" class="filename" readonly="readonly"></p>
		     <p class="upload_3"><span>资源描述：</span><textarea name="filedescribe" id="filedescribe" placeholder="请输入资源描述信息..."></textarea><br/></p>
		     <input type="submit" value="提交" class="filesubmit">
		  </form>
		  <iframe  id="submitFrame" style="display: none;width:0; height:0" name="submitFrame"  src="about:blank"></iframe>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
    
</body>
</html>
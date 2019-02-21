<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/file.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
</head>
<body>
     <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <h3>${filemap.title}</h3>
          <p>${filemap.filedescribe}</p>
          <p>${filemap.username} | ${filemap.uploadtime}<span>下载量：${filemap.loadcount}</span></p>
          <a href="toDownFile?fileId=${filemap.id}" class="downfile">立即下载</a>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
</body>
</html>
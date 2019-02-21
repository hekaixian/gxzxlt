<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/filecenter.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pub.js"></script>
<script src="${pageContext.request.contextPath}/js/filecenter.js"></script>
</head>
<body>
  <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <div class="postfile"></div>
	      <%@include file="page.jsp" %>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
</body>
</html>
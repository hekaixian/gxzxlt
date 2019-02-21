<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/changePwd.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/changePwd.js"></script>
</head>
<body>
   <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <div class="password_1">
              <p>修改密码</p>
          </div>
          <div class="password_2">
              <p><span>输入旧密码：</span><input type="text" class="oldPwd" onkeyup="this.value=this.value.replace(/\s+/g,'')" maxlength="20"></p>
              <p><span>输入新密码：</span><input type="password" class="newPwd" onkeyup="this.value=this.value.replace(/\s+/g,'')" maxlength="20"></p>
              <p><span>确认新密码：</span><input type="password" class="comfirmPwd" onkeyup="this.value=this.value.replace(/\s+/g,'')" maxlength="20"></p>
          </div>
          <div class="password_3">
              <button class="submitPwd">确认</button>
          </div>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/userManage.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pub.js"></script>
<script src="${pageContext.request.contextPath}/js/userManage.js"></script>
</head>
<body>
  <div class="all">
   <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <div class="addmenu">
             <button class="addUser">新增用户</button>
          </div>
          <div class="usermenu"><span>ID</span><span>登录名</span><span>用户名</span><span>用户密码</span><span>用户类型</span></div>
          <div class="postusers"></div>
	      <%@include file="page.jsp" %>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
  </div>
  <div class="addPage">
      <p><span>登录名：</span><input type="text" class="loginname"></p>
      <p><span>用户名：</span><input type="text" class="username"></p>
      <p><span>密　码：</span><input type="text" class="password"></p>
      <button class="usersubmit">确定</button>
      <button class="usercancel">取消</button>
   </div>
   <div class="upDatePage">
      <p><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID：</span><input type="text" class="userid_1" readonly="readonly"></p>
      <p><span>登录名：</span><input type="text" class="loginname_1"></p>
      <p><span>用户名：</span><input type="text" class="username_1"></p>
      <p><span>密　码：</span><input type="text" class="password_1"></p>
      <p><span>类　型：</span><input type="text" class="type_1" oninput="value=value.replace(/[^\d]/g,'')"></p>
      <button class="usersubmit_1">确定</button>
      <button class="usercancel_1">取消</button>
   </div>
</body>
</html>
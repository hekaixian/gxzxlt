<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>   
<% int type =  (Integer)session.getAttribute("type") ;%>
</head>
<body>
   <div class="logo">
      <div class="logoname"><h2>西安久其共享论坛</h2></div>
   </div>
    <div class="head">
      <div class="tabs">
        <div class="navigation">
            <a class="first" href="toIndex">论坛首页</a>
            <a class="filecenter" href="toFileCenter">文件中心</a>
            <a class="myfile" href="toMyfile">我的资料</a>
            <a class="posting" href="toPostCard">我要发帖</a>
            <a class="uploadfile" href="toUploadFile">上传文件</a>
            <a class="changepwd" href="toChangePwd">修改密码</a>
            <c:if test="${type == 0}">
               <a class="usermanager" href="toUserManage">用户管理</a>
            </c:if>
        </div>
        <div class="quit">
            <span class="user"><%=session.getAttribute("username") %></span>
            <a class="logout" href="toQuit">退出</a>
        </div>
      </div>
    </div>
</body>
</html>
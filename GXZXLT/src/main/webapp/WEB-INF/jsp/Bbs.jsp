<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>西安久其共享论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bbs.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" sizes="32x32">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bbs.js"></script>
</head>
<body>
    <%@include file="head.jsp"%>
    <div class="br"></div>
    <div class="main">
      <div class="content">
        <div class="post">
          <div class="text">
           <div class="titlehead" id="${bbsmap.id}">
             <div class="title"><h3>${bbsmap.title}</h3></div>
             <div class="nameAndTime">
               <div class="time">${bbsmap.createtime}</div>
               <div class="name">${bbsmap.username}</div>
             </div>
           </div>
           <div class="text_1">
              <div class="bbscontent">&#12288&#12288${bbsmap.content}</div>
              <div class="newComment">最新评论：</div>
              <div class="comments"></div>
              <div class="getmore"><a class="getmoreReply" href="javascript:void(0);" onclick="toGetMoreReply();">加载更多</a></div>
           </div>
         </div>
           <div class="comment">
             <div class="comment_1">我要评论：</div>
             <div class="comment_2"><textarea class="postComment"></textarea></div>
             <div class="comment_3"><button class="toPostComment">发表</button></div>
           </div>
        </div>
        <%@include file="right.jsp" %>
      </div>
    </div>
    <div class="br"></div>   
    <%@include file="foot.jsp" %>
</body>
</html>
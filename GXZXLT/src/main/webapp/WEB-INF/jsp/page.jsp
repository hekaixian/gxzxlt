<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
</head>
<body>
  <div class="page">
         <div class="page_1">
             <button type="button" class="firstpage">首页</button>
             <button type="button" class="uppage">上一页</button>
             <button type="button" class="nextpage">下一页</button>
             <button type="button" class="lastpage">末页</button>
             <span class="page_2">第<span class="nowpage">1</span>页，共<span class="allpage">1</span>页</span>
         </div>
  </div>
</body>
</html>
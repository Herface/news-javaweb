<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.jsp" %>
  <div id="opt_area">
    <ul class="classlist">
    	<c:if test="${topicList.size() gt 0}">
    	<c:forEach items="${topicList}" var="item">
    		<li> &#160;&#160;&#160;&#160; ${item.tname} &#160;&#160;&#160;&#160; <a href='${pageContext.request.contextPath}/topic?method=get&id=${item.tid}'>修改</a> &#160;&#160;&#160;&#160; <a href='${pageContext.request.contextPath }/topic?method=delete&id=${item.tid}'>删除</a> </li>
    	</c:forEach>
    	</c:if>
    	<c:if test="${topicList.size() eq 0}">
    	暂无主题
    	</c:if>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
<%
session.removeAttribute("topicList");
%>
</body>
</html>

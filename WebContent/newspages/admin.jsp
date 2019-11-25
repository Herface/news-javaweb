<%@ page language="java"  pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.jsp" %>
  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
    	<c:forEach  items="${newsList}" var="item">
    		<li>${item.ntitle}<span> 作者： ${item.nauthor } &#160;&#160;&#160;&#160; <a href='${pageContext.request.contextPath }/news?method=get&id=${item.nid}'>修改</a> &#160;&#160;&#160;&#160; <a href='${pageContext.request.contextPath}/news?method=delete&id=${item.nid}' onclick='return clickdel()'>删除</a> </span> </li>
    	</c:forEach>
    	<c:if test="${newsList.size() ==0 }">
    		<li>nothing here</li>
    	</c:if>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.jsp" %>
</div>
<%
session.removeAttribute("newsList");
%>
</body>
</html>

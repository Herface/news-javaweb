<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<jsp:include page="common/alert.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.label {
		width: 75px;
		text-align: left;
		display: inline-block;
	}
</style>
</head>
<body>
<div id="main">
  <div id="opt_area">
 	<form name="form" action="${pageContext.request.contextPath}/register" method="post">
		<p><span class="label">用户名:</span><input type="text" name="uname"/></p>
		<p><span class="label">密码:</span><input type="password" name="upwd"/></p>
		<p><span class="label">确认密码:</span><input type="password" name="upwd"/></p>
		<input type="submit" value="注册"/>
	</form> 
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <h1 id="opt_type"> 编辑新闻： </h1>
    <form action="${pageContext.request.contextPath}/news?method=update" method="post">
    <input type="hidden" name="nid" value="${news.nid }"/>
      <p>
        <label> 主题 </label>
        <select name="ntid" id="topic">
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" value="${news.ntitle }" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" value="${news.nauthor }" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary"  cols="40" rows="3">${news.nsummary}</textarea>
      </p>
      <p>
        <label>内容 </label>
        <textarea name="ncontent" cols="70" rows="10">${news.ncontent}</textarea>
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
<%
session.removeAttribute("news");
%>

<script>
var ajax = new XMLHttpRequest();
ajax.open("get", "${pageContext.request.contextPath}/topic?method=getAllAsync");

ajax.onreadystatechange = function(){
	if(ajax.readyState === 4 && ajax.status === 200){
		document.getElementById("topic").innerHTML = ajax.responseText;
	}
	
}
ajax.send();

</script>
</body>
</html>

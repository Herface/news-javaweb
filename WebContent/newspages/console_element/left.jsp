<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ctp = request.getContextPath();
%>
<div id="opt_list">
  <ul>
    <li><a href="<%=ctp%>/newspages/news_add.jsp">添加新闻</a></li>
    <li><a href="<%=ctp%>/news?method=getAll">编辑新闻</a></li>
    <li><a href="<%=ctp%>/newspages/topic_add.jsp">添加主题</a></li>
    <li><a href="<%=ctp%>/topic?method=getAll">编辑主题</a></li>
  </ul>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${topicList}" var="topic">
<a  href="javascript:;"><b>${topic.tname}</b></a> 
</c:forEach>   
 <%
 session.removeAttribute("topicList");
 %>
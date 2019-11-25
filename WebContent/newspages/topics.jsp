<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${topicEs}" var="item">
<option value="${item.tid}">${item.tname}</option>
</c:forEach>
<%
session.removeAttribute("topicEs");
%>
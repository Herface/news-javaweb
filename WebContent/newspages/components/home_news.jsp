<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${newsList}" var="n">
 <li><a href='${pageContext.request.contextPath}/news?method=detail&id=${n.nid}'> ${n.ntitle }</a><span> ${n.ncreatedate} </span></li>
</c:forEach>

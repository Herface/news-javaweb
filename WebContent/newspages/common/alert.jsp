<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String error = (String)session.getAttribute("error");
if(error != null){
	out.write("<script>alert('"+error+"')</script>");
	session.removeAttribute("error");
}
%>
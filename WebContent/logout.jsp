<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	request.getSession().removeAttribute("user");
	request.getSession().removeAttribute("booksCart");
	request.getSession().removeAttribute("booksCartCount");
	response.sendRedirect(request.getContextPath() + "/login.jsp");
%>


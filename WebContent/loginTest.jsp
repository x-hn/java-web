<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1 align="center">欢迎登录</h1>
	<%
		String username=(String)request.getAttribute("name");
	%>
<body>
	<p><span>欢迎你，<% out.println(username); %></span></p>
</body>
</html>
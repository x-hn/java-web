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
	    String[] params=request.getParameterValues("hobby");
	%>
<body background="t0144f3791b24151a3.jpg">
	<p><span>欢迎你，<% out.println(username); %></span></p>
	<p><span>你选择的爱好有: 
	<% 
		for(String ll:params) {
			out.print(ll.toString()+"\t");
		} 
	%>
	</span></p>
	<a href="message.jsp"><font size="3"><strong>留言</strong></font></a> <a href="login.jsp">返回到主界面</a>
</body>
</html>
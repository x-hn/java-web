<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String loginInfo=(String)session.getAttribute("loginname");
		String title=(String)session.getAttribute("title");
		String content=(String)session.getAttribute("content");
		String time=(String)session.getAttribute("time");
		String updateTitle=(String)session.getAttribute("updateTitle");
		String updateContent=(String)session.getAttribute("updateContent");
		
	%>
	 <div class="h">
    	<% if(loginInfo==null){%>
    	<a href="login.jsp">登录</a>
        <a href="resgiter.jsp">注册</a>
        <%} else{ %>
        <%
        	if(Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM){
        %>
        	 上午好，<span>
        <%}else{ %>
        	下午好，<span>
        <% }%>
       	
        <%if(loginInfo!=null){%>
        	<%=loginInfo %>
        <%} %>
         </span>！
        <a href="user?type=cancel" >注销账户</a>
     	<p><a href="message.jsp" >我要留言</a></p>
        <% } %>
    </div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jsj.hn.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        *{
            font-size: 14px;
        }
        div{
            margin: 0 auto;
            width: 800px;   
            margin-bottom: 5px;
            padding:2px;
        }
        table{
            border:1px solid blue;
            border-collapse: collapse;
            width:800px;
           	height:400px; 
            margin:5px;
        }
        td{
            border:1px solid blue;
        }
</style>
</head>
	<h2 align="center">编辑留言</h2>
	<%
		User loginUser=(User)session.getAttribute("loginUser");	
		String title=(String)session.getAttribute("title");
		String content=(String)session.getAttribute("content");
		String time=(String)session.getAttribute("time");
	%>
<body  background="message.jpg">
	<div>
	<form action="message?type=updateMessage" method="post">
		<table>
			<tr>
				<td>标题: </td>
				<td><textarea row="5" cols="20" name="updateTitle"><%=title %></textarea></td>
			</tr>
			<tr>
				<td>内容: </td>
				<td><textarea row="15" cols="100" name="updateContent"><%=content %></textarea></td>
			</tr>
			<tr>
				<td>日期: </td>
				<td><%=time %></td>
			</tr>
			<tr>
				<td>作者: </td>
				<td><%=loginUser.getUserName() %></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
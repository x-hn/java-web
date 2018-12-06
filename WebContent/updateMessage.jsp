<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h2 align="center">编辑留言</h2>
	<%
		String loginInfo=(String)session.getAttribute("loginname");
		String title=(String)session.getAttribute("title");
		String content=(String)session.getAttribute("content");
		String time=(String)session.getAttribute("time");
	%>
<body>
	<form action="message?type=updateMessage" method="post">
		<table align="center" border="1">
			<tr>
				<td>标题: </td>
				<td><textarea row="1" cols="15" name="updateTitle"><%=title %></textarea></td>
			</tr>
			<tr>
				<td>内容: </td>
				<td><textarea row="5" cols="15" name="updateContent"><%=content %></textarea></td>
			</tr>
			<tr>
				<td>日期: </td>
				<td><%=time %></td>
			</tr>
			<tr>
				<td>作者: </td>
				<td><%=loginInfo %></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
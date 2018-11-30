<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
</head>
	<h1 align="center">欢迎来到注册界面</h1>
<body background="t0144f3791b24151a2.jpg">
	<form action="user" method="post" >
		<table align="center" border="1">
		<input type="hidden" name="type" value="resgiter" />
			<tr>
				<td><font size="3" color="brown"><strong>用户名:</strong></font></td>
				<td><input type="text"  name="username"/></td>
			</tr>
			<tr>
				<td><font size="3" color="brown"><strong>密码:</strong></font></td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><font size="3" color="brown"><strong>确认密码:</strong></font></td>
				<td><input type="password" name="password1"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
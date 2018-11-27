<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1 align="center">欢迎来到注册界面</h1>
<body>
	<form action="resgiter" method="post">
		<table align="center" border="1">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="password1"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1 align="center">登录界面</h1>
<body	background="t0144f3791b24151a1.jpg">
	<form action="login" method="post">
		<table align="center" border="1">
			<tr>
				<td><font size="3"><strong>用户名:</strong></font></td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><font size="3"><strong>密码:</strong></font></td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><a href="resgiter.jsp">注册</a></td>
				<td align="center"><input type="submit" value="登录"/></td>
			</tr>
		</table>
	</form>	
</body>
</html>
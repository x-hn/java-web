<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
<script type="text/javascript">
	
	function check(){
		var flag=true;
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		var password1=document.getElementById("password1").value;
		var Info=document.getElementById("Info");
		if(username.length==0 || username==null){
			Info.innerText="用户名不能为空！";
			flag=false;
		}
		if(password==0 || password1==0){
			Info.innerText="密码不能为空！";
			flag=false;
		}
		if(password!=password1){
			Info.innerText="密码必须一致！";
			flag=false;
		}
		return flag;
	}
	
</script>
</head>
	<h1 align="center">欢迎来到注册界面</h1>
	<%
		String regInfo=(String)request.getAttribute("regInfo");
	%>
<body background="17942401_101320663138_2.jpg">
	<form action="user" method="post" onsubmit="return check();">
		<table align="center" border="1">
		<input type="hidden" name="type" value="resgiter" />
			<tr>
				<td><font size="3" color="brown"><strong>用户名:</strong></font></td>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<td><font size="3" color="brown"><strong>密码:</strong></font></td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<td><font size="3" color="brown"><strong>确认密码:</strong></font></td>
				<td><input type="password" id="password1" name="password1"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
		<% if(regInfo!=null) { %>
		<h5 align="center"><%=regInfo %></h5>
		<%} %>
		<h5 align="center" id="Info"></h5>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统登录</title>
<script type="text/javascript">
	
	function check(){
		var flag=false;
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(username.length<3 || password.length<3){
			alert("用户名或密码不符合要求,请重新输入！");
		}else{
			flag=true;
		}
		return flag;
	}
	
</script>
</head>
	<h1 align="center">登录界面</h1>
<body background="t0144f3791b24151a1.jpg">
	<form id="form1" action="user" method="post" onsubmit="return check()">
		<table align="center" border="1">
		<input type="hidden" name="type" value="login" />
			<tr>
				<td><font size="3"><strong>用户名:</strong></font></td>
				<td><input type="text" id="username" name="username"/></td>
			</tr>
			<tr>
				<td><font size="3"><strong>密码:</strong></font></td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr align="center" >
				<td colspan="2"><input type="submit" value="登录"/></td>
			</tr>
			<!-- <tr>
				<td colspan="2">
				    <input type="checkbox" name="hobby" value="美食"/>美食
				    <input type="checkbox" name="hobby" value="篮球"/>篮球
				    <input type="checkbox" name="hobby" value="足球"/>足球
				    <input type="checkbox" name="hobby" value="跳远"/>跳远
				</td>
			</tr> -->
		</table>
	</form>	
</body>
</html>
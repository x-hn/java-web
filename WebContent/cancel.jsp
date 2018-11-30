<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h1	align="center">注销界面</h1>
	<%
		String canInfo=(String)request.getAttribute("canInfo");
	%>
<body>
	<form action="user" method="post" onsubmit="return check();">
		<input type="hidden" name="type" value="cancel"/>
		<p>请再次输入用户名和密码！</p>
		<input type="text" id="username" name="username" /><br/>
		<input type="password" id="password" name="password" /><br/>
		<input type="password" id="password1" name="password1" /><br/>
		<input type="submit" value="注销"/><br/>
		<h3 id="Info"></h3>
		<% if(canInfo!=null) {%>
			<h5 align="center"><%=canInfo %></h5>
		<% } %>
	</form>
</body>
</html>
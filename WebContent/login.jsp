<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jsj.hn.model.*"%>
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
		if(username.length<2 || password.length<3){
			alert("用户名或密码不符合要求,请重新输入！");
		}else{
			flag=true;
		}
		return flag;
	}
	
</script>
</head>
	<h1 align="center">登录界面</h1>
	<%
		String username="";
		String password="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equalsIgnoreCase("username")){
					username=cookie.getValue();
				}
				if(cookie.getName().equalsIgnoreCase("password")){
					password=cookie.getValue();
				}
			}
		}
		User loginUser=(User)session.getAttribute("loginUser");
		String loginname=(String)request.getAttribute("loginname");
	%>
<body background="t0144f3791b24151a1.jpg">
	<form id="form1" action="user?type=login" method="post" onsubmit="return check();">
		<table align="center" border="1">
			<tr>
				<td><font size="3"><strong>用户名:</strong></font></td>
				<td><input type="text" id="username" name="username" value="<%=username%>"/></td>
			</tr>
			<tr>
				<td><font size="3"><strong>密码:</strong></font></td>
				<td><input type="password" id="password" name="password" value="<%=password%>"/></td>
			</tr>
			<tr align="center" >
				<td colspan="2">
					<input type="submit" value="登录"/>
					<input type="checkbox" name="isUserCookie" />记住密码
				</td>
			</tr>
		</table>
		<% if((loginUser.getUserName())!=null) {%>
			<h5 align="center"><%=loginname %></h5>
		<% } %>
	</form>	
</body>
</html>
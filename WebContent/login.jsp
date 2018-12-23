<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
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
	function changeValidateCode(){
		document.getElementById("validatecode").src="ValidateCodeServlet?rand="+Math.random();
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
	%>
<body background="login.jpg">
	<form id="form1" action="${ctx}/user?type=login" method="post" onsubmit="return check();">
		<table align="center" border="1">
			<tr>
				<td><font size="3"><strong>用户名:</strong></font></td>
				<td><input type="text" id="username" name="username" value="<%=username%>"/></td>
			</tr>
			<tr>
				<td><font size="3"><strong>密码:</strong></font></td>
				<td><input type="password" id="password" name="password" value="<%=password%>"/></td>
			</tr>
			<tr>
				<td><font size="3"><strong>请输入验证码: </strong></font></td>
				<td><input type="text" name="verifyCode"/></td>
				<td><img src="${ctx}/ValidateCodeServlet" id="validatecode" title="单击换一张" onclick="changeValidateCode()" /><a href="javascript:changeValidateCode();">看不清？</a></td>
			</tr>
			<tr align="center" >
				<td colspan="2">
					<input type="submit" value="登录"/>
					<input type="checkbox" name="isUserCookie" checked="checked"/>记住密码
				</td>
			</tr>
		</table>
		<c:if test="${not empty requestScope.loginname}">
			<h5 align="center">${requestScope.loginname}</h5>
		</c:if>
		<c:if test="${not empty requestScope.validateCode}">
			<h5 align="center">${requestScope.validateCode}</h5>
		</c:if>
	</form>	
</body>
</html>
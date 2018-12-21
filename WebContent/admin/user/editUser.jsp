<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<body>
	<form action="${ctx}/user?type=get" method="post" onsubmit="return check();">
		<table align="center" border="1">
			<input type="hidden" id="id" name="id" value="${user.id}" />
			<tr>
				<td><font size="3" color="brown"><strong>用户名:</strong></font></td>
				<td><input type="text" id="username" name="username" value="${user.userName}"/></td>
			</tr>
			<tr>
				<td><font size="3" color="brown"><strong>密码:</strong></font></td>
				<td><input type="text" id="password" name="password"/ value="${user.passWord}"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
		<h5 align="center" id="Info"></h5>
	</form>
</body>
</html>
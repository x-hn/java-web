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
		var username=document.getElementById("rolename").value;
		var Info=document.getElementById("Info");
		if(rolename.length==0 || rolename==null){
			Info.innerText="角色名不能为空！";
			flag=false;
		}
		return flag;
	}
	
</script>
<body>
	<form action="${ctx}/role?type=edit" method="post" onsubmit="return check();">
		<table align="center" border="1">
			<input type="hidden" id="id" name="id" value="${role.id}" />
			<tr>
				<td><font size="3" color="brown"><strong>用户名:</strong></font></td>
				<td><input type="text" id="rolename" name="rolename" value="${role.roleName}"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
		<h5 align="center" id="Info"></h5>
	</form>
</body>
</html>
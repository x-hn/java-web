<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h3{
		text-align:center;
	}
	table{
		margin:0 auto;
		width:980px;
		border:1px solid black;
		border-collapse:collapse;
	}
	td{
		border:1px solid black;
	}
	div{
		margin:0 auto;
		text-align:center;
	}
</style>
<body>
	<h3>用户管理</h3>
	<div>
		<a href="#">新增</a>&nbsp;&nbsp;
		<a href="#">修改</a>&nbsp;&nbsp;
		<a href="#">删除</a>&nbsp;&nbsp;
		<a href="#">重置密码</a>&nbsp;&nbsp;
		<a href="#">退出管理后台</a>&nbsp;&nbsp;
		<a href="#">网站前台</a>&nbsp;&nbsp;
	</div>
	<table>
		<tr>
			<td></td>
			<td>编号</td>
			<td>账号</td>
			<td>角色</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="obj">
			<tr>
				<td><input type="checkbox" id="getAll" name="getAll"/></td>
				<td>${obj.id}</td>
				<td>${obj.userName}</td>
				<td>${obj.rolename}</td>
				<td>
					<a href="#">编辑</a>
					<a href="#">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
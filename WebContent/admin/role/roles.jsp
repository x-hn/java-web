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
	.h{
		text-align: right;
		padding-right: 250px;
	}
	.active{
		text-decoration: none;
	}

</style>
<body>
		<c:set var="page" value="${page}"></c:set>
		<c:set var="totalRecords" value="${totalRecords}"></c:set>
		<c:set var="totalPages" value="${totalPages}"></c:set>
		<c:set var="beginIndex" value="${beginIndex}"></c:set>
		<c:set var="endIndex" value="${endIndex}"></c:set>
		<c:set var="pageSizes" value="${pageSizes}"></c:set>
		<c:set var="roleList" value="${roleList}"></c:set>
	<h3>用户管理</h3>
	
	<div>
		<a href="${ctx}/admin/role/addRole.jsp">新增</a>&nbsp;&nbsp;
		<a href="#">修改</a>&nbsp;&nbsp;
		<a href="#">删除</a>&nbsp;&nbsp;
		<a href="#">退出管理后台</a>&nbsp;&nbsp;
		<a href="${ctx}/index">网站前台</a>&nbsp;&nbsp;
	</div>
	<div>
	<table>
		<tr>
			<td></td>
			<td>编号</td>
			<td>角色</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${roleList}" var="obj">
			<tr>
				<td><input type="checkbox" id="getAll" name="getAll"/></td>
				<td>${obj.id}</td>
				<td>${obj.roleName}</td>
				<td>
					<a href="${ctx}/role?type=get&id=${obj.id}">编辑</a>
					<a href="${ctx}/role?type=delete&id=${obj.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="h">
        <p><font face="Geneva"><strong>此角色列表共有${totalPages}页，当前第${page}页</strong></font></p>
        		<a href="${ctx}/role?type=getAll&page=1">首页</a>
        		<c:if test="${page!=1}">
       			<a href="${ctx}/role?type=getAll&page=${page-1<1 ? 1:page-1}">上页</a>
       			</c:if>
       			<c:forEach begin="1" end="${totalPages}" var="obj">
        			<c:set var="active" value="${page==obj?'active':''}" ></c:set>
        			<c:set var="trueOrfalse" value="${page==obj?'return false':'return true'}" ></c:set>
        			<a class="${active}" href="${ctx}/role?type=getAll&page=${obj}" onclick="${trueOrfalse}">${obj}</a>
       		    </c:forEach>
       		    <c:if test="${page!=totalPages}">
        		<a href="${ctx}/role?type=getAll&page=${page+1>totalPages ? totalPages:page+1}">下页</a>
        		</c:if>
        		<a href="${ctx}/role?type=getAll&page=${totalPages}">末页</a>
    </div>
</body>
</html>
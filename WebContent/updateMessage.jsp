<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<%@page import="com.jsj.hn.model.*"%>
<%@page import="com.jsj.hn.DAO.*"%>
<%@page import="com.jsj.hn.impel.*"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        *{
            font-size: 14px;
        }
        div{
            margin: 0 auto;
            width: 800px;   
            margin-bottom: 5px;
            padding:2px;
        }
        table{
            border:1px solid blue;
            border-collapse: collapse;
            width:800px;
           	height:400px; 
            margin:5px;
        }
        td{
            border:1px solid blue;
        }
		textarea{
		    width:600px;
		    max-width:750px;
		    height:100px;
		    max-height:100px;
		    overflow-y:auto;
		}
</style>
</head>
	<h2 align="center">编辑留言</h2>
<body  background="message.jpg">
	<div>
	<form action="${ctx}/message?type=updateMessage" method="post">
		<table>
			<input type="hidden" id="id" name="id" value="${message.id}" />
			<tr>
				<td>标题: </td>
				<td><input  name="title" value="${message.title}"></td>
			</tr>
			<tr>
				<td>内容: </td>
				<td><textarea name="content" style=resize:none>${message.content}</textarea></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error.jsp"%>
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
        style{
        	resize:none;
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
	<%
		Imessage messageDAO=new messageImpel();
		User loginUser=(User)session.getAttribute("loginUser");	
		String title=(messageDAO.messageId(loginUser.getId())).getTitle();
		String content=(messageDAO.messageId(loginUser.getId())).getContent();
		Date time=(messageDAO.messageId(loginUser.getId())).getCreateDateTime();
	%>
<body  background="message.jpg">
	<div>
	<form action="message?type=updateMessage" method="post">
		<table>
			<tr>
				<td>标题: </td>
				<td><textarea row="5" cols="20" name="updateTitle" style=resize:none><%=title %></textarea></td>
			</tr>
			<tr>
				<td>内容: </td>
				<td><textarea name="updateContent" style=resize:none><%=content %></textarea></td>
			</tr>
			<tr>
				<td>日期: </td>
				<td><%=time %></td>
			</tr>
			<tr>
				<td>作者: </td>
				<td><%=loginUser.getUserName() %></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
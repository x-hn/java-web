<%@page import="java.text.SimpleDateFormat"%>
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
		var title=document.getElementById("title").value;
		var content=document.getElementById("content").value;
		var username=document.getElementById("username").value;
		var Info=document.getElementById("Info");
		if(title.length==0 || title==null){
			Info.innerText="标题不能为空！";
			flag=false;
		}
		if(username.length==0 || username==null){
			Info.innerText="请输入作者名字！";
			flag=false;
		}
		if(content.length==0){
			Info.innerText="内容不能为空！";
			flag=false;
		}
		if(title.length==0 && content==0){
			Info.innerText="标题和内容不能为空！";
			flag=false;
		}
		return flag;
	}
</script>
</head>
	<%
		
	%>
	<h1 align="center">欢迎进入留言系统</h1>
<body background="message.jpg">
	<form action="message" method="post" onsubmit="return check();">
	<input type="hidden" name="type" value="addMessage" />
		<table align="center" border="1">
            <tr>
                <td width="60px">标题：</td>
                <td><input  type="text" id="title" name="title" /></td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><textarea  rows="5" cols="15" id="content" name="content"></textarea></td>
            </tr>
            <tr>
                <td>作者：</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="提交留言"/></td>
            </tr>
        </table>
        <h5 align="center" id="Info"></h5>
	</form>
</body>
</html>
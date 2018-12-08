<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.jsj.hn.model.*"%>
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
        h3{
            text-align: center;
        }
        table{
            border:1px solid blue;
            border-collapse: collapse;
            width:800px;
            margin:5px;
        }
        td{
            border:1px solid blue;
        }
</style>
<script type="text/javascript">
	
	function check(){
		var flag=true;
		var title=document.getElementById("title").value;
		var content=document.getElementById("content").value;
		var Info=document.getElementById("Info");
		if(title.length==0 || title==null){
			Info.innerText="标题不能为空！";
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
		User loginUser=(User)session.getAttribute("loginUser");
	%>
	<h1 align="center">欢迎进入留言系统</h1>
<body background="message.jpg">
	<div>
	<form action="message?type=addMessage" method="post" onsubmit="return check();">
		<table>
            <tr>
                <td width="60px">标题：</td>
                <td><input  type="text" id="title" name="title" size="50"/></td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><textarea  rows="15" cols="100" id="content" name="content"></textarea></td>
            </tr>
            <tr>
                <td>作者：</td>
                <td><%=loginUser.getUserName()%></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="提交留言"/></td>
            </tr>
        </table>
        <h3 id="Info"></h3>
	</form>
	</div>
</body>
</html>
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
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		var Info=document.getElementById("Info");
		if(title.length==0 || title==null){
			Info.innerText="标题不能为空！";
			flag=false;
		}
		if(username.length==0 || username==null){
			Info.innerText="用户名不能为空！";
			flag=false;
		}
		if(password.length==0 ){
			Info.innerText="密码不能为空！";
			flag=false;
		}
		return flag;
	}
</script>
</head>
	<%
		String messInfo=(String)request.getAttribute("messInfo");
	%>
	<h2 align="center">确认删除留言！</h2>
<body>
	<form action="message" method="post" onsubmit="return check();">
		<table align="center" border="1">
		<input type="hidden" name="type" value="deleteMessage"/>
			<tr>
				<td>确认删除的文章标题:</td>
				<td><input type="text" id="title" name="title"/></td>
			</tr>
			<tr>
				<td>确认用户名:</td>
				<td><input type="text" if="username" name="username"/></td>
			</tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" if="password" name="password"/></td>
			</tr>
			<tr>
				<td>是否要删除留言</td>
				<td>
					<input type="submit" value="是"/>
					<input type="reset" value="否"/>
				</td>
			</tr>
		</table>
		<%if(messInfo!=null){ %>
			<h5 align="center"><%=messInfo %></h5>
		<%} %>
		<h5 align="center" id="Info"></h5>
	</form>
</body>
</html>
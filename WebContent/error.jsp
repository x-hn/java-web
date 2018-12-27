<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误提示</title>
<style>
        *{
            font-size: 14px;
        }
         #success_content{
         	position:relative;
         }
         .success_right{
        	left:800px;
        	width:400px;
        }  
        .success_left{
        	right:10px;
        	width:700px;
        } 
</style>
</head>
	<%
		//获得请求的绝对地址
		String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<base href="<%=basePath  %>">
	<link href="css/base.css" type="text/css" rel="stylesheet" />
	<link href="css/error.css" type="text/css" rel="stylesheet" />
<body>
	<div id="success_content">
		<div class="success_left">
			<img alt="" src="${ctx}/photo/errror.jpg">
		</div>
		<div class="success_right">
			<p class="demo"><%=exception %></p>
			<p>
			<a href="javascript:window.history.go(-1);">
			<span class="tn-button">返回上一步</span></a>
			<a href="index"><span class="tn-button">返回首页</span></a>
			</p>
		</div>
	</div>
</body>
</html>
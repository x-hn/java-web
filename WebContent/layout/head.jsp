<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.jsj.hn.model.*"%>
<%@page import="com.jsj.hn.DUBtils.*"%>
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
        .h{
            text-align: right;
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
	<% 
		
		User loginUser=(User)session.getAttribute("loginUser");
		String title=(String)session.getAttribute("title");
		String content=(String)session.getAttribute("content");
		String time=(String)session.getAttribute("time");
		String updateTitle=(String)session.getAttribute("updateTitle");
		String updateContent=(String)session.getAttribute("updateContent");
		GetId getid=new GetId();
	%>
</head>	
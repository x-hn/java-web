<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<%@page import="java.util.*"%>
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
</head>	
	<div class="h">
  		<c:choose>
  		 	<c:when test="${empty sessionScope.loginUser}">
    		  <a href="${ctx}/login.jsp">登录</a>
        	  <a href="${ctx}/resgiter.jsp">注册</a>
        	</c:when>
        	<c:otherwise>
        	  <%if(Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM){%>
        	     上午好，<span>
       		  <%}else{ %>
        	     下午好，<span>
       		  <% }%>
        		${sessionScope.loginUser.userName}</span>！
        		<a href="${ctx}/user?type=cancel" >注销账户</a>
        		
     			<p>
     				<a href="${ctx}/message.jsp" >我要留言</a>
     				<a href="${ctx}/user?type=getAll&page=1" >用户管理</a>	
     			</p>
        	</c:otherwise>
        </c:choose>
    </div> 
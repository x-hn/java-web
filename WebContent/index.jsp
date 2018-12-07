<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.jsj.hn.model.*"%>
<%@ include file="/layout/head.jsp" %>
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
	
<body background="60p58PICtXG_1024.jpg">
   
    <div>
        <h3>留言列表</h3>
        
        <%if(title!=null || updateTitle!=null){ %>
        <table>
            <tr>
                <td width="60px">标题：</td>
                <td>
                	<%if(title!=null){ %>
                	<%=title %>
                	<%} %>
                	<%if(title==null){ %>
                	<%=updateTitle %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td>
               		<%if(content!=null){ %>
                	<%=content %>
                	<%} %>
                	<%if(content==null){ %>
                	<%=updateContent %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>时间：</td>
                <td>
                	<%if(time!=null){ %>
                	<%=time %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>
                	<%if(loginInfo!=null){ %>
                	<%=loginInfo %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="message?type=deleteMessage">删除</a>
                    <a href="updateMessage.jsp">编辑</a>
                </td>
            </tr>
        </table>
		<%} %>
		
		<%
        		List<Message> messageList=(List<Message>)request.getAttribute("messageList");
        		for(Message m:messageList){
        %>
        <table>
            <tr>
                <td width="60px">标题：</td>
                <td><%=m.getTitle() %></td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><%=m.getContent() %></td>
            </tr>
            <tr>
                <td>时间：</td>
                <td><%=m.getCreateDateTime() %></td>
            </tr>
            <tr>
                <td>作者：</td>
                <td><%=m.getUserId() %></td>
            </tr>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="message?type=deleteMessage">删除</a>
                    <a href="updateMessage.jsp">编辑</a>
                </td>
            </tr>
        </table> 
        <%} %>      
    </div>
    <div class="h">
        共有123页，当前第8页，每页10条留言
        <a href="">首页</a>
        <a href="">上页</a>
        <a href="">下页</a>
        <a href="">末页</a>
    </div>
</body>
</html>

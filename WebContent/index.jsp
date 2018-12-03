<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            margin:5px;
        }
        td{
            border:1px solid blue;
        }
    </style>
</head>
	<% 
		String loginInfo=(String)request.getAttribute("loginname");
		String title=(String)request.getAttribute("title");
		String content=(String)request.getAttribute("content");
		String username=(String)request.getAttribute("username");
		String time=(String)request.getAttribute("time");
	%>
<body background="60p58PICtXG_1024.jpg">
    <div class="h">
    	<% if(loginInfo==null && username==null){%>
    	<a href="login.jsp">登录</a>
        <a href="resgiter.jsp">注册</a>
        <%} else{ %>
       	 欢迎您，<span>
        <%if(loginInfo!=null){%>
        	<%=loginInfo %>
        <%} %>
        <%if(username!=null){%>
        	<%=username %>
        <%} %>
         </span>！
        <a href="cancel.jsp" >注销账户</a>
        <p><a href="message.jsp" >我要留言</a></p>
        <% } %>
    </div>
    <div>
        <h3>留言列表</h3>
        <%if(title!=null){ %>
        <table>
            <tr>
                <td width="60px">标题：</td>
                <td>
                	<%if(title!=null){ %>
                	<%=title %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td>
               		<%if(content!=null){ %>
                	<%=content %>
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
                	<%if(username!=null){ %>
                	<%=username %>
                	<%} %>
                </td>
            </tr>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="MessageServlet">删除</a>
                    <a href="#">编辑</a>
                </td>
            </tr>
        </table>
		<%} %>
        <table>
            <tr>
                <td width="60px">标题：</td>
                <td>这是第一个测试的留言标题</td>
            </tr>
            <tr>
                <td>内容：</td>
                <td>这是第一个测试的留言内容这是第一个测试的留言内容这是第一个测试的留言内容这是第一个测试的留言内容这是第一个测试的留言内容</td>
            </tr>
            <tr>
                <td>时间：</td>
                <td>2018年11月30日</td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>Tom</td>
            </tr>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="#">删除</a>
                    <a href="#">编辑</a>
                </td>
            </tr>
        </table>       
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>h
<%@page import="com.jsj.hn.model.*"%>
<%@ include file="/layout/head.jsp" %>

<body background="index.jpg">
  	<div class="h">
  		 <%if(loginUser==null) {%>
    	<a href="login.jsp">登录</a>
        <a href="resgiter.jsp">注册</a>
        <%}else { %>
        <%
        	if(Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM){
        %>
        	 上午好，<span>
        <%}else{ %>
        	下午好，<span>
        <% }%>
        <%if(loginUser.getUserName()!=null){%>
        	<%=loginUser.getUserName() %>
         </span>！
        <a href="user?type=cancel" >注销账户</a>
     	<p><a href="message.jsp" >我要留言</a></p>
        <% } %>
        <%} %> 
    </div> 
    <div>
        <h3>留言列表</h3>
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
                <td><%=GetId.getMessageName(m.getUserId()) %></td>
            </tr>
            <%if(loginUser!=null) {%>
             	<%if(loginUser.getRoleId()==1) {%>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="message?type=deleteMessage&id=<%=m.getId() %>" onclick="return confirm('亲爱的管理员，您是否确定要删除该记录？');">删除</a>
                </td>
            </tr>
            	<%} %>
            	<%if(loginUser.getRoleId()==2 && loginUser.getId()==m.getUserId()) {%>
            <tr>
                <td>操作：</td>
                <td>
                    <a href="message?type=deleteMessage&id=<%=m.getId() %>" onclick="return confirm('尊敬的用户，您是否确定要删除该记录？');">删除</a>
                    <a href="updateMessage.jsp">编辑</a>
                </td>
            </tr>
            	<%} %>
            <%} %>
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
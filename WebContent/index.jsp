<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<%@page import="java.util.*"%>
<%@ include file="/layout/head.jsp" %>
<script type="text/javascript">
	function check(){
		alert('亲爱的管理员，你不可以编辑除自己以外其他用户的留言');
		return false;
	}
</script>
<body background="index.jpg">
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
     			<p><a href="${ctx}/message.jsp" >我要留言</a></p>
        	</c:otherwise>
        </c:choose>
    </div> 
    <div>
        <h3>留言列表</h3>
        <c:forEach var="list" items="${requestScope.messageList}" >
        <table>
            <tr>
                <td width="60px">标题：</td>
                <td>${list.title}</td>
            </tr>
            <tr>
                <td>内容：</td>
                <td>${list.content}</td>
            </tr>
            <tr>
                <td>时间：</td>
                <td>${list.createDateTime}</td>
            </tr>
            <tr>
                <td>作者：</td>
                <td>${list.username}</td>
            </tr>
            <c:if test="${not empty sessionScope.loginUser}">
            <c:if test="${sessionScope.loginUser.roleId eq 1}">
            <tr>
                <td>操作：</td>
                <td>
                    <a href="${ctx}/message?type=deleteMessage&id=${list.id}" onclick="return confirm('亲爱的管理员，您是否确定要删除该记录？');">删除</a>
                    <a href="${ctx}/updateMessage.jsp" onclick="return check();">编辑</a>
                </td>
            </tr>
            	</c:if> 
            	<c:if test="${sessionScope.loginUser.roleId eq 2 and sessionScope.loginUser.id eq list.userId}">
            <tr>
                <td>操作：</td>
                <td>
                    <a href="${ctx}/message?type=deleteMessage&id=${list.id}" onclick="return confirm('尊敬的用户，您是否确定要删除该记录？');">删除</a>
                    <a href="${ctx}/updateMessage.jsp">编辑</a>
                </td>
            </tr>
            	</c:if>
           </c:if> 
        </table> 
        </c:forEach>
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
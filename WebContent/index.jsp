<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<%@ include file="/layout/head.jsp" %>
<style>
	.active{
		text-decoration: none;
	}
</style>
<body background="index.jpg">
		<c:set var="page" value="${page}"></c:set>
		<c:set var="totalRecords" value="${totalRecords}"></c:set>
		<c:set var="totalPages" value="${totalPages}"></c:set>
		<c:set var="beginIndex" value="${beginIndex}"></c:set>
		<c:set var="endIndex" value="${endIndex}"></c:set>
		<c:set var="pageSizes" value="${pageSizes}"></c:set>
		<c:set var="messageList" value="${messageList}"></c:set>
		<c:set var="CurrectmessageList" value="${messageList.subList(beginIndex,endIndex)}"></c:set>
    <div>
        <h3>留言列表</h3>
        <c:forEach var="list" items="${CurrectmessageList}" >
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
                    	<c:if test="${sessionScope.loginUser.id eq list.userId}">
                    	<a href="${ctx}/message?type=get&id=${list.id}">编辑</a>
                   		</c:if>
                </td>
            </tr>
            	</c:if> 
            	<c:if test="${sessionScope.loginUser.roleId eq 2 and sessionScope.loginUser.id eq list.userId}">
            <tr>
                <td>操作：</td>
                <td>
                    <a href="${ctx}/message?type=deleteMessage&id=${list.id}" onclick="return confirm('尊敬的用户，您是否确定要删除该记录？');">删除</a>
                    <a href="${ctx}/message?type=get&id=${list.id}">编辑</a>
                </td>
            </tr>
            	</c:if>
           </c:if> 
        </table> 
        </c:forEach>
    </div>
    <div class="h">
        <p><font face="Geneva"><strong>此留言列表共有${totalPages}页，当前第${page}页。</strong></font></p>
        		<a href="${ctx}/index?page=1">首页</a>
        		<c:if test="${page!=1}">
       			<a href="${ctx}/index?page=${page-1<1 ? 1:page-1}">上页</a>
       			</c:if>
       			<c:forEach begin="1" end="${totalPages}" var="obj">
        			<c:set var="active" value="${page==obj?'active':''}" ></c:set>
        			<c:set var="trueOrfalse" value="${page==obj?'return false':'return true'}" ></c:set>
        			<a class="${active}" href="${ctx}/index?page=${obj}" onclick="${trueOrfalse}">${obj}</a>
       		    </c:forEach>
       		    <c:if test="${page!=totalPages}">
        		<a href="${ctx}/index?page=${page+1>totalPages ? totalPages:page+1}">下页</a>
        		</c:if>
        		<a href="${ctx}/index?page=${totalPages}">末页</a>
    </div>
    <div class="h">
    	<form action="${ctx}/index">
    	<input type="text" name="page" /><input type="submit" value="查找" />
    	</form>
    </div>
</body>
</html>
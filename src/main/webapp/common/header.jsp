<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<style>
.right{float:right; padding-right: 20px;}
</style>

<span class="right"> 
<c:if test="${user!=null}">
${user.user_name}님 환영
</c:if>
<c:if test="${user==null}">
Guest님 환영
</c:if>

</span>
<span><a class="right" href="../LogOut">로그아웃</a></span>
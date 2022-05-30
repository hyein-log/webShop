<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.right {
	float: right;
	padding-right: 20px;
}
</style>
<div>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	<span class="right"> <c:if test="${user!=null}">
${user.user_name}님 환영
</c:if> <c:if test="${user==null}">
Guest님 환영
</c:if>

	</span> <span> <c:if test="${user==null }">
			<a class="right" href="${path }/html/Login.do">로그인1</a>
		</c:if> <c:if test="${user!=null }">
			<a class="right" href="${path }/LogOut">로그아웃1</a>
		</c:if> <%-- choose when으로 수정해봄 --%> <c:choose>
			<c:when test="${user==null }">
				<a class="right" href="${path }/html/Login.do">로그인2</a>
			</c:when>
			<c:otherwise>
				<a class="right" href="${path }/LogOut">로그아웃2</a>
			</c:otherwise>
		</c:choose>
	</span>
</div>
<br>
<br>
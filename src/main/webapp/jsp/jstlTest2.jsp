<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>JSTL 연습2</h1>
	<pre>
1.url만들기 : 현재경로가 자동으로 들어감 /webShop/jsp/
<c:set var="path" value="${pageContext.request.contextPath }" />
<c:url var="newUrl" value="jstlTest3.jsp">
<c:param name="myName" value="kim" />
<c:param name="myPhone" value="010-1234-1234" />
</c:url>
<a href="${newUrl}">페이지이동</a>

2.파라메터로 들어온 값 판단 
<c:set var="score" value="${param.score }"> </c:set>
<h3>${score }</h3>
<c:choose>
<c:when test="${score>=90 }">
<p>A학점</p>
</c:when>
<c:when test="${score>=80}">
<p>B학점</p>
</c:when>
<c:otherwise>
<p>F학점</p>
</c:otherwise>
</c:choose>

3.다국어 처리
<fmt:setLocale value="ko_KR"/>
<fmt:bundle basename="resource/member">
	<fmt:message key="member.name"/>
	<fmt:message key="member.address"/>
</fmt:bundle>
<fmt:setLocale value="en_US"/>
<fmt:bundle basename="resource/member">
	<fmt:message key="member.name"/>
	<fmt:message key="member.address"/>
</fmt:bundle>
</pre>
</body>
</html>
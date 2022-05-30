<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>JSTL 연습</h1>

	1. set (setAttribute) :
	<c:set var="myName" value="hyein" scope="page">
		<%-- 자바코드로 하면 pageContext.setAttrebute("myName", "hyein")과 동일--%>
	</c:set>
	<c:set var="path" value="${pageContext.request.contextPath }"
		scope="application"></c:set>
<br>
	2. get(getAttrebute) : ${myName } <br>
	contextPath : ${path } <br>
	3. 반복문<br>
	<c:forEach begin="1" end="5" step="1" var="num">
${num }<br>
</c:forEach>
<br>
	<%
	String[] arr = { "월", "화", "수", "목" };
	request.setAttribute("week", arr);
	%>
	<c:forEach items="${week }" var="day" varStatus="status"> 
status.index : ${status.index }<br>
status.count : ${status.count }<br>
status.first : ${status.first }<br>
status.last : ${status.last }<br>
<c:if test="${status.first }">
			<span style="color: hotpink">${day }</span><br>
		</c:if>
		<c:if test="${status.last }">
			<span style="color: blue">${day }</span><br>
		</c:if>
		<c:if test="${(status.last==false ) &&status.first!=true }">
			<span style="color: orange">${day }</span><br>
		</c:if>
		<hr>
	</c:forEach>
<br>
4.token<br>
<c:set var="subject" value="java, sql, jsp/servlet, spring"/>
<c:forTokens items="${subject }" delims="," var="ss">
${ss }
</c:forTokens>
</body>
</html>
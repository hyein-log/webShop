<%@page import="com.kosta.dto.EMPVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
BoardVO board = new BoardVO("월요일", "el연습", 100);
application.setAttribute("boardVO", board);
session.setAttribute("boardVO", new BoardVO("화요일", "el연습", 100));
request.setAttribute("boardVO", new BoardVO("수요일", "el연습", 100));
pageContext.setAttribute("boardVO", new BoardVO("목요일", "el연습", 100));

List<BoardVO> blist = new ArrayList<>();
blist.add(new BoardVO("A", "el연습", 100));
blist.add(new BoardVO("B", "el연습", 100));
blist.add(new BoardVO("C", "el연습", 100));
blist.add(new BoardVO("D", "el연습", 100));
blist.add(new BoardVO("E", "el연습", 100));
pageContext.setAttribute("boardList", blist);

List<BoardVO> Blist = new ArrayList<>();
Blist.add(new BoardVO("A", "el연습", 100,new EMPVO(100, "1 김", "혜인")));
Blist.add(new BoardVO("B", "el연습", 100,new EMPVO(100, "2 김", "혜인")));
Blist.add(new BoardVO("C", "el연습", 100,new EMPVO(100, "3 김", "혜인")));
Blist.add(new BoardVO("D", "el연습", 100,new EMPVO(100, "4 김", "혜인")));
Blist.add(new BoardVO("E", "el연습", 100,new EMPVO(100, "5 김", "혜인")));
request.setAttribute("boardList2", Blist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
	<h1>EL연습</h1>
	<pre>
1.읽기 : ${boardVO }
1.읽기 : ${applicationScope.boardVO }
1.읽기 : ${sessionScope.boardVO }
1.읽기 : ${requestScope.boardVO }
1.읽기 : ${pageScope.boardVO }
<hr>
2.scriptlet의 expression : <%=board%>
3.scriptlet의 expression : <%=application.getAttribute("boardVO")%>
<hr>
3.list읽기 : ${boardList }; <!-- el문법에는 for문이 없어서 JSTL을 사용하게 되는것임 -->
<ul>
<c:forEach items="${boardList }" var="Board">
<li>		
${Board.title}..${Board.content }
</li> <%--b.getTitle()이 호출됨 --%>
</c:forEach>
</ul>
<hr>
<ul>
<c:forEach items="${boardList2 }" var="Board">
<li>		
${Board.title}..${Board.content }..${Board.emp.first_name }${Board.emp.last_name }
</li> <%--b.getTitle()이 호출됨 --%>
</c:forEach>
</ul>
<hr>
<%--
jsp:forward는 표준액션이다.
forward는 요청과 응답을 다른 페이지로 넘긴다. 주소창은 바뀌지 않음
include는 요청과 응답을 다른 페이지로 넘기고 그 페이지가 이 페이지로 포함된다.
 --%>
 <jsp:include page="elTest4.jsp"></jsp:include>
</pre>
</body>
</html>
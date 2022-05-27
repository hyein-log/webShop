<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자바빈즈 테스트</h1>
<%
//1.자바코드로 파라매터 받아서 객체생성
request.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer= request.getParameter("writer");
int i_writer = Integer.parseInt(writer);
BoardVO  board = new  BoardVO();
board.setTitle(title);
board.setContent(content);
board.setWriter(i_writer);
%>
제목 = <%=board.getTitle() %><br>
내용 = <%=board.getContent() %><br>
작성자 = <%=board.getWriter() %><br>
<hr>
<h2>2.action tag 사용하기 -> jsp:useBean 사용</h2>
<jsp:useBean id="board2" class="com.kosta.dto.BoardVO" scope="session"></jsp:useBean>
<%-- <jsp:setProperty property="title" name="board2" value="${param.title}"/>
<jsp:setProperty property="content" name="board2" value="${param.content}"/>
<jsp:setProperty property="writer" name="board2" value="${param.writer}"/>--%>
<jsp:setProperty property="title" name="board2" param=title/>
<jsp:setProperty property="content" name="board2" param=content/>
<jsp:setProperty property="writer" name="board2"param=writer/>
<hr>
<h2>action tag 사용해서 읽기</h2>
제목 = <jsp:getProperty property="title" name="board2"/><br>
내용 = <jsp:getProperty property="content" name="board2"/><br>
작성자 = <jsp:getProperty property="writer" name="board2"/><br>

<a href="boardInsertBeanTest3.jsp">3번째 페이지로 이동</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>!!"로그인에 성공</h1>
<h2>DB접속 후 다시 수정하기</h2>
<h2><%=request.getParameter("userid") %></h2>
<h2>${param.userid}</h2>
<h2>이메일 = ${param.useremail}</h2>
<h2>주소 = ${param.useraddress}</h2>
<a href="login2.do?a=${param.userid}&b=${param.userpw}&c=${param.useremail}&d=${param.useraddress}">다른 페이지에 정보 넘기기</a>
</body>
</html>
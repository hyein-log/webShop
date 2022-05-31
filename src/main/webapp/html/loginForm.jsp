<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
 body>form { border: 1px solid lightgray;
    width:50%;
    padding:20px; 
    margin: 0 auto;
  }
  h1{ text-align: center;
      padding: 20px;
  }
  body { width: 80%; margin: 0 auto;}
</style>
</head>
<body>
<h1>로그인하기</h1>
<%@include file="../common/header.jsp" %>
<form action="Login.do" method="post">
사용자번호<br> <input type="text" name="userid" value="ohio"><br>
비밀번호<br> <input type="text" name="userpw" value="1234"><br>
<input type="hidden" name="useremail" value="ohio0510@naver.com"><br>
<input type="hidden" name="useraddress" value="서울"><br>
<input  class="btn btn-primary" type ="submit" value="로그인">
</form>
</body>
</html>
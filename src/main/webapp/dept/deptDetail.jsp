<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{background-color: orange;}
</style>
</head>
<body>
<h1>부서 상세보기</h1>
<form action="../dept/deptUpdate.do" method="post">
부서번호 : ${dept.department_id }<input type="hidden" name="department_id" value ="${dept.department_id }" ><br>
부서이름 : <input type="text" name="department_name" value ="${dept.department_name }"><br>
매니저번호 : <input type="number" name="manager_id" value ="${dept.manager_id }"><br>
지역번호 : <input type="number" name="location_id" value = "${dept.location_id }"><br>
<input type="submit" value ="수정">
<input type="reset" value ="취소">
</form>

<hr>
<h1> 파라메터로 받은 부서번호 : ${param.deptid}</h1>
<p>부서이름 : ${deptName}</p>
<p>매니저 : ${mid}</p>
<p>location ID : ${loc }</p>
<p>${dept }</p>
<p>${dept.department_id }</p>
<p>${dept.department_name }</p>
<p>${dept.manager_id }</p>
<p>${dept.location_id }</p>
</body>
</html>
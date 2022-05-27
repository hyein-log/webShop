<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
<pre> <!-- 내가 쓴 대로 출력되는 명령어 -->
1.숫자 : ${100 }
2.문자 : ${"hello" }${'d' }
3-1.10>20 boolean : ${10>20}
3-2. 2 le 10 비교 : ${2 le 10 }
4."100"+200 문자+숫자 : ${"100"+200 }
5.10 div 3 연산 : ${10 div 3 }
6.10 mod 3 연산 : ${10 mod 3 }

7-1"hello" == 'hello' 같은지? : ${"hello" == 'hello' } 
7-2"hello" eq 'hello' 같은지? : ${"hello" eq 'hello' } 
8-1"hello" != 'hello' 다른지? : ${"hello" != 'hello' } 
8-2"hello" ne 'hello' 다른지? : ${"hello" ne 'hello' } 

9-1 user== null 비교,not : ${user==null }
9-2 user!= null 비교,not : ${user!=null }

10-1 user : ${user }
10-2 userid : ${user.user_id }

11-1 empty : ${empty user }
11-2 empty : ${empty null }
11-3 empty : ${empty "" }
</pre>
<form action="elTest2.jsp">
myname : <input name="myname" value="김혜인"><br>
subject : <input type="checkbox" name ="subject" value="컴공" checked="checked">컴공
subject : <input type="checkbox" name ="subject" value="경제" checked="checked">경제
<input type="submit" value="eltest2로가기">
</form>

</body>
</html>
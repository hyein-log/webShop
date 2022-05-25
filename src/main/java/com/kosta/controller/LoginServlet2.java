package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/login2.do")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 그래서 한글이 깨지지 않는다.
		//post요청은 요청문서의 body에 파라메터가 인코딩안돼서 넘어온다. 그래서 한글이 깨진다.
		request.setCharacterEncoding("utf-8"); //post에서는 필수로 필요함
		String id = request.getParameter("a");
		String password = request.getParameter("b");
		String email = request.getParameter("c");
		String address = request.getParameter("d");
		System.out.println(id+"-->"+password);
		System.out.println("email -->"+email);
		System.out.println("address -->"+address);
		System.out.println(request.getMethod()); //get인지 post인지 알 수 있음
		System.out.println(request.getContextPath());
		
		//<MVC1모델> 좋지 않음. 바람직한 모델사용은 MVC2임
//		//응답문서 만들기 전에 응답문서의 타입과 인코딩 방식을 세팅해야함
//		response.setContentType("text/html;charset=utf-8");
//		//응답문서 만들기
//		PrintWriter out = response.getWriter();
//		out.write("<h1>로그인에 성공</h1>");
//		out.write("<h2>DB접속 후 다시 수정하기</h2>");
		
		//<MVC2모델>
		//servlet이 실행결과를 JSP에 위임한다. 주소창은 변경되지 않음
		//A를 부르면 B로 가는 것을 위임한다라고 함
//		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
//		rd.forward(request, response);
	}

}

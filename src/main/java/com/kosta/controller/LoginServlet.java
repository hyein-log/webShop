package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;
import com.kosta.model.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 그래서 한글이 깨지지 않는다.
		//post요청은 요청문서의 body에 파라메터가 인코딩안돼서 넘어온다. 그래서 한글이 깨진다.
		//필터로 처리함request.setCharacterEncoding("utf-8"); //post에서는 필수로 필요함
		String id = request.getParameter("userid");
		String password = request.getParameter("userpw");
		UserService service = new UserService();
		UserVO user = service.selectById(id, password);
		//session 저장하기 : 다른페이지에서 상태를 알기위해(로그인여부 알고 처리위해)
		//쿠키 : 브라우저에 정보를 저장
		//세션 : 정보는 서버에 저장, 브라우저에는 session id저장
		HttpSession session = request.getSession();
		session.setAttribute("user", user); //쿠키는 문자밖에 못오는데 세션은 다 올 수 있음
		String path = (String)session.getAttribute("requestPath");
		if(user ==null) {
			response.sendRedirect("Login.do");
		}else if(user!=null && path.equals("/webShop/Login.do")){
			path = request.getContextPath() + "/1.jsp";
			response.sendRedirect(path);
		}else {
			response.sendRedirect(path);
		}
//		String email = request.getParameter("useremail");
//		String address = request.getParameter("useraddress");
//		System.out.println(id+"-->"+password);
//		System.out.println("email -->"+email);
//		System.out.println("address -->"+address);
//		System.out.println(request.getMethod()); //get인지 post인지 알 수 있음
//		System.out.println(request.getContextPath());
		
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

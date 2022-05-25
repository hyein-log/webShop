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
import com.kosta.model.EMPService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		if(user == null) {
			System.out.println("로그인 실패...직원정보 볼 수 없음");
			response.sendRedirect("../html/Login.do");
			return;
		}
		EMPService empService = new EMPService();
		request.setAttribute("emplist", empService.selectAll());
		
		RequestDispatcher rd; //위임(요청을 받은 것은 servlet인데 응답은 JSP가 하도록함)
		rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}

}

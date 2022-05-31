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
 * Servlet implementation class EmpDeleteServlet
 */
//@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		EMPService empService = new EMPService();
		int result = empService.empDelete(emp_id);
		request.setAttribute("message", result>0?"삭제성공":"실패");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}

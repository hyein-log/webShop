package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptDeleteServlet
 */
@WebServlet("/dept/deptDelete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid =Integer.parseInt(request.getParameter("deptid"));
		DeptService deptService = new DeptService();
		int result = deptService.deptDelete(deptid);
		request.setAttribute("message", result>0?"삭제성공":"실패");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}

package com.kosta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/dept/deptlist.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService deptService = new DeptService();
		request.setAttribute("deptLists", deptService.selectAll());
		
		RequestDispatcher rd; //위임(요청을 받은 것은 servlet인데 응답은 JSP가 하도록함)
		rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
	}

}

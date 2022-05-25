package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest
 */
@WebServlet("/ServletContextTest")
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ ���� ����
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext app = getServletContext();
		System.out.println("getcontextpath = "+ app.getContextPath());
		System.out.println("getMajorVersion = "+ app.getMajorVersion());
		System.out.println("getMinorVersion = "+ app.getMinorVersion());
		System.out.println("getRealPath = "+ app.getRealPath("."));
		System.out.println("getRealPath = "+ app.getRealPath("./board"));
		app.setAttribute("myname","hyein");
		request.setAttribute("myaddress","����� ���α�");
		
		System.out.println("getAttribute = "+ app.getAttribute("myname"));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("jsp/contextTest.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

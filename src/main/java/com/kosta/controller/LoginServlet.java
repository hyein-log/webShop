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
		//get��û�� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�´�. �׷��� �ѱ��� ������ �ʴ´�.
		//post��û�� ��û������ body�� �Ķ���Ͱ� ���ڵ��ȵż� �Ѿ�´�. �׷��� �ѱ��� ������.
		//���ͷ� ó����request.setCharacterEncoding("utf-8"); //post������ �ʼ��� �ʿ���
		String id = request.getParameter("userid");
		String password = request.getParameter("userpw");
		UserService service = new UserService();
		UserVO user = service.selectById(id, password);
		//session �����ϱ� : �ٸ����������� ���¸� �˱�����(�α��ο��� �˰� ó������)
		//��Ű : �������� ������ ����
		//���� : ������ ������ ����, ���������� session id����
		HttpSession session = request.getSession();
		session.setAttribute("user", user); //��Ű�� ���ڹۿ� �����µ� ������ �� �� �� ����
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
//		System.out.println(request.getMethod()); //get���� post���� �� �� ����
//		System.out.println(request.getContextPath());
		
		//<MVC1��> ���� ����. �ٶ����� �𵨻���� MVC2��
//		//���乮�� ����� ���� ���乮���� Ÿ�԰� ���ڵ� ����� �����ؾ���
//		response.setContentType("text/html;charset=utf-8");
//		//���乮�� �����
//		PrintWriter out = response.getWriter();
//		out.write("<h1>�α��ο� ����</h1>");
//		out.write("<h2>DB���� �� �ٽ� �����ϱ�</h2>");
		
		//<MVC2��>
		//servlet�� �������� JSP�� �����Ѵ�. �ּ�â�� ������� ����
		//A�� �θ��� B�� ���� ���� �����Ѵٶ�� ��
//		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
//		rd.forward(request, response);
	}

}

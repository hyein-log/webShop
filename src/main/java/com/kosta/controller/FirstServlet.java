package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({"/FirstServlet", "/first", "/first2", "/first/second.do"}) //�迭�� ���������� ������ �� �� ���� �迭�� �ȿ� �� �ƹ��ų� ȣ���ص� ���� �ҷ���
																		//�� �տ� �����ø� �������� ������ ��. ������ ��� �ʼ���
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
       System.out.println("FirstServlet�����ڼ���(���ʿ�û�� 1ȸ)");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init ����(���ʿ�û�� 1ȸ)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FirstServlet destroy ����(server ���� ��)");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet ����(get��û�� ���� ����)");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("get��û Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost ����");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("post��û Served at: ").append(request.getContextPath());
	}

}

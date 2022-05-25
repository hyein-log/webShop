package com.kosta.controller2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieTest
 */
@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��Ű�� �����ؼ� ���乮���� �߰��ϰ� �������� ����������.
		Cookie c1= new Cookie("cookie_subject", "jspServlet");
		c1.setMaxAge(60*3); //60��*3 = 3���� ������
		Cookie c2 = new Cookie("cookie_score", "100");
		c2.setMaxAge(60*60);
		Cookie c3 = new Cookie("cookie_title",URLEncoder.encode("webshop ������Ʈ", "utf-8"));
		//c3.setMaxAge(60*60*24);
		//��ȿ�ð��� �������� ������ ���� ��Ű�� ����� �������� ��� ������
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>Served at: cookie ���忹��</h1>").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

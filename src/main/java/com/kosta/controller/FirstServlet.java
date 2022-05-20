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
@WebServlet({"/FirstServlet", "/first", "/first2", "/first/second.do"}) //배열로 여러가지의 서블렛을 줄 수 있음 배열값 안에 든 아무거나 호출해도 서버 불러짐
																		//단 앞에 슬래시를 빼먹으면 에러가 뜸. 슬래시 사용 필수임
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
       System.out.println("FirstServlet생성자수행(최초요청시 1회)");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init 수행(최초요청시 1회)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FirstServlet destroy 수행(server 중지 시)");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet 수행(get요청시 마다 실행)");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("get요청 Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost 수행");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("post요청 Served at: ").append(request.getContextPath());
	}

}

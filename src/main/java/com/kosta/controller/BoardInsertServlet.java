package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//�Է�form �����ֱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
		ServletContext app = getServletContext();
		String arr = (String) app.getAttribute("myname");
		System.out.println("getAttribute! = "+ arr);
	}

	//�Էµ� �����͸� DB�� �����ϱ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		
		BoardVO boardVO = new BoardVO(0, title, content, writer, null, null);
		BoardService boardService = new BoardService();
		int result = boardService.insert(boardVO);
//		String message = "��������";
//		if(result >0) message="��������";
//		request.setAttribute("message", message);
//		RequestDispatcher rd;
//		rd = request.getRequestDispatcher("result.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("boardlist.do");
		//redirect : �ּ�â�� �ٲ�
		//forward : �ּ�â�� �ٲ��� ���� . ��û�� ������ �ٸ� �����̴�.
	}

}

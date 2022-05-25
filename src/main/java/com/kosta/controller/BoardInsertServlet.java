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
    
	//입력form 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
		ServletContext app = getServletContext();
		String arr = (String) app.getAttribute("myname");
		System.out.println("getAttribute! = "+ arr);
	}

	//입력된 데이터를 DB에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		
		BoardVO boardVO = new BoardVO(0, title, content, writer, null, null);
		BoardService boardService = new BoardService();
		int result = boardService.insert(boardVO);
//		String message = "수정실패";
//		if(result >0) message="수정성공";
//		request.setAttribute("message", message);
//		RequestDispatcher rd;
//		rd = request.getRequestDispatcher("result.jsp");
//		rd.forward(request, response);
		
		response.sendRedirect("boardlist.do");
		//redirect : 주소창을 바꿈
		//forward : 주소창을 바꾸지 않음 . 요청과 응답이 다른 문서이다.
	}

}

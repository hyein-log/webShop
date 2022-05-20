package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board/boardDetail.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  s_board_id = request.getParameter("boardid");
		int i_board =0;
		if(s_board_id !=null) {
				i_board= Integer.parseInt(s_board_id);
		}
		BoardService boardService  = new BoardService();
		BoardVO board = boardService.selectByBno(i_board);
		request.setAttribute("board", board);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardDetail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

}

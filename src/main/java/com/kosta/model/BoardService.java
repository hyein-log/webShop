package com.kosta.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	public List<BoardEmpVO> selectallJoin() {
		return boardDAO.selectallJoin();
	}
	public List<BoardVO> select() {
		return boardDAO.select();
	}
	
	public BoardVO selectByBno(int bno) {
		return boardDAO.selectByBno(bno);
	}
	public List<BoardVO> selectByWriter(int writer) {
		return boardDAO.selectByWriter(writer);
	}
	public List<BoardVO> selectByTitle(String title) {
		return boardDAO.selectByTitle(title);
	}
	public List<BoardVO> selectByRegdate(Date sdate, Date edate) {
		return boardDAO.selectByRegdate(sdate, edate);
	}
	public int insert(BoardVO bvo) {
		return boardDAO.insert(bvo);
	}
	public int update(BoardVO bvo,int bno) {
		return boardDAO.update(bvo,bno);
	}
	public int delete(int bno) {
		return boardDAO.delete(bno);
	}
	
}

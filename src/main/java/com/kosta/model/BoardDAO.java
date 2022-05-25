package com.kosta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;
import com.kosta.util.DBUtil;

public class BoardDAO {
	static final String SQL_SELECT_ALL = "select * from tbl_board order by 1 desc";
	static final String SQL_SELECT_BYBNO = "select * from tbl_board where bno = ? order by 1";
	static final String SQL_SELECT_BYWRITER = "select * from tbl_board where writer = ? order by 1";
	static final String SQL_SELECT_BYTITLE = "select * from tbl_board where title like ? order by 1";
	static final String SQL_SELECT_BYREGDATE = "select * from tbl_board where regdate between ? and ? order by 1";
	static final String SQL_INSERT = "INSERT INTO tbl_board VALUES(seq_bno.nextval,?,?,?,sysdate,sysdate)";
	static final String SQL_UPDATE = "update tbl_board set title = ?, content =?, update_date = sysdate where  bno =?";
	static final String SQL_DELETE = "delete from tbl_board where bno = ?";
	static final String SQL_BOARDENP = "SELECT b.BNO , b.TITLE , b.CONTENT , e.FIRST_NAME ||e.LAST_NAME "
			+ " FROM TBL_BOARD b JOIN EMPLOYEES e on(b.writer = e.employee_id)";
	Connection conn;
	Statement st;
	PreparedStatement pst; // ���ε��������� [?]
	ResultSet rs;
	int result;

	public List<BoardEmpVO> selectallJoin() {
		List<BoardEmpVO> boardlist = new ArrayList<>();
		BoardEmpVO board = null;
		conn = DBUtil.getConnection(); //���ؼ�Ǯ���� �̿��ؼ� ���ؼ� ���
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_BOARDENP);
			while (rs.next()) {
				board = new BoardEmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				boardlist.add(board);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return boardlist;

	}

	public List<BoardVO> select() {
		List<BoardVO> boardlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);
			while (rs.next()) {
				boardlist.add(makeBoard(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return boardlist;

	}

	private BoardVO makeBoard(ResultSet rs) throws SQLException {
		BoardVO board = new BoardVO();
		board.setBno(rs.getInt("bno"));
		board.setContent(rs.getString("content"));
		board.setRegdate(rs.getDate("regdate"));
		board.setTitle(rs.getString("title"));
		board.setUpdate_date(rs.getDate("update_date"));
		board.setWriter(rs.getInt("writer"));

		return board;
	}

	public BoardVO selectByBno(int bno) {
		BoardVO board = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYBNO); // sql���� �̸� �غ�
			pst.setInt(1, bno); // ù��° ����ǥ�� deptid�� �ִ´�
			rs = pst.executeQuery(); // ������ �Ʊ� �־��༭ �� ���� �ʿ����

			while (rs.next()) {
				board = makeBoard(rs);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return board;
	}

	public List<BoardVO> selectByWriter(int writer) {
		List<BoardVO> boardlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYWRITER); // sql���� �̸� �غ�
			pst.setInt(1, writer); // ù��° ����ǥ�� deptid�� �ִ´�
			rs = pst.executeQuery(); // ������ �Ʊ� �־��༭ �� ���� �ʿ����

			while (rs.next()) {
				boardlist.add(makeBoard(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return boardlist;
	}

	public List<BoardVO> selectByTitle(String title) {
		List<BoardVO> boardlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYTITLE); // sql���� �̸� �غ�
			pst.setString(1, "%" + title + "%"); // ù��° ����ǥ�� deptid�� �ִ´�
			rs = pst.executeQuery(); // ������ �Ʊ� �־��༭ �� ���� �ʿ����

			while (rs.next()) {
				boardlist.add(makeBoard(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return boardlist;
	}

	public List<BoardVO> selectByRegdate(Date sdate, Date edate) {
		List<BoardVO> boardlist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYREGDATE); // sql���� �̸� �غ�
			pst.setDate(1, sdate); // ù��° ����ǥ�� deptid�� �ִ´�
			pst.setDate(2, edate); // ù��° ����ǥ�� deptid�� �ִ´�
			rs = pst.executeQuery(); // ������ �Ʊ� �־��༭ �� ���� �ʿ����

			while (rs.next()) {
				boardlist.add(makeBoard(rs));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}

		return boardlist;
	}

	public int insert(BoardVO bvo) {
		int result = 0;

		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT); // sql���� �̸� �غ�
			pst.setString(1, bvo.getTitle());
			pst.setString(2, bvo.getContent());
			pst.setInt(3, bvo.getWriter());

			result = pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

	public int update(BoardVO bvo, int bno) {
		int result = 0;

		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE); // sql���� �̸� �غ�
			pst.setString(1, bvo.getTitle());
			pst.setString(2, bvo.getContent());
			pst.setInt(3, bno);
			result = pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

	public int delete(int bno) {
		int result = 0;

		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE); // sql���� �̸� �غ�
			pst.setInt(1, bno);

			result = pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

}

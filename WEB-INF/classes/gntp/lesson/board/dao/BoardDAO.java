package gntp.lesson.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gntp.lesson.board.utils.ConnectionManagerV2;
import gntp.lesson.board.vo.BoardVO;

public class BoardDAO {
	public boolean insertItem(BoardVO board) throws SQLException {
		boolean flag = false;
		String sql = "insert into board(current_seq,title,content,next_seq,writer,user_id) values (?,?,?,?,?,?)";
		Connection con = ConnectionManagerV2.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getCurrentSeq());
		pstmt.setString(2, board.getTitle());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getNextSeq());
		pstmt.setString(5, board.getWriter());
		pstmt.setString(6, board.getUserId());
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount>0) {
			flag = true;
		}
		ResultSet rs = null;
		if(flag) {
			sql = "select max(seq) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int max = 0;
			if(rs.next()) {
				max = rs.getInt(1);
			}
			sql = "update board set write_seq = ? where seq = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, max);
			pstmt.setInt(2, max);
			pstmt.executeUpdate();
			//write_seq 생성
			System.out.println("write_seq 생성");
		}
		ConnectionManagerV2.closeConnection(rs, pstmt, con);
		return flag;
	}
	
	public ArrayList<BoardVO> selectAll() throws SQLException{
		ArrayList<BoardVO> list = null;
		String sql = "select * from board order by write_seq desc , current_seq asc";
		Connection con = ConnectionManagerV2.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		list = new ArrayList<BoardVO>();
		BoardVO board = null;
		while(rs.next()) {
			board = new BoardVO(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6),rs.getString(7),"user","user",rs.getTimestamp(8));
			list.add(board);
		}
		ConnectionManagerV2.closeConnection(rs, pstmt, con);
		return list;
	}

	public BoardVO selectBoard(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
}

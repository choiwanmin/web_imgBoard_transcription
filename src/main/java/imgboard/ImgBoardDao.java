package imgboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class ImgBoardDao {
	private DBConnect db;

	public ImgBoardDao() {
		db = DBConnect.getInstance();
	}

	public void insert(ImgBoard b) {
		Connection conn = db.conn();
		String sql = "insert into imgboard values(seq_imgboard.nextval,?,sysdate,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ImgBoard select(int num) {
		Connection conn = db.conn();
		String sql = "select * from imgboard where num=? order by num";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new ImgBoard(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<ImgBoard> selectAll() {
		Connection conn = db.conn();
		String sql = "select * from imgboard order by num";
		ArrayList<ImgBoard> list = new ArrayList<ImgBoard>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ImgBoard(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public void update(ImgBoard b) {
		Connection conn = db.conn();
		String sql = "update imgboard set title=?, content=? where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 수정됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete imgboard where num=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄 수정됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

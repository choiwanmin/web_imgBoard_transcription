package reps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class RepDao {
	private DBConnect db;

	public RepDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Rep r) {
		Connection conn = db.conn();
		String sql = "insert into reps values(seq_reps.nextval,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getWriter());
			pstmt.setString(2, r.getContent());
			pstmt.setInt(3, r.getImgBoardNum());
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

	public ArrayList<Rep> selectbyImgBoardNum(int ImgBoardNum) {
		Connection conn = db.conn();
		String sql = "select * from reps where imgboardnum=? order by num";
		ArrayList<Rep> list = new ArrayList<Rep>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ImgBoardNum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Rep(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
}

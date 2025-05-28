package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class roomInsertDAOImpl {

	public int insert(roomInsertDTO room) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "INSERT INTO roominsert VALUES (?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, room.getLodgment_num());
			pstmt.setString(2, room.getLodgment_name());
			pstmt.setString(3, room.getLodgment_state());
			pstmt.setInt(4, room.getLodgment_quantity());
			pstmt.setString(5, room.getLodgment_content().toString());

			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace(); // 예외 메시지 출력
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int update(String lodgment_state, String lodgment_content, int lodgment_num) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "update roominsert set lodgment_state = ?, lodgment_content = ? where lodgment_num = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lodgment_state);
			pstmt.setString(2, lodgment_content);
			pstmt.setInt(3, lodgment_num);
			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace(); // 예외 메시지 출력
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return 0;
	}

	public int delete(int lodgment_num) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "delete from roominsert where lodgment_num = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lodgment_num);
			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace(); // 예외 메시지 출력
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return 0;
	}

	public ArrayList<roomInsertDTO> select() {
    
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "select * from roominsert";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<roomInsertDTO> roomlist = new ArrayList();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
	            int num = rs.getInt("lodgment_num");
	            String name = rs.getString("lodgment_name");
	            String state = rs.getString("lodgment_state");
	            int quantity = rs.getInt("lodgment_quantity");
	            String content = rs.getString("lodgment_content");
	            roomInsertDTO room = new roomInsertDTO(num, name, state, quantity, content);
	            roomlist.add(room);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roomlist;
	}
	
	public roomInsertDTO selectNum(int lodgment_num) {
	    String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
	    String user = "shop";
	    String password = "shop";
	    String sql = "SELECT * FROM roominsert WHERE lodgment_num = ?";

	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, lodgment_num);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int num = rs.getInt("lodgment_num");
	            String name = rs.getString("lodgment_name");
	            String state = rs.getString("lodgment_state");
	            int quantity = rs.getInt("lodgment_quantity");
	            String content = rs.getString("lodgment_content");

	            return new roomInsertDTO(num, name, state, quantity, content);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return null;
	}
	public ArrayList<roomInsertDTO> selectName(String name) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		String sql = "SELECT * FROM roominsert WHERE lodgment_name LIKE ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<roomInsertDTO> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%"); // 부분 검색

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("lodgment_num");
				String lodgment_name = rs.getString("lodgment_name");
				String state = rs.getString("lodgment_state");
				int quantity = rs.getInt("lodgment_quantity");
				String content = rs.getString("lodgment_content");

				list.add(new roomInsertDTO(num, lodgment_name, state, quantity, content));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}	
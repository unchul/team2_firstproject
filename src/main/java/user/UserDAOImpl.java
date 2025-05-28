package main.java.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.common.JDBCTemplate;

public class UserDAOImpl {
	public int insert(UserDTO user) {
		String sql = "insert into users (user_id, user_pass, user_name, user_addr, phon_number, user_state) values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = JDBCTemplate.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getUserId());
			ptmt.setString(2, user.getUserPass());
			ptmt.setString(3, user.getUserName());
			ptmt.setString(4, user.getUserAddr());
			ptmt.setString(5, user.getPhonNumber());
			ptmt.setString(6, user.getUserState());
			
			result = ptmt.executeUpdate();
		}catch(SQLException e) {
            e.printStackTrace();
		}finally {
			JDBCTemplate.close(null, ptmt, con);
        }
		return result;
	}
	public boolean isUserIdExists(String userId) {
	    String sql = "SELECT 1 FROM users WHERE user_id = ?";
	    try (Connection con = JDBCTemplate.getConnection();
	         PreparedStatement ptmt = con.prepareStatement(sql)) {
	        ptmt.setString(1, userId);
	        try (ResultSet rs = ptmt.executeQuery()) {
	            return rs.next(); // true = 중복 있음
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean isPhoneExists(String phoneNumber) {
	    String sql = "SELECT 1 FROM users WHERE phon_number = ?";
	    try (Connection con = JDBCTemplate.getConnection();
	         PreparedStatement ptmt = con.prepareStatement(sql)) {
	        ptmt.setString(1, phoneNumber);
	        try (ResultSet rs = ptmt.executeQuery()) {
	            return rs.next();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public UserDTO login(String userId, String userPass) {
		String sql = "select * from users where user_id=? and user_pass=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		UserDTO user = null;
		try {
            con = JDBCTemplate.getConnection();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, userId);
			ptmt.setString(2, userPass);
			rs = ptmt.executeQuery();
			if(rs.next()){
				user=  new UserDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5), rs.getString(6));
				user.setUserState(rs.getString("user_state"));
				 user.setUserNum(rs.getInt("user_num")); 
				 user.setUserId(rs.getString("user_id"));
				 //로그인 세션 저장
				 LoginSession.loginUserState = user.getUserState();
		            LoginSession.loggedInUserNum = user.getUserNum();
		            LoginSession.loginUserId = user.getUserId();
		            LoginSession.isLoggedIn = true;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, ptmt, con);
		}
		return user;
	}
	public int update(UserDTO user) {
	    StringBuffer sql = new StringBuffer();
	    sql.append("update users SET user_pass=? where user_id=?");
	    Connection con = null;
	    PreparedStatement ptmt = null;
	    int result = 0;

	    try {
	        con = JDBCTemplate.getConnection();
	        ptmt = con.prepareStatement(sql.toString());
	        ptmt.setString(1, user.getUserPass());
	        ptmt.setString(2, user.getUserId());
	        result = ptmt.executeUpdate();
	        System.out.println(result + "값 수정성공!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCTemplate.close(null, ptmt, con);
	    }

	    return result;
	}
	public int delete(UserDTO user) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from users where user_id=?");
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
			try {
	            con = JDBCTemplate.getConnection();
				ptmt = con.prepareStatement(sql.toString());
				ptmt.setString(1,user.getUserId());
				result = ptmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(null, ptmt, con);
			}
	        return result;

	}
	public UserDTO findById(String userId) {
	    String sql = "select * from users where user_id = ?";
	    UserDTO user = null;

	    try (Connection con = JDBCTemplate.getConnection();
	         PreparedStatement ptmt = con.prepareStatement(sql)) {

	        ptmt.setString(1, userId);
	        try (ResultSet rs = ptmt.executeQuery()) {
	            if (rs.next()) {
	                user = new UserDTO(
	                    rs.getString("user_id"),
	                    rs.getString("user_pass"),
	                    rs.getString("user_name"),
	                    rs.getString("user_addr"),
	                    rs.getString("phon_number"),
	                    rs.getString("user_state")
	                );
	                user.setUserNum(rs.getInt("user_num"));
	                user.setUserId(rs.getString("user_id"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}
	

}

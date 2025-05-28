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
	public UserDTO login(String userId, String userPass) {
		String sql = "select * from users where id=? and pass=?";
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
				//변환된 DTO를 ArrayList에 저장
				System.out.println(user);

			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs, ptmt, con);
		}
		return user;
	}
	

}

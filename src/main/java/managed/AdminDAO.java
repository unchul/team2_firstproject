package main.java.managed;

import java.sql.*;

public class AdminDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean login(String id, String pw) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM admin WHERE admin_id = ? AND admin_pw = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();

            result = rs.next(); // 결과가 있으면 로그인 성공

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }
}
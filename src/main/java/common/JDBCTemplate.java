package main.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 드라이버로딩
	// => 클래스가 로딩될때 한번 실행
	static {
		System.out.println();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// DB서버 접속하기
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://192.168.0.27:3306/travel?serverTimezone=UTC";
		String user = "shop";
		String password = "shop";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	// 자원반납
	public static void close(ResultSet rs, Statement ptmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (ptmt != null)
				ptmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package main.java.reservation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/reservation_system?serverTimezone=Asia/Seoul";
            String user = "root"; // 너의 DB 계정
            String password = "1234"; // 너의 비밀번호

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


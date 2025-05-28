package mini;

public class TestMySQLDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 못 찾음: " + e.getMessage());
        }
    }
}
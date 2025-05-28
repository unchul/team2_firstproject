// ReservationDAO.java
package main.java.reservation;

import java.sql.*;

public class ReservationDAO {
    public void selectAll() {
        String sql = "SELECT * FROM reservation";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                    rs.getInt("reservation_key") + " | " +
                    rs.getInt("user_num") + " | " +
                    rs.getInt("lodging_num") + " | " +
                    rs.getString("lodging_room") + " | " +
                    rs.getDate("reservation_date") + " | " +
                    rs.getInt("guest") + "명" + " | " +
                    rs.getInt("reservation_period") + "박"

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByUserNum(int userNum) {
        String sql = "SELECT * FROM reservation WHERE user_num = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userNum);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("reservation_key") + " | " +
                    rs.getInt("user_num") + " | " +
                    rs.getInt("lodging_num") + " | " +
                    rs.getString("lodging_room") + " | " +
                    rs.getDate("reservation_date") + " | " +
                    rs.getInt("guest") + "명" + " | " +
                    rs.getInt("reservation_period") + "박"
                );
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(int reservationKey, Reservation r) {
        String sql = "INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_num, guest, reservation_period) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, reservationKey);
            pstmt.setInt(2, r.getLodgingNum());
            pstmt.setString(3, r.getLodgingRoom());
            pstmt.setString(4, r.getReservationDate());
            pstmt.setInt(5, r.getUserNum());
            pstmt.setInt(6, r.getGuest());
            pstmt.setInt(7, r.getReservationPeriod());

            int result = pstmt.executeUpdate();
            System.out.println(result + "건 예약 등록됨");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNextReservationKey() {
        String sql = "SELECT MAX(reservation_key) FROM reservation";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void update(int reservationKey, String newDate, int newGuest, int userNum, boolean isAdmin) {
        String sql = isAdmin ?
            "UPDATE reservation SET reservation_date = ?, guest = ? WHERE reservation_key = ?" :
            "UPDATE reservation SET reservation_date = ?, guest = ? WHERE reservation_key = ? AND user_num = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newDate);
            pstmt.setInt(2, newGuest);
            pstmt.setInt(3, reservationKey);
            if (!isAdmin) pstmt.setInt(4, userNum);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("예약 정보가 수정되었습니다.");
            else System.out.println("예약 수정 실패 (권한 없음 또는 예약 없음)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int reservationKey, int userNum, boolean isAdmin) {
        String sql = isAdmin ?
            "DELETE FROM reservation WHERE reservation_key = ?" :
            "DELETE FROM reservation WHERE reservation_key = ? AND user_num = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, reservationKey);
            if (!isAdmin) pstmt.setInt(2, userNum);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("예약이 삭제되었습니다.");
            else System.out.println("예약 삭제 실패 (권한 없음 또는 예약 없음)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 

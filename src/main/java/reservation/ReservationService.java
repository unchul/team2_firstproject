// ReservationService.java
package main.java.reservation;

import java.sql.*;
import java.util.Scanner;

public class ReservationService {
    private final ReservationDAO dao = new ReservationDAO();
    private int currentUserNum; // 로그인한 사용자 ID 보관


    public void setCurrentUserNum(int userNum) {
        this.currentUserNum = userNum;
    }

    public void selectAll() {
        dao.selectAll();
    }

    public void selectMyReservations() {
        dao.selectByUserNum(currentUserNum);
    }

    public void insertReservation(Scanner sc) {
        int newKey = dao.getNextReservationKey();

        System.out.print("숙소번호: ");
        int lodgingNum = sc.nextInt();
        sc.nextLine();

        System.out.print("룸 번호(예: 숙소번호_01): ");
        String room = sc.nextLine();

        System.out.print("예약일 (yyyy-mm-dd): ");
        String date = sc.nextLine();

        System.out.print("인원 수: ");
        int guest = sc.nextInt();

        System.out.print("숙박 기간 (박 수): ");
        int period = sc.nextInt();

        Reservation r = new Reservation(lodgingNum, room, date, currentUserNum, guest, period);
        dao.insert(newKey, r);
    }

    public void updateReservation(Scanner sc, boolean isAdmin) {
        System.out.print("수정할 예약 번호 입력: ");
        int resKey = sc.nextInt();
        sc.nextLine();

        System.out.print("예약일 변경 (yyyy-mm-dd): ");
        String newDate = sc.nextLine();

        System.out.print("인원 수 변경: ");
        int newGuest = sc.nextInt();

        dao.update(resKey, newDate, newGuest, currentUserNum, isAdmin);
    }

    public void deleteReservation(Scanner sc, boolean isAdmin) {
        System.out.print("취소할 예약 번호 입력: ");
        int resKey = sc.nextInt();

        dao.delete(resKey, currentUserNum, isAdmin);
    }
} 

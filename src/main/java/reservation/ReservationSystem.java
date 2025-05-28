// Main.java
package main.java.reservation;

import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationService service = new ReservationService();

        // 로그인 처리 - 테스트용으로 userId 수동 입력 (나중에 로그인 시스템 연결 예정)
        System.out.print("userId 입력 > ");
        int userId = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        
        
        /// 여기로 수정!! userId 넘겨받는것만 추가 수정하고, userId 선언 시 static이어야 함
        // int userId = Login.loginUser.getUserId();

        

        service.setCurrentUserId(userId);
        boolean isAdmin = (userId == 0000);

        if (isAdmin) {
            System.out.println("\n=== 관리자 예약 시스템 ===");
        } else {
            System.out.println("\n=== 사용자 예약 시스템 ===");
        }

        while (true) {
            System.out.println("\n1. 예약 조회");
            System.out.println("2. 예약 추가");
            System.out.println("3. 예약 수정");
            System.out.println("4. 예약 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택 > ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	System.out.println("\n[예약번호 | 유저id | 숙소코드 | 룸번호 | 예약일 | 투숙인원 | 기간]");
                	System.out.println("-------------------------------------------------");

                    if (isAdmin) service.selectAll();
                    else service.selectMyReservations();
                    break;
                case 2:
                    service.insertReservation(sc);
                    break;
                case 3:
                    service.updateReservation(sc, isAdmin);
                    break;
                case 4:
                    service.deleteReservation(sc, isAdmin);
                    break;
                case 0:
                    System.out.println("시스템 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

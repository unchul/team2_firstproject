package main.java;

import java.util.Scanner;

import main.java.managed.RoomInsertSystem;
import main.java.reservation.ReservationSystem;
import main.java.select.BookingSystem;
import main.java.user.UserSystem;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("======= 메인 메뉴 =======");
            System.out.println("1. 회원 시스템 (로그인/회원가입)");
            System.out.println("2. 예약 시스템");
            System.out.println("3. 숙소 조회 시스템");
            System.out.println("4. 숙소 관리자 시스템");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = sc.nextInt();
            sc.nextLine(); // 개행 제거

            switch (choice) {
                case 1:
                    UserSystem.main(args); // UserSystem 진입
                    break;
                case 2:
                    ReservationSystem.main(args); // ReservationSystem 진입
                    break;
                case 3:
                    BookingSystem.main(args); // BookingSystem 진입
                    break;
                case 4:
                    RoomInsertSystem.main(args); // BookingSystem 진입
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }

            // 잠깐 대기 후 줄바꿈
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n============================\n");
        }
    }
}

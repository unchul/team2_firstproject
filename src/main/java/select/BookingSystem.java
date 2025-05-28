package main.java.select;

import java.util.Scanner;

public class BookingSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);

        while (true) {
            System.out.println("****** 숙박 조회 시스템 ********");
            System.out.println("1. 숙소 검색");
            System.out.println("2. 숙소 상세 검색");
            System.out.println("3. 지역으로 검색");
            System.out.println("4. 숙소 등급으로 검색");
            System.out.println("5. 숙박업소 종류별 조회");
            System.out.println("0. 메인 메뉴로 돌아가기");
            System.out.print("원하는 작업을 선택하세요: ");

            int choice = key.nextInt();

            if (choice == 0) {
                System.out.println("메인 메뉴로 돌아갑니다.\n");
                break; 
            }
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n============================\n");

            show(choice);
            System.out.println();
        }
    }

	public static void show(int choice) {
		MenuController ui = new MenuController();
		switch (choice) {
		case 1:
			ui.selectAccomodation();
			break;
		case 2:
			ui.detailAccomodation();
			break;
		case 3:
			ui.selectLocation();
			break;
		case 4:
			ui.selectGrade();
			break;
		case 5:
			ui.selectType();
			break;
		}
	}
}

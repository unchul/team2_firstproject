package main.java.user;

import java.util.Scanner;

public class UserSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		MenuController ui = new MenuController();

		while (true) {
			System.out.println("******로그인/회원가입********");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 예약내역확인");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원정보수정");
			System.out.println("6. 회원탈퇴");
            System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("원하는 작업을 선택하세요: ");

			int choice = key.nextInt();

			if (choice == 0) {
                System.out.println("메인 메뉴로 돌아갑니다...");
                break;
            }

			show(choice, ui);
			try {
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n============================\n");
		}
	}

	public static void show(int choice, MenuController ui) {
		switch (choice) {
			case 1:
				ui.insertMenu();
				break;
			case 2:
				ui.loginMenu();
				break;
			case 3:
				// 로그인된 상태에서만 허용
				if (LoginSession.isLoggedIn) {
					// ui.showReservation(); // 아직 구현 안 되었음
				} else {
					System.out.println("먼저 로그인 해주세요.");
				}
				break;
			case 4:
				ui.logout();
				break;
			case 5:
				ui.updateMenu();
				break;
			case 6:
				ui.deleteMenu();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
		}
	}
}

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
			System.out.println("3. 로그아웃");
			System.out.println("4. 회원정보수정");
			System.out.println("5. 회원탈퇴");
            System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("원하는 작업을 선택하세요: ");

			int choice = key.nextInt();

			if (choice == 0) {
                System.out.println("메인 메뉴로 돌아갑니다...");
                break;
            }

			show(choice, ui);
			try {
                Thread.sleep(1000); 
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
				ui.logout();
				break;
			case 4:
				ui.updateMenu();
				break;
			case 5:
				ui.deleteMenu();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
		}
	}
}

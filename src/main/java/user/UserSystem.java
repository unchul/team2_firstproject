package main.java.user;

import java.util.Scanner;

public class UserSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******로그인/회원가입********");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 예약내역확인");
		System.out.println("4. 로그아웃");
		System.out.println("5. 회원정보수정");
		System.out.println("6. 회원탈퇴");
		System.out.print("원하는 작업을 선택하세요:");
		int choice = key.nextInt();
		show(choice);
	}

	public static void show(int choice) {
		MenuController ui = new MenuController();
		switch (choice) {
		case 1:
			ui.insertMenu();
			break;
		case 2:
			ui.loginMenu();
			break;
//		case 3:
//			ui.showReservation();
//			break;
//		case 4:
//			ui.logout();
//			break;
//		case 5:
//			ui.updateMenu();
//			break;
//		case 6:
//			ui.deleteMenu();
//			break;
		}
	}

}

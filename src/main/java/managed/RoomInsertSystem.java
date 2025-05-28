package main.java.managed;

//숙소(primary) lodgment_num,
//숙소(숙소이름) lodgment_name, 
//숙소 운영(운영여부상태) lodgment_state,
//숙소남은방(남은객실수) lodgment_quantity,
//숙소소개글 //lodgment_content
import java.util.Scanner;

public class RoomInsertSystem {
	public static void main(String[] args) {
		if (!"관리자".equals(main.java.user.LoginSession.loginUserState)) {
			System.out.println("=========================");
			System.out.println("접근 권한이 없습니다. 관리자에게 문의하세요.");
			System.out.println("=========================");
			return;
		}

		Scanner key = new Scanner(System.in);
		while(true) {
			System.out.println("*****숙소관리시스템*****");
			System.out.println("1. 숙소 등록");
			System.out.println("2. 숙소 수정");
			System.out.println("3. 숙소 삭제");
			System.out.println("4. 숙소 전체페이지");
			System.out.println("5. 숙소 검색(코드)");
			System.out.println("6. 숙소 검색(이름)");
			System.out.println("0. 메인 메뉴로 돌아가기");
			System.out.print("원하는 작업을 선택하세요: ");
			int choice = key.nextInt();
			if (choice == 0) {
                System.out.println("메인 메뉴로 돌아갑니다...");
                break;
            }
			show(choice);
			try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n============================\n");
	
	}
	}

	public static void show(int choice) {
		RoomInsertMenu ui = new RoomInsertMenu();
		switch (choice) {
		case 1 -> ui.insertMenu();
		case 2 -> ui.updateMenu();
		case 3 -> ui.deleteMenu();
		case 4 -> ui.selectMenu();
		case 5 -> ui.selectNum();
		case 6 -> ui.selectName();
		default -> System.out.println("잘못된 선택입니다.");
		}
	}
}
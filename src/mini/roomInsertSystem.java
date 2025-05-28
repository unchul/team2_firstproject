package mini;

//숙소(primary) lodgment_num,
//숙소(숙소이름) lodgment_name, 
//숙소 운영(운영여부상태) lodgment_state,
//숙소남은방(남은객실수) lodgment_quantity,
//숙소소개글 //lodgment_content
import java.util.Scanner;

public class roomInsertSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);

		System.out.print("관리자 ID를 입력하세요: ");
		String adminId = key.nextLine();
		System.out.print("관리자 비밀번호를 입력하세요: ");
		String adminPw = key.nextLine();

		if (login(adminId, adminPw)) {
			System.out.println("*****숙소관리시스템*****");
			System.out.println("1. 숙소 등록");
			System.out.println("2. 숙소 수정");
			System.out.println("3. 숙소 삭제");
			System.out.println("4. 숙소 전체페이지");
			System.out.println("5. 숙소 검색(코드)");
			System.out.println("6. 숙소 검색(이름)");

			System.out.print("원하는 작업을 선택하세요: ");
			int choice = key.nextInt();
			show(choice);
		} else {
			System.out.println("=========================");
			System.out.println("접근 권한이 없습니다. 관리자에게 문의하여 주시기 바랍니다.");
			System.out.println("=========================");
		}
	}

	public static boolean login(String id, String pw) {
		String admin_id = "admin";
		String admin_pw = "1234";
		return admin_id.equals(id) && admin_pw.equals(pw);
	}

	public static void show(int choice) {
		roomInsertMenu ui = new roomInsertMenu();
		switch (choice) {
		case 1:
			ui.insertMenu();
			break;
		case 2:
			ui.updateMenu();
			break;
		case 3:
			ui.deleteMenu();
			break;
		case 4:
			ui.selectMenu();
			break;
		case 5:
			ui.selectNum();
			break;
		case 6:
			ui.selectName();
			break;
		}
	}
}
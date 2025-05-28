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
		System.out.println("*****숙박시스템*****");
		System.out.println("1. 숙소 등록");
		System.out.println("2. 숙소 수정");
		System.out.println("3. 숙소 삭제");
		System.out.println("4. 숙소 전체페이지");
		System.out.println("5. 숙소 검색(코드)");
		System.out.println("6. 숙소 검색(이름)");
		
		System.out.print("원하는 작업을 선택하세요: ");
		int choice = key.nextInt();
		show(choice);
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
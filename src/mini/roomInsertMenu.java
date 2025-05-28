package mini;
//숙소(primary) lodgment_num,
//숙소(숙소이름) lodgment_name, 
//숙소 운영(운영여부상태) lodgment_state,
//숙소남은방(남은객실수) lodgment_quantity,
//숙소소개글 //lodgment_content
import java.util.ArrayList;
import java.util.Scanner;
public class roomInsertMenu {
	Scanner key = new Scanner(System.in);
	roomInsertDAOImpl dao = new roomInsertDAOImpl();

	public void insertMenu() {
		System.out.println("****숙소등록****");
		System.out.print("숙소코드: ");
		int lodgment_num = key.nextInt();
		key.nextLine();
		
		System.out.print("숙소이름: ");
		String lodgment_name = key.nextLine();
		
		System.out.print("숙소운영상태: ");
		String lodgment_state = key.nextLine();
		
		System.out.print("숙소소개글: ");
		String lodgment_content = key.nextLine();
		
		roomInsertDTO room = new roomInsertDTO(lodgment_num, lodgment_name, lodgment_state, lodgment_content);
		int result = dao.insert(room);
		if (result >= 1) {
			System.out.println("=========================");
			System.out.println("등록성공");
			System.out.println("=========================");
		} else {
			System.out.println("--------------------------");
			System.out.println("재등록바랍니다.");
			System.out.println("--------------------------");
		}
	}

	public void updateMenu() {
		System.out.println("**숙소정보수정**");
		System.out.print("숙소상태: ");
		String lodgment_state = key.nextLine();
		
		System.out.print("숙소소개글: ");
		String lodgment_content = key.nextLine();
		
		System.out.print("숙소코드: ");
		int lodgment_num = key.nextInt();
		
		int result = dao.update(lodgment_state, lodgment_content, lodgment_num);
		if (result >= 1) {
			System.out.println("=========================");
			System.out.println("수정성공");
			System.out.println("=========================");
		} else {
			System.out.println("=========================");
			System.out.println("재수정하기 바랍니다.");
			System.out.println("=========================");
		}

	}

	public void deleteMenu() {
		System.out.println("***숙소정보삭제***");
		System.out.print("삭제할 숙소코드: ");
		int lodgment_num = key.nextInt();
		
		int result = dao.delete(lodgment_num);
		if (result >= 1) {
			System.out.println("=========================");
			System.out.println("삭제성공");
			System.out.println("=========================");
		} else {
			System.out.println("=========================");
			System.out.println("재삭제하기 바랍니다.");
			System.out.println("=========================");
		}
	}

	public void selectMenu() {
		System.out.println("***숙소전체조회***");
		System.out.println("==============================");
		ArrayList<roomInsertDTO> list = dao.select();

		for (roomInsertDTO room : list) {
			System.out.println("숙소코드: " + room.getLodgment_num());
			System.out.println("숙소명: " + room.getLodgment_name());
			System.out.println("숙소상태: " + room.getLodgment_state());
			System.out.println("남은객실수: " + room.getLodgment_quantity());
			System.out.println("숙소소개글: " + room.getLodgment_content());
			System.out.println("==============================");
		}
	}

	public void selectNum() {
		System.out.print("조회할 숙소코드를 입력하세요: ");
		int lodgment_num = key.nextInt();

		roomInsertDTO room = dao.selectNum(lodgment_num);

		if (room != null) {
			System.out.println("==============================");
			System.out.println("숙소코드     : " + room.getLodgment_num());
			System.out.println("숙소명       : " + room.getLodgment_name());
			System.out.println("숙소상태     : " + room.getLodgment_state());
			System.out.println("남은객실수   : " + room.getLodgment_quantity());
			System.out.println("숙소소개글   : " + room.getLodgment_content());
			System.out.println("==============================");
		} else {
			System.out.println("==============================");
			System.out.println("해당 숙소코드를 가진 숙소가 없습니다.");
			System.out.println("==============================");
		}
	}
	public void selectName() {
	    System.out.print("검색할 숙소명을 입력하세요: ");
	    String name = key.next();

	    ArrayList<roomInsertDTO> list = dao.selectName(name);

	    if (list.isEmpty()) {
			System.out.println("==============================");
	        System.out.println("해당 이름을 포함하는 숙소가 없습니다.");
			System.out.println("==============================");
	    } else {
	        for (roomInsertDTO room : list) {
	            System.out.println("==============================");
	            System.out.println("숙소코드     : " + room.getLodgment_num());
	            System.out.println("숙소명       : " + room.getLodgment_name());
	            System.out.println("숙소상태     : " + room.getLodgment_state());
	            System.out.println("남은객실수   : " + room.getLodgment_quantity());
	            System.out.println("숙소소개글   : " + room.getLodgment_content());
	        }
	        System.out.println("==============================");
	    }
	}
}

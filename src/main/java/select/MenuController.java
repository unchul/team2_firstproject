package main.java.select;  

import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {

	BookingDAOImple dao = new BookingDAOImple();

	// 1. 숙박업소 전체 리스트 조회
	// 숙소 이름, 숙소 종류, 숙소 위치, 객실수, 숙소 등급, 숙소 설명
	public void selectAccomodation() {
		System.out.println("\n******* 숙박업소 전체 리스트 조회 ********");
		ArrayList<BookingDTO> list = dao.select();
		if(list.isEmpty()) {
			System.out.println("조회된 숙소가 없습니다.");
		}
		for (BookingDTO lodging : list) {
			System.out.println("숙소 이름: " + lodging.getLodging_name());
			System.out.println("숙소 종류: " + lodging.getLodging_type());
			System.out.println("숙소 위치: " + lodging.getLodging_location());
			System.out.println("객실수: " + lodging.getLodging_quantity());
			System.out.println("숙소 등급: " + lodging.getLodging_grade());
			System.out.println("숙소 설명: " + lodging.getLodging_content()); 
			System.out.println("=====================================");
		}
	}

	// 2. 숙박 업소 상세 페이지 조회용
	// 숙소 ID, 숙소 이름, 룸 타입, 예약 가능 여부, 가격, 흡연 가능 여부, 최대 수용 인원, 와이파이 사용 가능 여부
	public void detailAccomodation() {
		Scanner key = new Scanner(System.in);
		System.out.print("검색할 숙소 이름을 입력하세요: ");
		String line = key.nextLine().trim();
		
		System.out.println("\n******* 숙박업소 상세 페이지 ********");
		ArrayList<BookingDTO> list = dao.details(line);
		
		if (list.isEmpty()) {
			System.out.println("해당 이름의 숙소가 없습니다.");
		}
		
		for (BookingDTO lodging : list) {
			System.out.println("숙소 ID: " + lodging.getLodging_num());
			System.out.println("숙소 이름: " + lodging.getLodging_name());
			System.out.println("룸 타입: " + lodging.getLodging_roomtype());
			System.out.println("예약 가능 여부: " + (lodging.isLodging_state() ? "가능" : "불가능")); 
			System.out.println("가격: " + lodging.getCharge());
			System.out.println("흡연 가능 여부: " + (lodging.isLodging_smokingState() ? "흡연 가능" : "금연")); 
			System.out.println("최대 수용 인원: " + lodging.getLodging_maxGuests());
			System.out.println("와이파이: " + (lodging.isLodging_hasWifi() ? "제공" : "미제공")); 
			System.out.println("=====================================");
		}
	}

	// 숙박업소 카테고리별 조회(지역별 조회)
	public void selectLocation() {
		
		Scanner key = new Scanner(System.in);
		System.out.print("검색할 지역명을 입력하세요: ");
		String location = key.nextLine().trim();
		
		System.out.println("\n******* 지역별 숙박업소 조회 ********");
		ArrayList<BookingDTO> list = dao.searchLoc(location);
		
		if (list.isEmpty()) {
			System.out.println("해당 지역의 숙소가 없습니다.");
		}
		
		for (BookingDTO lodging : list) {
			printBasicInfo(lodging);
		}
	}

	// 숙박업소 카테고리별 조회(등급별 조회)
	public void selectGrade() {
		Scanner key = new Scanner(System.in);
		System.out.println("\n******* 등급별 숙박업소 조회 *******");
		System.out.println("[3] 3성급 숙소");
		System.out.println("[4] 4성급 숙소");
		System.out.println("[5] 5성급 숙소");
		
		int grade;
		while (true) {
			System.out.print("숙소 등급을 입력하세요(3~5): ");
			if (key.hasNextInt()) {
				grade = key.nextInt();
				key.nextLine();
				if (grade >= 3 && grade <= 5) break;
			} else {
				key.nextLine();
			}
			System.out.println("[안내] 3~5 사이의 숫자를 입력해 주세요.");
		}

		ArrayList<BookingDTO> list = dao.searchGrade(grade);

		if (list.isEmpty()) {
			System.out.println(grade + "성급 숙소가 없습니다.");
		}

		for (BookingDTO lodging : list) {
			printBasicInfo(lodging);
		}
	}

	// 숙박업소 카테고리별 조회(종류별 조회)
	public void selectType() {
		Scanner key = new Scanner(System.in);
		System.out.println("\n******* 숙박업소 종류별 조회 ********");
		System.out.println("1. 호텔");
		System.out.println("2. 펜션");
		System.out.println("3. 민박");
		System.out.println("4. 레지던스");
		System.out.println("5. 게스트하우스");
		
		int choice;		
		while (true) {
			System.out.print("숙소 종류를 선택하세요(1~5): ");
			if (key.hasNextInt()) {
				choice = key.nextInt();
				key.nextLine();
				if (choice >= 1 && choice <= 5) break;
			} else {
				key.nextLine();
			}
			System.out.println("[안내] 1~5 사이의 숫자를 입력해 주세요.");
		}
		
//		수정 작업 구간
		String line = "";
		switch(choice){
		case 1:
			line = "호텔";
			break;
		case 2:
			line = "펜션";
			break;
		case 3:
			line = "민박";
			break;
		case 4:
			line = "레지던스";
			break;
		case 5:
			line = "게스트하우스";
			break;
		}

		ArrayList<BookingDTO> list = dao.searchType(line);
		
		if (list.isEmpty()) {
			System.out.println("해당 종류의 숙소가 없습니다.");
		}

		for (BookingDTO lodging : list) {
			printBasicInfo(lodging);
		}
	}
	
	public void printBasicInfo(BookingDTO lodging) {
		System.out.println("숙소 ID: " + lodging.getLodging_num());
		System.out.println("숙소 이름: " + lodging.getLodging_name());
		System.out.println("룸 타입: " + lodging.getLodging_roomtype());
		System.out.println("예약 가능 여부: " + (lodging.isLodging_state() ? "가능" : "불가능")); 
		System.out.println("가격: " + lodging.getCharge());
		System.out.println("흡연 가능 여부: " + (lodging.isLodging_smokingState() ? "흡연 가능" : "금연")); 
		System.out.println("최대 수용 인원: " + lodging.getLodging_maxGuests());
		System.out.println("와이파이: " + (lodging.isLodging_hasWifi() ? "제공" : "미제공")); 
		System.out.println("=====================================");
	} 
	
}

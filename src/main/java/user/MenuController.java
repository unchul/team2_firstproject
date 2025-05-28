package main.java.user;

import java.util.Scanner;

public class MenuController {
	Scanner key = new Scanner(System.in);
	UserDAOImpl dao = new UserDAOImpl();
	
	public void insertMenu(){
		System.out.println("*******고객등록********");
		System.out.print("아이디:");
		String userId = key.next();
		System.out.print("패스워드:");
		String userPass = key.next();
		System.out.print("성명:");
		String userName = key.next();
		System.out.print("주소:");
		String userAddr = key.next();
		System.out.print("전화번호:");
		String phonNumber = key.next();
		System.out.print("관리자/사용자:");
		String userState = key.next();
		UserDTO user = new UserDTO(userId, userPass, userName, userAddr,phonNumber,userState);
		int result = dao.insert(user);
	}
	public void loginMenu() {
		System.out.println("*******로그인********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		UserDTO loginUser = dao.login(id, pass);
	
	//	로그인 성공하면 로그인성공!!메시지와 로그인한 사용자의 모든 정보를 출력(print호출)
		if(loginUser!=null) {
			System.out.println("로그인성공");
		}else {
			System.out.println("로그인실패");
		}
		//로그인 실패하면 로그인실패!!메시지를 출력
	}
}


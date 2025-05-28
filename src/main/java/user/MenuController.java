package main.java.user;

import java.util.Scanner;


public class MenuController {
	Scanner key = new Scanner(System.in);
	UserDAOImpl dao = new UserDAOImpl();

	public void insertMenu() {
		System.out.println("*******고객등록********");
		System.out.print("아이디: ");
		String userId = key.next();

		if (dao.isUserIdExists(userId)) {
		    System.out.println("이미 사용 중인 아이디입니다.");
		    return;
		}

		System.out.print("패스워드: ");
		String userPass = key.next();
		System.out.print("성명: ");
		String userName = key.next();
		System.out.print("주소: ");
		String userAddr = key.next();
		System.out.print("전화번호: ");
		String phonNumber = key.next();

		if (dao.isPhoneExists(phonNumber)) {
		    System.out.println("이미 등록된 전화번호입니다.");
		    return;
		}

		System.out.print("관리자/사용자: ");
		String userState = key.next();

		UserDTO user = new UserDTO(userId, userPass, userName, userAddr, phonNumber, userState);
		int result = dao.insert(user);

		if (result >= 1) {
		    System.out.println("=========================");
		    System.out.println("회원가입을 축하합니다");
		    System.out.println("=========================");
		} else {
		    System.out.println("--------------------------");
		    System.out.println("회원 가입 실패");
		    System.out.println("--------------------------");
		}
	}

	public void loginMenu() {
		if (LoginSession.isLoggedIn) {
	        System.out.println("이미 로그인된 상태입니다. 로그아웃 후 다시 시도해주세요.");
	        return;
	    }
		System.out.println("*******로그인********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		UserDTO loginUser = dao.login(id, pass);

		if (loginUser != null) {
			System.out.println("로그인성공");
			LoginSession.isLoggedIn = true;
	        LoginSession.loginUserId = loginUser.getUserId();
	        LoginSession.loginUserState = loginUser.getUserState();
	        LoginSession.isAdmin = "관리자".equals(loginUser.getUserState());
	        System.out.println(loginUser.getUserState());
		} else {
			System.out.println("로그인실패");
		}
	}

	public void updateMenu(){
		System.out.println("*******고객정보수정********");
		System.out.print("바꾸실비번:");
		String pass = key.next();
		System.out.print("아이디:");
		String id = key.next();
		UserDTO user = new UserDTO(id, pass);
		int result = dao.update(user);
		if(result>=1) {
			System.out.println("=========================");
			System.out.println("수정성공");
			System.out.println("=========================");
		}else {
			System.out.println("--------------------------");
			System.out.println("수정실패");
			System.out.println("--------------------------");
		}
	}

	public void deleteMenu() {
		 if (!LoginSession.isLoggedIn) {
		        System.out.println("로그인 후 이용 바랍니다.");
		        return;
		    }
		System.out.println("*******회원탈퇴********");
	    String loginId = LoginSession.loginUserId;
	    System.out.print("비밀번호를 다시 입력하세요: ");
	    String inputPass = key.next();
	    
	    UserDTO user = dao.findById(loginId);
	    
	    if (user != null && user.getUserPass().equals(inputPass)) {
	        // 비밀번호 일치 시 삭제
	        int result = dao.delete(user);
	        if (result >= 1) {
	            System.out.println("=========================");
	            System.out.println("회원 탈퇴가 완료되었습니다.");
	            System.out.println("=========================");
	            LoginSession.logout(); // 세션 초기화
	        } else {
	            System.out.println("--------------------------");
	            System.out.println("회원 탈퇴 중 오류가 발생했습니다.");
	            System.out.println("--------------------------");
	        }
	    } else {
	        System.out.println("비밀번호가 일치하지 않습니다.");
	    }
	}
	public void logout() {
	    if (LoginSession.isLoggedIn) {
	    	LoginSession.isAdmin = false;
	        LoginSession.loggedInUserNum = -1;
	        LoginSession.isLoggedIn = false;
	        LoginSession.loginUserId = null;
	        System.out.println("=========================");
	        System.out.println("로그아웃되었습니다.");
	        System.out.println("=========================");
	    } else {
	        System.out.println("현재 로그인 상태가 아닙니다.");
	    }
	}
}



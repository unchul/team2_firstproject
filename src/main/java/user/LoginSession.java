package main.java.user;

public class LoginSession {
	public static int loggedInUserNum = -1; // -1이면 로그인 안된 상태
	public static String loginUserId = null;
	public static boolean isLoggedIn = false;
    public static boolean isAdmin = false;
    public static String loginUserState = null;

    
    public static void logout() {
        isLoggedIn = false;
        loginUserId = null;
        loginUserState = null;
        isAdmin = false;
    }
}

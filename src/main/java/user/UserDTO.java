package main.java.user;

public class UserDTO {
	private int userNum;
	private String userId;
	private String userPass;
	private String userName;
	private String userAddr;
	private String phonNumber;
	private String userState;
	
	public UserDTO() {
		
	}

	public UserDTO(String userId) {
		super();
		this.userId = userId;
	}

	public UserDTO(String userId, String userPass) {
		super();
		this.userId = userId;
		this.userPass = userPass;
	}

	public UserDTO(String userId, String userPass, String userName, String userAddr, String phonNumber,
			String userState) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userAddr = userAddr;
		this.phonNumber = phonNumber;
		this.userState = userState;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getPhonNumber() {
		return phonNumber;
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "UserDTO [userNum=" + userNum + ", userId=" + userId + ", userPass=" + userPass + ", userName="
				+ userName + ", userAddr=" + userAddr + ", phonNumber=" + phonNumber + ", userState=" + userState + "]";
	}

	
	
}

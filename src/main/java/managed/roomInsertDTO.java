package main.java.managed;
//숙소(primary) lodgment_num,
//숙소(숙소이름) lodgment_name, 
//숙소 운영(운영여부상태) lodgment_state,
//숙소남은방(남은객실수) lodgment_quantity,
//숙소소개글 //lodgment_content
public class roomInsertDTO {

	private int lodgment_num;
	private String lodgment_name;
	private String lodgment_state;
	private int lodgment_quantity;
	private String lodgment_content;

	// insert용
	public roomInsertDTO(int lodgment_num, String lodgment_name, String lodgment_state, String lodgment_content) {
		super();
		this.lodgment_num = lodgment_num;
		this.lodgment_name = lodgment_name;
		this.lodgment_state = lodgment_state;
		this.lodgment_content = lodgment_content;
	}

	// select용
	public roomInsertDTO(int lodgment_num, String lodgment_name, String lodgment_state, int lodgment_quantity,
			String lodgment_content) {
		super();
		this.lodgment_num = lodgment_num;
		this.lodgment_name = lodgment_name;
		this.lodgment_state = lodgment_state;
		this.lodgment_quantity = lodgment_quantity;
		this.lodgment_content = lodgment_content;
	}

	public int getLodgment_num() {
		return lodgment_num;
	}

	public void setLodgment_num(int lodgment_num) {
		this.lodgment_num = lodgment_num;
	}

	public String getLodgment_name() {
		return lodgment_name;
	}

	public void setLodgment_name(String lodgment_name) {
		this.lodgment_name = lodgment_name;
	}

	public String getLodgment_state() {
		return lodgment_state;
	}

	public void setLodgment_state(String lodgment_state) {
		this.lodgment_state = lodgment_state;
	}

	public int getLodgment_quantity() {
		return lodgment_quantity;
	}

	public void setLodgment_quantity(int lodgment_quantity) {
		this.lodgment_quantity = lodgment_quantity;
	}

	public String getLodgment_content() {
		return lodgment_content;
	}

	public void setLodgment_content(String lodgment_content) {
		this.lodgment_content = lodgment_content;
	}

	@Override
	public String toString() {
		return "roomInsertDTO [lodgment_num=" + lodgment_num + ", lodgment_name=" + lodgment_name + ", lodgment_state="
				+ lodgment_state + ", lodgment_quantity=" + lodgment_quantity + ", lodgment_content=" + lodgment_content
				+ "]";
	}
}

package select;   

public class BookingDTO {

	private int lodging_num; // 숙소 ID
	private String lodging_location; // 지역
	private String lodging_name; // 숙소명
	private String lodging_type; // 숙소 유형
	private int lodging_quantity; // 객실 수
	private int lodging_grade; // 등급
	private String lodging_content; // 소개

	private String lodging_room; // 룸 ID
	private String lodging_roomtype; // 룸 타입
	private int charge; // 가격
	private boolean lodging_state; // 예약 가능 여부
	private boolean lodging_smokingState; // 흡연 가능 여부
	private int lodging_maxGuests; // 최대 수용 인원
	private boolean lodging_hasWifi; // 와이파이 여부

	public BookingDTO() {

	}

	// 숙박업소 전체 리스트 조회용
	// 숙소 이름, 숙소 종류, 숙소 위치, 객실수, 숙소 등급, 숙소 설명
	public BookingDTO(String lodging_name, String lodging_type, String lodging_location,  
			int lodging_quantity, int lodging_grade, String lodging_content) {
		this.lodging_num = lodging_num;
		this.lodging_location = lodging_location;
		this.lodging_name = lodging_name;
		this.lodging_type = lodging_type;
		this.lodging_quantity = lodging_quantity;
		this.lodging_grade = lodging_grade;
		this.lodging_content = lodging_content;
	}

	// 숙박 업소 상세 페이지 조회용
	// 숙소 ID, 숙소 이름, 룸 타입, 예약 가능 여부, 가격, 흡연 가능 여부, 최대 수용 인원, 와이파이 가능 여부
	public BookingDTO(int lodging_num, String lodging_name, String lodging_roomtype, boolean lodging_state, int charge,
			boolean lodging_smokingState, int lodging_maxGuests, boolean lodging_hasWifi) {
		this.lodging_num = lodging_num;
		this.lodging_name = lodging_name;
		this.lodging_roomtype = lodging_roomtype;
		this.lodging_state = lodging_state;
		this.charge = charge;
		this.lodging_smokingState = lodging_smokingState;
		this.lodging_maxGuests = lodging_maxGuests;
		this.lodging_hasWifi = lodging_hasWifi;
	}

	@Override
	public String toString() {
		return "BookingDTO [lodging_num=" + lodging_num + ", lodging_location=" + lodging_location + ", lodging_name="
				+ lodging_name + ", lodging_type=" + lodging_type + ", lodging_quantity=" + lodging_quantity
				+ ", lodging_grade=" + lodging_grade + "]";
	}

	// Getter/Setter들 (변경 없음)
    public int getLodging_num() {
        return lodging_num;
    }

    public void setLodging_num(int lodging_num) {
        this.lodging_num = lodging_num;
    }

    public String getLodging_location() {
        return lodging_location;
    }

    public void setLodging_location(String lodging_location) {
        this.lodging_location = lodging_location;
    }

    public String getLodging_name() {
        return lodging_name;
    }

    public void setLodging_name(String lodging_name) {
        this.lodging_name = lodging_name;
    }

    public String getLodging_type() {
        return lodging_type;
    }

    public void setLodging_type(String lodging_type) {
        this.lodging_type = lodging_type;
    }

    public int getLodging_quantity() {
        return lodging_quantity;
    }

    public void setLodging_quantity(int lodging_quantity) {
        this.lodging_quantity = lodging_quantity;
    }

    public int getLodging_grade() {
        return lodging_grade;
    }

    public void setLodging_grade(int lodging_grade) {
        this.lodging_grade = lodging_grade;
    }

    public String getLodging_content() {
        return lodging_content;
    }

    public void setLodging_content(String lodging_content) {
        this.lodging_content = lodging_content;
    }

    public String getLodging_room() {
        return lodging_room;
    }

    public void setLodging_room(String lodging_room) {
        this.lodging_room = lodging_room;
    }

    public String getLodging_roomtype() {
        return lodging_roomtype;
    }

    public void setLodging_roomtype(String lodging_roomtype) {
        this.lodging_roomtype = lodging_roomtype;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public boolean isLodging_state() {
        return lodging_state;
    }

    public void setLodging_state(boolean lodging_state) {
        this.lodging_state = lodging_state;
    }

    public boolean isLodging_smokingState() {
        return lodging_smokingState;
    }

    public void setLodging_smokingState(boolean lodging_smokingState) {
        this.lodging_smokingState = lodging_smokingState;
    }

    public int getLodging_maxGuests() {
        return lodging_maxGuests;
    }

    public void setLodging_maxGuests(int lodging_maxGuests) {
        this.lodging_maxGuests = lodging_maxGuests;
    }

    public boolean isLodging_hasWifi() {
        return lodging_hasWifi;
    }

    public void setLodging_hasWifi(boolean lodging_hasWifi) {
        this.lodging_hasWifi = lodging_hasWifi;
    }

}

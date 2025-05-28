// Reservation.java
package main.java.reservation;

public class Reservation {
    private int reservationKey;
    private int lodgingNum;
    private String lodgingRoom;
    private String reservationDate;
    private int userId;
    private int guest;
    private int reservationPeriod;


    // 생성자 (예약키 자동 관리용)
    public Reservation(int lodgingNum, String lodgingRoom, String reservationDate,
                       int userId, int guest, int reservationPeriod ) {
        this.lodgingNum = lodgingNum;
        this.lodgingRoom = lodgingRoom;
        this.reservationDate = reservationDate;
        this.userId = userId;
        this.guest = guest;
        this.reservationPeriod = reservationPeriod;

    }

    // 생성자 (전체 필드 포함)
    public Reservation(int reservationKey, int lodgingNum, String lodgingRoom, String reservationDate,
                       int userId, int guest, int reservationPeriod) {
        this.reservationKey = reservationKey;
        this.lodgingNum = lodgingNum;
        this.lodgingRoom = lodgingRoom;
        this.reservationDate = reservationDate;
        this.userId = userId;
        this.guest = guest;
        this.reservationPeriod = reservationPeriod;

    }

    public int getReservationKey() { return reservationKey; }
    public int getLodgingNum() { return lodgingNum; }
    public String getLodgingRoom() { return lodgingRoom; }
    public String getReservationDate() { return reservationDate; }
    public int getUserId() { return userId; }
    public int getGuest() { return guest; }
    public int getReservationPeriod() { return reservationPeriod; }

} 

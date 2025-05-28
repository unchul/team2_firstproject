package select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.customer.DBUtil;

public class BookingDAOImple {

	// 숙박업소 전체 리스트 조회
	// 레코드를 DTO로 변환해서 ArrayList에 담아서 리턴
	
	public ArrayList<BookingDTO> select() {
		String sql = "select * from accommodation";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<BookingDTO> acclist = new ArrayList<BookingDTO>();
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BookingDTO host = new BookingDTO(
						rs.getString("lodging_name"),
		            	rs.getString("lodging_type"),
		            	rs.getString("lodging_location"),
		            	rs.getInt("lodging_quantity"),
		            	rs.getInt("lodging_grade"),
		            	rs.getString("lodging_content"));
				acclist.add(host);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return acclist;
	}

	// 숙박 업소 상세 페이지 조회용
	// 숙소 ID, 숙소 이름, 룸 타입, 예약 가능 여부, 가격, 흡연 가능 여부, 최대 수용 인원, 와이파이 가능 여부
	public ArrayList<BookingDTO> details(String line) {
		String sql = "SELECT a.lodging_num, a.lodging_name, r.lodging_roomtype, r.lodging_state, r.lodging_charge, r.lodging_smokingState, r.lodging_maxGuests, r.lodging_hasWifi "
	               + "FROM accommodation a "
	               + "JOIN room r ON a.lodging_num = r.lodging_num "
	               + "WHERE a.lodging_name = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<BookingDTO> acclist = new ArrayList<BookingDTO>();
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, line);
			rs = stmt.executeQuery();
			while (rs.next()) {
	            
	            BookingDTO host = new BookingDTO(
	            	rs.getInt("lodging_num"),
	            	rs.getString("lodging_name"),
	            	rs.getString("lodging_roomtype"),
	            	rs.getBoolean("lodging_state"),
	            	rs.getInt("lodging_charge"),
	            	rs.getBoolean("lodging_smokingState"),
	            	rs.getInt("lodging_maxGuests"),
	            	rs.getBoolean("lodging_hasWifi")
	            );
	            acclist.add(host);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.close(rs, stmt, con);
	    }
	    return acclist;
	}

	// 숙박업소 카테고리별 조회(지역별 조회)
	public ArrayList<BookingDTO> searchLoc(String location) {
		String sql = "SELECT a.lodging_num, a.lodging_name, r.lodging_roomtype, r.lodging_state, r.lodging_charge, r.lodging_smokingState, r.lodging_maxGuests, r.lodging_hasWifi "
	               + "FROM accommodation a "
	               + "JOIN room r ON a.lodging_num = r.lodging_num "
	               + "WHERE a.lodging_location = ?";
				
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<BookingDTO> acclist = new ArrayList<BookingDTO>();
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, location);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BookingDTO host = new BookingDTO(
						rs.getInt("lodging_num"),
		            	rs.getString("lodging_name"),
		            	rs.getString("lodging_roomtype"),
		            	rs.getBoolean("lodging_state"),
		            	rs.getInt("lodging_charge"),
		            	rs.getBoolean("lodging_smokingState"),
		            	rs.getInt("lodging_maxGuests"),
		            	rs.getBoolean("lodging_hasWifi")
						);
				acclist.add(host);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return acclist;
	}
	
	// 숙박업소 카테고리별 조회(등급별 조회)
	public ArrayList<BookingDTO> searchGrade(int choice) {
		
		String sql = "SELECT a.lodging_num, a.lodging_name, r.lodging_roomtype, r.lodging_state, r.lodging_charge, r.lodging_smokingState, r.lodging_maxGuests, r.lodging_hasWifi "
	               + "FROM accommodation a "
	               + "JOIN room r ON a.lodging_num = r.lodging_num "
	               + "WHERE a.lodging_grade = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<BookingDTO> acclist = new ArrayList<BookingDTO>();
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, choice);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BookingDTO host = new BookingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getBoolean(8));
				acclist.add(host);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return acclist;
	}
	
	// 숙박업소 카테고리별 조회(종류별 조회)
	public ArrayList<BookingDTO> searchType(String line) {
		
		String sql = "SELECT a.lodging_num, a.lodging_name, r.lodging_roomtype, r.lodging_state, r.lodging_charge, r.lodging_smokingState, r.lodging_maxGuests, r.lodging_hasWifi "
	               + "FROM accommodation a "
	               + "JOIN room r ON a.lodging_num = r.lodging_num "
	               + "WHERE a.lodging_type = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<BookingDTO> acclist = new ArrayList<BookingDTO>();
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, line);
			rs = stmt.executeQuery();
			while (rs.next()) {
				BookingDTO host = new BookingDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
						rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getBoolean(8));
				acclist.add(host);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt, con);
		}
		return acclist;
	}
}

package com.mtit.assignment.hotel.publisher;

import java.util.Date;

public class Reservations {

	private String name;
	private Date date;
	private String hotelName;
	private String roomNo;
	
	public Reservations() {
		// TODO Auto-generated constructor stub
	}

	public Reservations(String hotelName, Date date, String name, String roomNo) {
		this.setHotelName(hotelName);
		this.setDate(date);
		this.setName(name);
		this.setRoomNo(roomNo);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	


}

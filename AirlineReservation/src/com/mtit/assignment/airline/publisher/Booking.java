package com.mtit.assignment.airline.publisher;

import java.util.Date;

public class Booking {
	private String name;
	private Date date;
	private String flightNo;
	private int passengerCount;

	public Booking() {
	}
	
	public Booking(String flightNo, Date date, String fullName, int passengerCount) {
		this.setFlightNo(flightNo);
		this.setDate(date);
		this.setName(fullName);
		this.setPassengerCount(passengerCount);
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

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
}

package com.mtit.assignment.airline.publisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ServicePublishImpl implements AirPlaneServicePublisher {
	// store flight details
	protected HashMap<String, Boolean> flights = new HashMap<>();
	// store booking details
	protected ArrayList<Booking> bookingList = new ArrayList<>();

	public ServicePublishImpl() {
		// set default flights
		flights.put("FJX001", true);
		flights.put("FJX002", true);
		flights.put("FJX003", true);
		flights.put("FJX004", true);
		flights.put("FJX005", true);
		flights.put("BCX001", true);
		flights.put("BCX002", true);
		flights.put("BCX003", true);
	}

	/**
	 * Implementation of returning flight details
	 */
	@Override
	public ArrayList<String> getFlights() {
		ArrayList<String> temp = new ArrayList<>();
		for (String flightNo : this.flights.keySet()) {
			temp.add(flightNo);
		}
		return temp;
	}

	/**
	 * Implementation of returning availability for given flight number
	 */
	@Override
	public boolean checkFlight(String flightNo) {
		boolean status = false;
		if (this.flights.containsKey(flightNo)) {
			status = this.flights.get(flightNo);
		}
		return status;
	}

	@Override
	public boolean bookFlight(String flightNo, Date date, String fullName, int passengerCount) {
		boolean status = false;
		try {
			// make new booking
			Booking booking = new Booking(flightNo, date, fullName, passengerCount);
			this.bookingList.add(booking);
			// book flight
			this.flights.put(flightNo, false);
			status = true;
		} catch (Exception e) {
			System.out.println("Error ! - Booking Flight Section");
			status = false;
		}
		return status;
	}

}

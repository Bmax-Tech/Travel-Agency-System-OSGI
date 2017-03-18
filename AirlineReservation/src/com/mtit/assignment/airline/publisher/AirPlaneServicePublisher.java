package com.mtit.assignment.airline.publisher;

import java.util.ArrayList;
import java.util.Date;

public interface AirPlaneServicePublisher {
	/**
	 * Service to get All flights
	 * 
	 * @return
	 */
	public ArrayList<String> getFlights();

	/**
	 * Service to check specific flight for given flight no
	 * 
	 * @param flightNo
	 * @return
	 */
	public boolean checkFlight(String flightNo);

	/**
	 * Service to book flight for given inputs
	 * 
	 * @param flightNo
	 * @param date
	 * @param fullName
	 * @param passengerCount
	 * @return
	 */
	public boolean bookFlight(String flightNo, Date date, String fullName, int passengerCount);
}

package com.mtit.assignment.hotel.publisher;

import java.util.ArrayList;
import java.util.Date;

public interface HotelServicePublisher {
	/**
	 * Service to get All Hotels
	 * 
	 * @return
	 */
	
    public ArrayList<String> getHotels();
	/**
	 * Service to check specific room for given hotel 
	 * 
	 * @param HotelName
	 * @return
	 */
	public ArrayList<String> checkRoom(String hotelName);

	/**
	 * Service to book Room for given inputs
	 * 
	 * @param hotelName
	 * @param date
	 * @param fullName
	 * @param Count
	 * @return
	 */
	public boolean ReserveRoom(String hotelname, Date date, String fullName, String rooomNo);

}

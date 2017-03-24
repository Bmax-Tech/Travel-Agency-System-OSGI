package com.mtit.assignment.hotel.publisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import com.mtit.assignment.hotel.publisher.Reservations;

public class ServicePublishImpl implements HotelServicePublisher {

	// store Hotel details
	protected HashMap<String,HashMap<String,Boolean>> hotels = new HashMap<String,HashMap<String,Boolean>>();
	
	// Reserved Rooms details
	protected ArrayList<Reservations> reservationList = new ArrayList<>();

	
	public ServicePublishImpl() {
		HashMap<String,Boolean> acctyp1 = new HashMap<String,Boolean>();
		HashMap<String,Boolean> acctyp2 = new HashMap<String,Boolean>();
		HashMap<String,Boolean> acctyp3 = new HashMap<String,Boolean>();
		HashMap<String,Boolean> acctyp4 = new HashMap<String,Boolean>();
		HashMap<String,Boolean> acctyp5 = new HashMap<String,Boolean>();
		HashMap<String,Boolean> acctyp6 = new HashMap<String,Boolean>();
		
		acctyp1.put("101",true);
		acctyp1.put("102",true);
		acctyp1.put("103",true);
		acctyp1.put("104",true);
		acctyp1.put("105",true);
		
		acctyp2.put("101",true);
		acctyp2.put("102",true);
		acctyp2.put("103",true);
		acctyp2.put("104",true);
		acctyp2.put("105",true);
	
		acctyp3.put("101",true);
		acctyp3.put("102",true);
		acctyp3.put("103",true);
		acctyp3.put("104",true);
		acctyp3.put("105",true);
		
		acctyp4.put("101",true);
		acctyp4.put("102",true);
		acctyp4.put("103",true);
		acctyp4.put("104",true);
		acctyp4.put("105",true);
		
		acctyp5.put("101",true);
		acctyp5.put("102",true);
		acctyp5.put("103",true);
		acctyp5.put("104",true);
		acctyp5.put("105",true);
		
		acctyp6.put("101",true);
		acctyp6.put("102",true);
		acctyp6.put("103",true);
		acctyp6.put("104",true);
		acctyp6.put("105",true);
		
		// set default Hotels and Rooms
		hotels.put("Cinnamon", acctyp1);
		hotels.put("Galadhari", acctyp2);
		hotels.put("GallFace", acctyp3);
		hotels.put("MountLavinia", acctyp4);
		hotels.put("Hilton", acctyp5);
		hotels.put("Taj", acctyp6);
		
	}

	@Override
	public ArrayList<String> getHotels() {
		ArrayList<String> temp = new ArrayList<>();
		for (String hotelName : this.hotels.keySet()) {
			temp.add(hotelName);
		}
		return temp;
	}

	@Override
	public ArrayList<String> checkRoom(String hotelName) {
		HashMap<String,Boolean> rooms=new HashMap<String,Boolean>();
		ArrayList<String> roomsList = new ArrayList<String>();
		if (this.hotels.containsKey(hotelName)) {
			
		  rooms = this.hotels.get(hotelName);
		  for (String room : rooms.keySet()) {
				if(rooms.get(room)){
					roomsList.add(room);
				}
		  }
		}
		return roomsList;
	}

	@Override
	public boolean ReserveRoom(String hotelName, Date date, String fullName, String rooomNo) {
		boolean status = false;
		try {
			// make new Reservation
			Reservations reservation = new Reservations(hotelName, date, fullName, rooomNo);
			this.reservationList.add(reservation);
			// 
			
			
			
			HashMap<String,Boolean> rooms=new HashMap<String,Boolean>();
		
			if (this.hotels.containsKey(hotelName)) {
				
			  rooms = this.hotels.get(hotelName);
			  if (rooms.containsKey(rooomNo)) {
				  rooms.put(rooomNo, false);
				  this.hotels.put(hotelName, rooms);
				  status = true;
			  }
			 
			}
			
			
		} catch (Exception e) {
			System.out.println("Error ! - Reserving room Section");
			status = false;
		}
		return status;
	}

}

package com.mtit.assignment.agency.consumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.assignment.airline.publisher.AirPlaneServicePublisher;
import com.mtit.assignment.hotel.publisher.HotelServicePublisher;

public class AgencyServiceActivator implements BundleActivator {

	protected ServiceReference<?> serviceReserference_1;
	protected ServiceReference<?> serviceReserference_2;
	protected AirPlaneServicePublisher servicePublisher_1;
	protected HotelServicePublisher servicePublisher_2;
	private Scanner scanner;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("### Agency Consumer - online ###");

		// get registered service from service provider
		serviceReserference_1 = bundleContext.getServiceReference(AirPlaneServicePublisher.class.getName());
		servicePublisher_1 = (AirPlaneServicePublisher) bundleContext
				.getService(serviceReserference_1);

		serviceReserference_2 = bundleContext.getServiceReference(HotelServicePublisher.class.getName());
		servicePublisher_2 = (HotelServicePublisher) bundleContext
				.getService(serviceReserference_2);

		this.initConsole();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO Auto-generated method stub
		bundleContext.ungetService(serviceReserference_1);
		bundleContext.ungetService(serviceReserference_2);
		

	}

	/**
	 * Initial console for user
	 */
	private void initConsole() {
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~                                ~~~~~");
		System.out.println("~~~~~    Welcome to Agency Portal    ~~~~~");
		System.out.println("~~~~~                                ~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Option                              key No");
		System.out.println("------------------------------------------");
		System.out.println("AirLine Reservation                    1  ");
		System.out.println("Hotel Reservation                      2  ");
		System.out.println("------------------------------------------");
		System.out.print("Enter Option                          :");
		scanner = new Scanner(System.in);
		int no = Integer.parseInt(scanner.nextLine());

		switch (no) {
		case 1:
			// print options menu
			this.consoleAirLine();
			break;
		case 2:
			// print options menu
			this.consoleHotel();
			break;
		
		}

	}

	/**
	 * hotel reservation console for user
	 */
	private void consoleHotel() {
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("       Welcome to Hotel-Agency Portal     ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
		// print options menu
		this.processOptionHotel();
	}

	/**
	 * hotel reservation console for user
	 */
	private void consoleAirLine() {
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("        Welcome to Air-Agency Portal      ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("");
		// print options menu
		this.processOptionAirLine();
	}

	/**
	 * Process option
	 */
	@SuppressWarnings("resource")
	private void processOptionAirLine() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Option                              key No");
		System.out.println("------------------------------------------");
		System.out.println("List Flights                           1  ");
		System.out.println("Check Flight                           2  ");
		System.out.println("Book Flight                            3  ");
		System.out.println("Exit                                   4  ");
		System.out.println("------------------------------------------");
		System.out.print("Enter option                            :");
		Scanner scanner = new Scanner(System.in);
		int no = Integer.parseInt(scanner.nextLine());

		switch (no) {
		case 1:
			// list flight details
			ArrayList<?> flights = servicePublisher_1.getFlights();
			int count = 1;
			for (Object object : flights) {
				System.out.println("Flight " + count + " : " + object.toString());
				count++;
			}
			processOptionAirLine();
			break;
		case 2:
			// check flight
			System.out.print("\nEnter Flight No 	: ");
			String flightNo = scanner.nextLine();
			System.out.println("Flight Availability 	: " + servicePublisher_1.checkFlight(flightNo));
			processOptionAirLine();
			break;
		case 3:
			// check flight
			System.out.print("\nEnter Full Name		: ");
			String name = scanner.nextLine();
			System.out.print("Enter Flight No 	: ");
			String flight = scanner.nextLine();
			System.out.print("Enter Passenger Count 	: ");
			int passengercount = Integer.parseInt(scanner.nextLine());
			Date newDate = new Date();
			System.out.println(
					"Book Flight Status		: " + servicePublisher_1.bookFlight(flight, newDate, name, passengercount));
			processOptionAirLine();
			break;
		case 4:
			initConsole();
			break;
		}
	}

	/**
	 * Process option
	 */
	@SuppressWarnings("resource")
	private void processOptionHotel() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Option                              key No");
		System.out.println("------------------------------------------");
		System.out.println("List Hotels                            1  ");
		System.out.println("Check Rooms                            2  ");
		System.out.println("Exit                                   3  ");
		System.out.println("------------------------------------------");
		System.out.print("Enter option                            :");
		Scanner scanner = new Scanner(System.in);
		int no = Integer.parseInt(scanner.nextLine());

		switch (no) {
		case 1:
			// list Hotel details
			ArrayList<?> hotels = servicePublisher_2.getHotels();
			int count = 1;
			System.out.println("=============Hotels==============");
			for (Object object : hotels) {
				System.out.println("Hotel " + count + " : " + object.toString());
				count++;
			}
			System.out.println("==========================================");
			System.out.println("\n");
			System.out.println("\n");
			processOptionHotel();
			break;
		case 2:
			// check Rooms
			System.out.print("\nEnter Hotel Name 	: ");
			String hotelName = scanner.nextLine();
			ArrayList<?> roomsList = servicePublisher_2.checkRoom(hotelName);
			System.out.println("=============Available Rooms==============");
			System.out.println("\t Hotel "+ hotelName);
			if (!roomsList.isEmpty()) {
				for (Object object : roomsList) {
					System.out.println("Room No "  + object.toString());

				}
			}else{
				System.out.println("Sorry No Rooms Available!");
			}

			System.out.println("==========================================");
			System.out.println("\n");
			System.out.println("\n");
			
			System.out.println("Please Select a Room");
			String roomNo = scanner.nextLine();
			System.out.print("\nEnter Full Name		: ");
			String name = scanner.nextLine();
			Date newDate = new Date();
			System.out.println(
					"Book Room Status		: " + servicePublisher_2.ReserveRoom(hotelName, newDate, name, roomNo));

			processOptionHotel();
			break;

		case 3:
			initConsole();
			break;
		}
	}



}

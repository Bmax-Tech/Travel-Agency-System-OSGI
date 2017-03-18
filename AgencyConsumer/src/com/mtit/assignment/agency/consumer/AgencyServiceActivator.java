package com.mtit.assignment.agency.consumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.assignment.airline.publisher.AirPlaneServicePublisher;

public class AgencyServiceActivator implements BundleActivator {

	protected ServiceReference<?> serviceReserference_1;
	protected ServiceReference<?> serviceReserference_2;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("### Agency Consumer - online ###");

		// get registered service from service provider
		serviceReserference_1 = bundleContext.getServiceReference(AirPlaneServicePublisher.class.getName());
		AirPlaneServicePublisher servicePublisher = (AirPlaneServicePublisher) bundleContext
				.getService(serviceReserference_1);

		this.console(servicePublisher);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * console for user
	 */
	private void console(AirPlaneServicePublisher servicePublisher) {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("     Welcome to Air-Agency Portal    \n");
		// print options menu
		this.processOption(servicePublisher);
	}

	/**
	 * Process option
	 */
	@SuppressWarnings("resource")
	private void processOption(AirPlaneServicePublisher servicePublisher) {
		System.out.println("Option				key No");
		System.out.println("List Flights..................... 1");
		System.out.println("Check Flight..................... 2");
		System.out.println("Book Flight...................... 3");
		System.out.println("Exit............................. 4\n");
		System.out.print("Enter option : ");

		Scanner scanner = new Scanner(System.in);
		int no = Integer.parseInt(scanner.nextLine());

		switch (no) {
		case 1:
			// list flight details
			ArrayList<?> flights = servicePublisher.getFlights();
			int count = 1;
			for (Object object : flights) {
				System.out.println("Flight " + count + " : " + object.toString());
				count++;
			}
			processOption(servicePublisher);
			break;
		case 2:
			// check flight
			System.out.print("\nEnter Flight No 	: ");
			String flightNo = scanner.nextLine();
			System.out.println("Flight Availability 	: " + servicePublisher.checkFlight(flightNo));
			processOption(servicePublisher);
			break;
		case 3:
			// check flight
			System.out.print("\nEnter Full Name		: ");
			String name = scanner.nextLine();
			System.out.println("Enter Flight No 	: ");
			String flight = scanner.nextLine();
			System.out.println("Enter Passenger Count 	: ");
			int passengercount = Integer.parseInt(scanner.nextLine());
			Date newDate = new Date();
			System.out.println(
					"Book Flight Status		: " + servicePublisher.bookFlight(flight, newDate, name, passengercount));
			processOption(servicePublisher);
			break;
		case 4:
			processOption(servicePublisher);
			break;
		}
	}

}

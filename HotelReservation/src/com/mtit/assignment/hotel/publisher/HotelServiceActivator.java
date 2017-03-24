package com.mtit.assignment.hotel.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class HotelServiceActivator implements BundleActivator {
	protected ServiceRegistration<?> serviceRegistration;
	
	public HotelServiceActivator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		System.out.println(">>>   Hotel Reservation  <<<");
		System.out.println(">>>   service : online   <<<");
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		// register service
		HotelServicePublisher publisher = new ServicePublishImpl();
		this.serviceRegistration = bundleContext.registerService(HotelServicePublisher.class, publisher, null);
	

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		System.out.println(">>>   Hotel Reservation  <<<");
		System.out.println(">>>   service : offline  <<<");
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		// unregister service
		this.serviceRegistration.unregister();

	}

}

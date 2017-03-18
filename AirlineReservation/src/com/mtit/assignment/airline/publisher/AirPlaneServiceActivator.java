package com.mtit.assignment.airline.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AirPlaneServiceActivator implements BundleActivator{

	protected ServiceRegistration<?> serviceRegistration;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		System.out.println(">>> Airplane Reservation <<<");
		System.out.println(">>>   service : online   <<<");
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		// register service
		AirPlaneServicePublisher publisher = new ServicePublishImpl();
		this.serviceRegistration = bundleContext.registerService(AirPlaneServicePublisher.class, publisher, null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		System.out.println(">>> Airplane Reservation <<<");
		System.out.println(">>>   service : offline  <<<");
		System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		// unregister service
		this.serviceRegistration.unregister();
	}

}

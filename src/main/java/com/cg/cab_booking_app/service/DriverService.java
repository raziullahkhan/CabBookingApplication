package com.cg.cab_booking_app.service;

import java.util.List;
import java.util.function.Supplier;

import com.cg.cab_booking_app.model.Driver;

public interface DriverService{
	
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(Driver driver);
	public Driver deleteDriver(int driverId);
	public List<Driver> viewBestDrivers();
	public Driver viewDriver(int driverId);
	public List<Driver> viewDriverList(); 
	public Driver validateDriver(String username,String password);
}

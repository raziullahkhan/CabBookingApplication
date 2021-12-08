package com.cg.cab_booking_app.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cab_booking_app.exception.CabNotFoundException;
import com.cg.cab_booking_app.exception.DriverNotFoundException;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Driver;
import com.cg.cab_booking_app.service.CabServiceImpl;
import com.cg.cab_booking_app.service.DriverService;
import com.cg.cab_booking_app.service.DriverServiceImpl;

@RestController
@RequestMapping("/api/driver")
public class DriverControllers {
	
	@Autowired
	private DriverServiceImpl driverService;
	
	@PostMapping("/add")
	public Driver insertDriver(@RequestBody Driver driver) throws CabNotFoundException {
		return driverService.insertDriver(driver);
	}
	
	@GetMapping("/view/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		
		Driver driver=null;
		try {
			driver = driverService.viewDriver(driverId);
		}
		catch(Exception e) {
			throw new DriverNotFoundException("Driver not found with id "+driverId);
		}
		return driver;
	}
	
	@PutMapping("/update")
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		Driver d=null;
		try {
			d=viewDriver(driver.getDriverId());
		}
		catch(Exception e){
			throw new DriverNotFoundException("Driver not found for updating");
		}
		d=driverService.updateDriver(driver);
		return d;
	}
	@DeleteMapping("/delete/{driverId}")
	public Driver deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		Driver d=null;
		try {
			d=viewDriver(driverId);
		}
		catch(Exception e){
			throw new DriverNotFoundException("Driver not found with id "+driverId+" for deleting");
		}
		d=driverService.deleteDriver(driverId);
		return d;
	}
	@GetMapping("/bestdrivers")
	public List<Driver> bestDriversList() throws DriverNotFoundException{
		List<Driver> bestDrivers=driverService.viewBestDrivers();
		if(bestDrivers.isEmpty()) {
			throw new DriverNotFoundException("Best Driver list is Empty");
		}
		return bestDrivers;
	}
	
	@GetMapping("/driverlist")
	public List<Driver> getDriverList() throws DriverNotFoundException{
		List<Driver> driverList=driverService.viewDriverList();
		if(driverList.isEmpty()) {
			throw new DriverNotFoundException("Driver list is empty");
		}
		return driverList;
	}
}

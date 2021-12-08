package com.cg.cab_booking_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab_booking_app.model.Driver;
import com.cg.cab_booking_app.respository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService{
	@Autowired
	private DriverRepository driverRepo;

	@Override
	public Driver insertDriver(Driver driver) {
		return driverRepo.saveAndFlush(driver);
	}

	@Override
	public Driver updateDriver(Driver driver) {
		return driverRepo.saveAndFlush(driver);
	}

	@Override
	public Driver deleteDriver(int driverId) {
		Driver driver=driverRepo.findById(driverId).get();
		driverRepo.deleteById(driverId);
		return driver;
	}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> bestDriver=driverRepo.findAll();
		
		return bestDriver.stream().filter(driver -> driver.getRating()>=4.5).collect(Collectors.toList());
	}

	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> driver=driverRepo.findById(driverId);
		return driver.get();
	}

	@Override
	public List<Driver> viewDriverList() {
		return driverRepo.findAll();
	}

	@Override
	public Driver validateDriver(String username, String password) {
		List<Driver> driverList=driverRepo.findAll();
		for(Driver driver:driverList) {
			if(driver.getEmail().equalsIgnoreCase(username)) {
				if(driver.getPassword().equals(password)) {
					return driver;
				}
			}
		}
		return null;
	}
	
	
}

package com.cg.cab_booking_app.respository;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cab_booking_app.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

	/*public Supplier<Driver> insertDriver(Driver driver);
	public Supplier<Driver> updateDriver(Driver driver);
	public Supplier<Driver> deleteDriver(int driverId);
	public List<Driver> viewBestDrivers();
	public Driver viewDriver(int driverId);*/
}

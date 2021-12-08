package com.cg.cab_booking_app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cab_booking_app.model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{
	
	/*public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(int cabId);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);*/
	public List<Cab> findByCarType(String carType);
}

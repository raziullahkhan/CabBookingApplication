package com.cg.cab_booking_app.service;

import java.util.List;

import com.cg.cab_booking_app.model.Cab;

public interface CabService {
	
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(int cabId);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
	public List<Cab> viewCabList();
	public Cab viewCab(int cabId);
	
}

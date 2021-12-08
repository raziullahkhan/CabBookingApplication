package com.cg.cab_booking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.respository.CabRepository;

@Service
public class CabServiceImpl implements CabService{
	
	@Autowired
	CabRepository cabRepo;

	@Override
	public Cab insertCab(Cab cab) {
		return cabRepo.saveAndFlush(cab);
	}

	@Override
	public Cab updateCab(Cab cab) {
		return cabRepo.saveAndFlush(cab);
	}

	@Override
	public Cab deleteCab(int cabId) {
		Cab cab=cabRepo.findById(cabId).get();
		cabRepo.deleteById(cabId);
		return cab;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		return cabRepo.findByCarType(carType);
	}

	@Override
	public int countCabsOfType(String carType) {
		return (int)cabRepo.findByCarType(carType).stream().count();
	}

	@Override
	public List<Cab> viewCabList() {
		return cabRepo.findAll();
	}

	@Override
	public Cab viewCab(int cabId) {
		return cabRepo.findById(cabId).get();
	}

}

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
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.service.CabServiceImpl;

@RestController
@RequestMapping("/api/cab")
public class CabControllers {
	
	@Autowired
	CabServiceImpl cabService;
	
	@PostMapping("/add")
	public Cab addCab(@RequestBody Cab cab) {
		return cabService.insertCab(cab);
	}
	
	@PutMapping("/update")
	public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
		Cab c=null;
		try {
			c=cabService.viewCab(cab.getCabId());
		}
		catch(Exception e) {
			throw new CabNotFoundException("Cab is not found for updating");
		}
		c=cabService.updateCab(cab);
		return c;
	}
	
	@DeleteMapping("/delete/{cabId}")
	public Cab deleteCab(@PathVariable int cabId) throws CabNotFoundException {
		Cab cab=null;
		try {
			cab=cabService.viewCab(cabId);
		}
		catch(Exception e){
			throw new CabNotFoundException("Cab is not found with id "+cabId+" for deletting");
		}
		try {
			cab=cabService.deleteCab(cabId);
		}
		catch(Exception e) {
			throw new CabNotFoundException("can not delete: Driver using this cab");
		}
		return cab;
	}
	
	@GetMapping("/view/{cabId}")
	public Cab viewCab(@PathVariable int cabId) throws CabNotFoundException {
		Cab cab=null;
		try {
			cab=cabService.viewCab(cabId);
		}catch(Exception e) {
			throw new CabNotFoundException("Cab is not found with id "+cabId);
		}
		return cab;
	}
	
	@GetMapping("viewcablist")
	public List<Cab> getCabList() throws CabNotFoundException{
		
		List<Cab> cabList=cabService.viewCabList();
		if(cabList.isEmpty()) {
			throw new CabNotFoundException("Cab list is empty");
		}
		return cabList;
	}
	
	@GetMapping("/viewcar/{carType}")
	public List<Cab> getCabOfType(@PathVariable String carType) throws CabNotFoundException{
		List<Cab> cabList=null;
		cabList=cabService.viewCabsOfType(carType);
		if(cabList.isEmpty()) {
			throw new CabNotFoundException("There is not cab of type "+carType);
		}
		return cabList;
	}
	
	@GetMapping("/count/{carType}")
	public int getCountCabOfType(@PathVariable String carType) {
		return cabService.countCabsOfType(carType);
	}
}

package com.cg.cab_booking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.cab_booking_app.exception.CabNotFoundException;
import com.cg.cab_booking_app.exception.DriverNotFoundException;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.model.Driver;
import com.cg.cab_booking_app.service.CabServiceImpl;
import com.cg.cab_booking_app.service.DriverService;
import com.cg.cab_booking_app.service.DriverServiceImpl;

@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverServiceImpl driverService;
	
	@RequestMapping("/addform")
	public String signUp() {
		return "addDriver";
	}
	
	@RequestMapping("/edit/{driverId}")
	public ModelAndView showEditPage(@PathVariable int driverId) {
		 ModelAndView mv=new ModelAndView("updateDriver");
		 Driver driver=driverService.viewDriver(driverId);
		 mv.addObject("driver", driver);
		return mv;
	}
	
	@PostMapping("/add")
	public String insertDriver(@ModelAttribute("driver") Driver driver) throws CabNotFoundException {
		driverService.insertDriver(driver);
		return "redirect:/driver/driverlist";
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
	
	@RequestMapping("/update")
	public String updateDriver(@ModelAttribute("driver") Driver driver) throws DriverNotFoundException {
		Driver d=null;
		try {
			d=viewDriver(driver.getDriverId());
		}
		catch(Exception e){
			throw new DriverNotFoundException("Driver not found for updating");
		}
		d=driverService.updateDriver(driver);
		return "redirect:/driver/driverlist";
	}
	@RequestMapping("/delete/{driverId}")
	public String deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		Driver d=null;
		try {
			d=viewDriver(driverId);
		}
		catch(Exception e){
			throw new DriverNotFoundException("Driver not found with id "+driverId+" for deleting");
		}
		d=driverService.deleteDriver(driverId);
		return "redirect:/driver/driverlist";
	}
	@GetMapping("/bestdrivers")
	public List<Driver> bestDriversList() throws DriverNotFoundException{
		List<Driver> bestDrivers=driverService.viewBestDrivers();
		if(bestDrivers.isEmpty()) {
			throw new DriverNotFoundException("Best Driver list is Empty");
		}
		return bestDrivers;
	}
	
	@RequestMapping("/driverlist")
	public String getDriverList(Model model) throws DriverNotFoundException{
		List<Driver> driverList=driverService.viewDriverList();
		if(driverList.isEmpty()) {
			throw new DriverNotFoundException("Driver list is empty");
		}
		model.addAttribute("drivers",driverList);
		model.addAttribute("count",driverList.size());
		return "manageDriver";
	}
	
	@RequestMapping("/alldriver")
	public String getDriverLists(Model model) throws DriverNotFoundException{
		List<Driver> driverList=driverService.viewDriverList();
		if(driverList.isEmpty()) {
			throw new DriverNotFoundException("Driver list is empty");
		}
		model.addAttribute("drivers",driverList);
		return "DriverList";
	}
}

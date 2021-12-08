package com.cg.cab_booking_app.rest_controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cab_booking_app.exception.AdminNotFoundException;
import com.cg.cab_booking_app.exception.CabNotFoundException;
import com.cg.cab_booking_app.exception.CustomerNotFoundException;
import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.model.TripBooking;
import com.cg.cab_booking_app.service.AdminServiceImpl;
import com.cg.cab_booking_app.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminControllers {
	
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.insertAdmin(admin);
	}

	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin adm=null;
		try {
			adm=adminService.viewAdmin(admin.getAdminId());
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin is not found for updating");
		}
		adm=adminService.updateAdmin(admin);
		return adm;
	}
	
	@DeleteMapping("/delete/{adminId}")
	public Admin deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException{
		Admin admin=null;
		try {
			admin=adminService.viewAdmin(adminId);
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin is not found with id "+adminId+" for deletting");
		}
		admin=adminService.deleteAdmin(adminId);
		
		return admin;
	}
	
	@GetMapping("/alltrip/{customerId}")
	public List<TripBooking> getAllTrip(@PathVariable int customerId) throws CustomerNotFoundException{
		List<TripBooking> tripList=null;
		try {
			Customer customer=customerService.viewCustomer(customerId);
			tripList=adminService.getAllTrips(customerId);
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer is not found with id "+customerId);
		}
		return tripList;
	}
	
	@GetMapping("/tripcabwise")
	public List<TripBooking> getTripsCabwise(){
		return adminService.getTripsCabwise();
	}
	
	@GetMapping("/tripcustomerwise")
	public List<TripBooking> getTripsCustomerwise(){
		return adminService.getTripsCustomerwise();
	}
	
	@GetMapping("/tripdatewise")
	public List<TripBooking> getTripDatewise(){
		return adminService.getTripsDatewise();
	}
	
	@GetMapping("/tripdays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getTripBookingForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
					throws CustomerNotFoundException{
		System.out.println(fromDate+" "+toDate);
		try {
			Customer customer=customerService.viewCustomer(customerId);
		}catch(Exception e){
			throw new CustomerNotFoundException("Customer not found with id "+customerId);
		}
		return adminService.getAllTripsForDays(customerId, fromDate, toDate);
	}
}

package com.cg.cab_booking_app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.cg.cab_booking_app.exception.CustomerNotFoundException;
import com.cg.cab_booking_app.exception.TripBookingNotFoundException;
import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.model.TripBooking;
import com.cg.cab_booking_app.service.AdminServiceImpl;
import com.cg.cab_booking_app.service.CustomerServiceImpl;
import com.cg.cab_booking_app.service.TripBookingServiceImpl;

@Controller
@RequestMapping("/trip")
public class TripBookingController {
	
	@Autowired
	private TripBookingServiceImpl tripService;
	@Autowired
	private CustomerServiceImpl customerService;
	@Autowired
	private AdminServiceImpl adminService;
	
	@RequestMapping("/book")
	public String bookTrip() {
		return "tripBooking";
	}
	
	@RequestMapping("/add")
	public ModelAndView addTrip(@ModelAttribute("trip") TripBooking tripBooking) throws CustomerNotFoundException {
		Customer customer=null;
		try {
			customer=customerService.viewCustomer(tripBooking.getCustomerId());
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("Customer not found with id "+tripBooking.getCustomerId());
		}
		String str = "2021-04-08T12:30:15";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		tripBooking.setFromDateTime(dateTime);
		tripBooking.setToDateTime(dateTime);
		tripBooking.setStatus(true);
		tripService.insertTripBooking(tripBooking);
		ModelAndView mv=new ModelAndView("customer");
		mv.addObject("customer",customer);
		return mv;
	}
	
	@PutMapping("/update")
	public TripBooking updateTrip(@RequestBody TripBooking tripBooking) throws TripBookingNotFoundException {
		TripBooking trip=null;
		try {
			trip=tripService.viewTripBooking(tripBooking.getTripBookingId());
		}
		catch(Exception e) {
			throw new TripBookingNotFoundException("Trip booking is not found for updating");
		}
		trip=tripService.updateTripBooking(tripBooking);
		return trip;
	}
	
	@RequestMapping("/delete/{tripBookingId}")
	public String deleteTripBooking(@PathVariable int tripBookingId) throws TripBookingNotFoundException{
		TripBooking trip=null;
		try {
			trip=tripService.viewTripBooking(tripBookingId);
		}
		catch(Exception e){
			throw new TripBookingNotFoundException("Trip Booking is not found with id "+tripBookingId+" for deletting");
		}
	
		trip=tripService.deleteTripBooking(tripBookingId);
		
		return "redirect:/trip/all";
	}
	
	@GetMapping("/alltrip/{customerId}")
	public List<TripBooking> getAllTrip(@PathVariable int customerId) throws CustomerNotFoundException{
		List<TripBooking> tripList=null;
		try {
			Customer customer=customerService.viewCustomer(customerId);
			tripList=tripService.viewAllTripsCustomer(customerId);
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer is not found with id "+customerId);
		}
		return tripList;
	}
	
	@GetMapping("/bill/{customerId}")
	public float getBill(@PathVariable int customerId) throws CustomerNotFoundException {
		try {
			Customer customer=customerService.viewCustomer(customerId);
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("Customer is not found with id "+customerId);
		}
		return tripService.calculateBill(customerId);
	}
	
	@RequestMapping("/all/{adminId}")
	public String getAllTrip(@PathVariable int adminId, Model model) {
		List<TripBooking> tripList=tripService.viewAllTrips();
		model.addAttribute("trips",tripList);
		Admin admin=adminService.viewAdmin(adminId);
		model.addAttribute("admin",admin);
		return "manageBooking";
	}
}

package com.cg.cab_booking_app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.cg.cab_booking_app.exception.AdminNotFoundException;
import com.cg.cab_booking_app.exception.CabNotFoundException;
import com.cg.cab_booking_app.exception.CustomerNotFoundException;
import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.model.TripBooking;
import com.cg.cab_booking_app.service.AdminServiceImpl;
import com.cg.cab_booking_app.service.CustomerServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping("/edit/{adminId}")
	public ModelAndView showEditPage(@PathVariable int adminId) {
		 ModelAndView mv=new ModelAndView("updateAdmin");
		 Admin admin=adminService.viewAdmin(adminId);
		 mv.addObject("admin", admin);
		return mv;
	}
	
	@RequestMapping("/home/{adminId}")
	public ModelAndView getHome(@PathVariable int adminId) {
		ModelAndView modelView=new ModelAndView("Admin");
		modelView.addObject("admin", adminService.viewAdmin(adminId));
		return modelView;
	}
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.insertAdmin(admin);
	}

	@RequestMapping("/update")
	public ModelAndView updateCustomer(@ModelAttribute("admin") Admin admin) throws AdminNotFoundException {
		Admin a=null;
		try {
			a=adminService.viewAdmin(admin.getAdminId());
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin is not found for updating with id"+admin.getAdminId());
		}
		a=adminService.updateAdmin(admin);
		ModelAndView mv=new ModelAndView("Admin");
		mv.addObject("admin",admin);
		return mv;
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
	
	@RequestMapping("/tripcabwise")
	public String getTripsCabwise(Model model){
		List<TripBooking> tripList=adminService.getTripsCabwise();
		model.addAttribute("trips", tripList);
		return "manageBooking";
	}
	
	@RequestMapping("/tripcustomerwise")
	public String getTripsCustomerwise(Model model){
		List<TripBooking> tripList=adminService.getTripsCustomerwise();
		model.addAttribute("trips", tripList);
		return "manageBooking";
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

package com.cg.cab_booking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.model.Driver;
import com.cg.cab_booking_app.service.AdminServiceImpl;
import com.cg.cab_booking_app.service.CustomerServiceImpl;
import com.cg.cab_booking_app.service.DriverServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	DriverServiceImpl driverService;
	
	@RequestMapping("/form")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping("/validate")
	public ModelAndView getCredential(@RequestParam("role") String role, @RequestParam("username") String username, @RequestParam("password") String password) {
		
		ModelAndView modelView;
		
		if(role.equalsIgnoreCase("admin")) {
			Admin admin=adminService.validateAdmin(username, password);
			if(admin==null) {
				modelView=new ModelAndView("login");
				modelView.addObject("fail", "Invalid Admin Credential");
				return modelView;
			}
			
			modelView=new ModelAndView("Admin");
			modelView.addObject("admin", admin);
			return modelView;
		}
		
		if(role.equalsIgnoreCase("customer")) {
			Customer customer=customerService.validateCustomer(username, password);
			if(customer==null) {
				modelView=new ModelAndView("login");
				modelView.addObject("fail", "Invalid Customer Credential");
				return modelView;
			}
			
			modelView=new ModelAndView("customer");
			modelView.addObject("customer", customer);
			return modelView;
		}
		
		if(role.equalsIgnoreCase("driver")) {
			Driver driver=driverService.validateDriver(username, password);
			if(driver==null) {
				modelView=new ModelAndView("login");
				modelView.addObject("fail", "Invalid Driver Credential");
				return modelView;
			}
			modelView=new ModelAndView("Driver");
			modelView.addObject("driver", driver);
			return modelView;
		}
		modelView=new ModelAndView("login");
		modelView.addObject("fail", "Invalid Selection");
		return modelView;
	}
	
}

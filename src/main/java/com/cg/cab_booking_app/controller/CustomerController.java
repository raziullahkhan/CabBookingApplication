package com.cg.cab_booking_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@RequestMapping("/edit/{customerId}")
	public ModelAndView showEditPage(@PathVariable int customerId) {
		 ModelAndView mv=new ModelAndView("updateCustomer");
		 Customer customer=customerService.viewCustomer(customerId);
		 mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}
	@RequestMapping("/home/{customerId}")
	public ModelAndView getHome(@PathVariable int customerId) {
		ModelAndView modelView=new ModelAndView("customer");
		modelView.addObject("customer", customerService.viewCustomer(customerId));
		return modelView;
	}
	
	@PostMapping("/add")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.insertCustomer(customer);
		return "redirect:/login/form";
	}
	
	@RequestMapping("/update")
	public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) throws CustomerNotFoundException {
		Customer c=null;
		try {
			c=customerService.viewCustomer(customer.getCustomerId());
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("Customer is not found for updating with id"+customer.getCustomerId());
		}
		c=customerService.updateCustomer(customer);
		ModelAndView mv=new ModelAndView("customer");
		mv.addObject("customer",c);
		return mv;
	}
	
	@DeleteMapping("/delete/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		Customer customer=null;
		try {
			customer=customerService.viewCustomer(customerId);
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer is not found with id "+customerId+" for deletting");
		}
		customer=customerService.deleteCustomer(customerId);
		return customer;
	}
	
	@GetMapping("viewcustomerlist")
	public List<Customer> getCustomerList() throws CustomerNotFoundException {
		
		List<Customer> customerList=customerService.viewCustomers();
		if(customerList.isEmpty()) {
			throw new CustomerNotFoundException("Customer list is empty");
		}
		return customerList;
	}
	
	@GetMapping("/view/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) throws CustomerNotFoundException  {
		Customer customer=null;
		try {
			customer=customerService.viewCustomer(customerId);
		}catch(Exception e) {
			throw new CustomerNotFoundException("Customer is not found with id "+customerId);
		}
		return customer;
	}
}

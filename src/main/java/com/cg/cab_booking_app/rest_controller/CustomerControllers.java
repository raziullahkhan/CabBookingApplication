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
import com.cg.cab_booking_app.exception.CustomerNotFoundException;
import com.cg.cab_booking_app.model.Cab;
import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllers {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer c=null;
		try {
			c=customerService.viewCustomer(customer.getCustomerId());
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("Customer is not found for updating");
		}
		c=customerService.updateCustomer(customer);
		return c;
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

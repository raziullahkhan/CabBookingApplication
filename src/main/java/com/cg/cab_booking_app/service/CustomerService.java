package com.cg.cab_booking_app.service;

import java.util.List;

import com.cg.cab_booking_app.model.Customer;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int customerId);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);
}

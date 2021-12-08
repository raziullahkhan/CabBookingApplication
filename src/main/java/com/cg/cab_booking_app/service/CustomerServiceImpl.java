package com.cg.cab_booking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab_booking_app.model.Customer;
import com.cg.cab_booking_app.respository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.saveAndFlush(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.saveAndFlush(customer);
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer customer=customerRepo.findById(customerId).get();
		customerRepo.deleteById(customerId);
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return customerRepo.findById(customerId).get();
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		List<Customer> customerList=customerRepo.findAll();
		for(Customer customer:customerList) {
			if(customer.getEmail().equalsIgnoreCase(username)) {
				if(customer.getPassword().equals(password)) {
					return customer;
				}
			}
		}
		
		return null;
	}

}

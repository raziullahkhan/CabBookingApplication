package com.cg.cab_booking_app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cab_booking_app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	/*public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(int customerId);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);*/
}

package com.cg.cab_booking_app.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.TripBooking;

public interface AdminService {

	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public List<TripBooking> getAllTrips(int customerId);
	public List<TripBooking> getTripsCabwise();
	public List<TripBooking> getTripsCustomerwise();
	public List<TripBooking> getTripsDatewise();
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);
	public Admin viewAdmin(int adminId);
	public Admin validateAdmin(String username, String password);
}

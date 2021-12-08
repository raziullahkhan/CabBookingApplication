package com.cg.cab_booking_app.respository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.TripBooking;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	/*public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public List<TripBooking> getAllTrips(int customerId);
	public List<TripBooking> getTripsCabwise();
	public List<TripBooking> getTripsCustomerwise();
	public List<TripBooking> getTripsDatewise();
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);*/
	
}

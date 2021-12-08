package com.cg.cab_booking_app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cab_booking_app.model.TripBooking;

public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{
	
	/*public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public TripBooking deleteTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateBill(int customerId);*/
	public List<TripBooking> findByCustomerId(int customerId);
}

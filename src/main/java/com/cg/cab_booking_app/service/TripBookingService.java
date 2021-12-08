package com.cg.cab_booking_app.service;

import java.util.List;

import com.cg.cab_booking_app.model.TripBooking;

public interface TripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public TripBooking deleteTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateBill(int customerId);
	public TripBooking viewTripBooking(int tripBookingId);
	public List<TripBooking> viewAllTrips();
}

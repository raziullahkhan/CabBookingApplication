package com.cg.cab_booking_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab_booking_app.model.TripBooking;
import com.cg.cab_booking_app.respository.TripBookingRepository;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	@Autowired
	TripBookingRepository tripBookingRepo;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		return tripBookingRepo.saveAndFlush(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		return tripBookingRepo.saveAndFlush(tripBooking);
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) {
		TripBooking tripBooking=tripBookingRepo.findById(tripBookingId).get();
		tripBookingRepo.deleteById(tripBookingId);
		return tripBooking;
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		return tripBookingRepo.findByCustomerId(customerId);
	}

	@Override
	public float calculateBill(int customerId) {
		List<TripBooking> tripList= this.viewAllTripsCustomer(customerId);
		/*float sum=0;
		for(int i=0;i<tripList.size();i++) {
			sum=sum+tripList.get(i).getBill();
		}
		return sum;*/
		Optional<Float> totalBill=tripList.stream().map(b -> b.getBill()).reduce((a,b)->a+b);
		return totalBill.get();
	}

	@Override
	public TripBooking viewTripBooking(int tripBookingId) {
		return tripBookingRepo.findById(tripBookingId).get();
	}

	@Override
	public List<TripBooking> viewAllTrips() {
		return tripBookingRepo.findAll();
	}

}

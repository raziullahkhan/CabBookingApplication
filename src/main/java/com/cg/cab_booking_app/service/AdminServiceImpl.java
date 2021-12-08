package com.cg.cab_booking_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab_booking_app.model.Admin;
import com.cg.cab_booking_app.model.TripBooking;
import com.cg.cab_booking_app.respository.AdminRepository;
import com.cg.cab_booking_app.respository.TripBookingRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	@Autowired
	TripBookingRepository tripRepo;
	
	@Override
	public Admin insertAdmin(Admin admin) {
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepo.saveAndFlush(admin);
	}

	@Override
	public Admin deleteAdmin(int adminId) {
		Admin admin=adminRepo.findById(adminId).get();
		adminRepo.deleteById(adminId);
		return admin;
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) {
		return tripRepo.findByCustomerId(customerId);
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		List<TripBooking> tripList= tripRepo.findAll();
		
		return tripList.stream().filter(s->s.getDriver()!=null)
				.sorted((a,b)->a.getDriver().getCab().getCabId()-b.getDriver().getCab().getCabId())
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		List<TripBooking> tripList=tripRepo.findAll();
		
		return tripList.stream()
				.sorted((a,b)->a.getCustomerId()-b.getCustomerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getTripsDatewise() {

		List<TripBooking> tripList=tripRepo.findAll();
		
		return tripList.stream()
				.sorted((a,b)->a.getFromDateTime().compareTo(b.getFromDateTime()))
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		List<TripBooking> tripList=tripRepo.findAll();
		return tripList.stream()
				.filter(a->a.getCustomerId()==customerId&&
				a.getFromDateTime().toString().equals(fromDate.toString())&&
				a.getToDateTime().toString().equals(toDate.toString()))
				.collect(Collectors.toList());
	}

	@Override
	public Admin viewAdmin(int adminId) {
		return adminRepo.findById(adminId).get();
	}

	@Override
	public Admin validateAdmin(String username, String password) {
		List<Admin> adminList = adminRepo.findAll();
		for(Admin admin: adminList) {
			if(admin.getEmail().equalsIgnoreCase(username)) {
				if(admin.getPassword().equals(password)) {
					return admin;
				}
			}
		}
		return null;
	}
	
	
}

package com.cg.cab_booking_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Driver extends AbstractUser{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String licenceNo;
	@OneToOne
	private Cab cab;
	private float rating;
	
	public int getDriverId() {
		return driverId;
	}
	
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getLicenceNo() {
		return licenceNo;
	}
	
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	
	public Cab getCab() {
		return cab;
	}
	
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public Driver(int driverId, String licenceNo, Cab cab, float rating,String username, String password, String address, String mobileNumber, String email) {
		super(username,password,address,mobileNumber,email);
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
	}
	
	public Driver() {
		super();
	}
	
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", cab=" + cab + ", rating=" + rating
				+ "]";
	}
}

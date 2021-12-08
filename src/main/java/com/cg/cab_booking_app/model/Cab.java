package com.cg.cab_booking_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CabId;
	private String carType;
	private float perKmRate;
	
	public Cab(int cabId, String carType, float perKmRate) {
		CabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}
	
	public Cab() {
	
	}
	
	public int getCabId() {
		return CabId;
	}
	
	public void setCabId(int cabId) {
		CabId = cabId;
	}
	
	public String getCarType() {
		return carType;
	}
	
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public float getPerKmRate() {
		return perKmRate;
	}
	
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	@Override
	public String toString() {
		return "Cab [CabId=" + CabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
	
}

package com.example.model;

import java.util.Date;

public abstract class Vehicle {

	
	protected String registrationNumber;
	protected int wheelNumber;
	protected ParkingSlot parkingSlot;
	protected Date inTime;
	protected Date outTime;
	
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getWheelNumber() {
		return wheelNumber;
	}

	public void setWheelNumber(int wheelNumber) {
		this.wheelNumber = wheelNumber;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public int getParkedTime() {
		return this.outTime.getMinutes()-this.inTime.getMinutes();
	}
	
	public void parkTheVehicle(ParkingSlot ps) {
		this.parkingSlot=ps;
	}
	
	public abstract int getCurrentParkingCharge();
	
}

package com.example.vehicles;

import java.util.Date;

import com.example.model.Vehicle;

public class FourWheeler extends Vehicle{

	
	
	public FourWheeler(String registrationNumber,Date inTime) {
		this.registrationNumber=registrationNumber;
		this.inTime=inTime;
		this.wheelNumber=4;
		this.parkingSlot=null;
		this.outTime=null;
		
	}
	
	
	@Override
	public int getCurrentParkingCharge() {
		Date currentDate=new Date();
		int currentParkingCharge=this.getParkingSlot().getParkingCharge(currentDate.getMinutes()-this.inTime.getMinutes());
		return currentParkingCharge;
	}

}

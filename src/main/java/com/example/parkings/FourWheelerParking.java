package com.example.parkings;

import com.example.model.ParkingSlot;
import com.example.model.Vehicle;

public class FourWheelerParking extends ParkingSlot{

	private int parkingRatePerMin=10;
	

	public FourWheelerParking(int i, Vehicle vehicle, int parkingType) {
		this.parkingSlotId=i;
		this.parkedVechile=vehicle;
		this.parkingSlotType=4;
	}

	@Override
	public int getParkingCharge(int parkingDuration) {
		if(parkingDuration>0)
			return parkingDuration*this.parkingRatePerMin;
		else
			return this.parkingRatePerMin;
	}
	
	

}

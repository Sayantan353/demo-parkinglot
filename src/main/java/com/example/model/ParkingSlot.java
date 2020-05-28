package com.example.model;

public abstract class ParkingSlot {

	protected int parkingSlotId;
	protected Vehicle parkedVechile;
	protected int parkingSlotType;
	
	
	public int getParkingSlotType() {
		return parkingSlotType;
	}




	public int getParkingSlotId() {
		return parkingSlotId;
	}


	public Vehicle getParkedVechile() {
		return parkedVechile;
	}


	public void setParkedVechile(Vehicle parkedVechile) {
		this.parkedVechile = parkedVechile;
	}


	public abstract int getParkingCharge(int parkingDuration);
	
	
}

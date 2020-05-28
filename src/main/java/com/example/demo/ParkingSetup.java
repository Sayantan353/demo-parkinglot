package com.example.demo;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.example.model.*;
import com.example.parkings.FourWheelerParking;
import com.example.parkings.TwoWheelerParking;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingSetup {

	private ArrayList<ParkingSlot> parkingSlotsArry=new ArrayList<ParkingSlot>();
	
	ParkingSlot ps1=new FourWheelerParking(0,null,4);
	ParkingSlot ps2=new FourWheelerParking(1,null,4);
	ParkingSlot ps3=new TwoWheelerParking(2,null,2);
	ParkingSlot ps4=new TwoWheelerParking(3,null,2);
	



	@PostConstruct
	public void dataSetup() {
		
		this.parkingSlotsArry.add(ps1);
		this.parkingSlotsArry.add(ps2);
		this.parkingSlotsArry.add(ps3);
		this.parkingSlotsArry.add(ps4);
	}
	



	public ArrayList<ParkingSlot> getParkingSlotsArry() {
		return parkingSlotsArry;
	}

	public void setParkingSlotsArry(int parkingSlotIndex, ParkingSlot parkingSlot) {
		parkingSlotsArry.set(parkingSlotIndex, parkingSlot);
	}
	
}

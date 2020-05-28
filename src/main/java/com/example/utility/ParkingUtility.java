package com.example.utility;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.ParkingSetup;
import com.example.model.ParkingSlot;
import com.example.model.Vehicle;

@Component
public class ParkingUtility {
	

	@Autowired
	private ParkingSetup ps;

	public int getParkingSlot(Vehicle vehicleToPark) {
		ArrayList<ParkingSlot> parkingSlots=ps.getParkingSlotsArry();
		int availableParkingId=-1;
		for(int i=0;i<parkingSlots.size();i++) {
			if(parkingSlots.get(i).getParkedVechile()==null) {
				if(vehicleToPark.getWheelNumber()==parkingSlots.get(i).getParkingSlotType()) {					
					availableParkingId=parkingSlots.get(i).getParkingSlotId();
				}
					
			}
		}
		return availableParkingId;
	}
	
	
	
}

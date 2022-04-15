package com.example.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ParkingSetup;
import com.example.model.ParkingSlot;
import com.example.model.Vehicle;
import com.example.utility.ParkingUtility;
import com.example.vehicles.FourWheeler;
import com.example.vehicles.TwoWheeler;

@RestController
public class ParkingController {

	@Autowired
	private ParkingSetup ps;

	@Autowired
	private ParkingUtility parkingUtility;

	@GetMapping("/parkVehicle")
	public String isParkingAvailable(@RequestParam("registrationNbr") String registrationNbr,
			@RequestParam("wheelCount") int wheelCount) {
		String result = "Parking Slots are Available--@!";

		return result;
	}

	@PostMapping("/parkVehicle")
	public String parkVehicle(@RequestParam("registrationNbr") String registrationNbr,
			@RequestParam("wheelCount") int wheelCount) {
		String result = null;
		try {
			Date dt = new Date();
			Vehicle vehicle = null;
			int vehicleParkedSlot = 0;
			if (wheelCount == 4) {
				vehicle = new FourWheeler(registrationNbr, dt);
			} else if (wheelCount == 2) {
				vehicle = new TwoWheeler(registrationNbr, dt);
			} else {
				throw new RuntimeException("Invalid wheel number");
			}
			vehicleParkedSlot = parkingUtility.getParkingSlot(vehicle);
			if (vehicleParkedSlot >= 0) {
				ParkingSlot parkingSlot = ps.getParkingSlotsArry().get(vehicleParkedSlot);
				vehicle.setParkingSlot(parkingSlot);
				parkingSlot.setParkedVechile(vehicle);
				ps.getParkingSlotsArry().set(vehicleParkedSlot, parkingSlot);
				result = "Vehicle successfully parked. ParkingSlot - " + vehicleParkedSlot;
			} else {
				result = "Parking space not available";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping("/vehicles")
	public HashMap<String, Date> getParkedVehicleDetails() {
		HashMap<String, Date> parkedVehicleDetails = new HashMap<String, Date>();
		try {
			ps.getParkingSlotsArry().stream().filter(x -> x.getParkedVechile() != null)
					.forEach(entity -> parkedVehicleDetails.put(entity.getParkedVechile().getRegistrationNumber(),
							entity.getParkedVechile().getInTime()));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return parkedVehicleDetails;
	}

	@GetMapping("/getparkingcharge")
	public int getParkingChange(@RequestParam("registrationnbr") String registrationNbr) {
		int result = 0;
		try {
			System.out.println("--" + registrationNbr);
			List<ParkingSlot> vehicleParkedSlot = ps.getParkingSlotsArry().stream()
					.filter(x -> x.getParkedVechile() != null)
					.filter(x -> x.getParkedVechile().getRegistrationNumber().equalsIgnoreCase(registrationNbr))
					.collect(Collectors.toList());
			if (!vehicleParkedSlot.isEmpty()) {
				result = vehicleParkedSlot.get(0).getParkedVechile().getCurrentParkingCharge();
			} else {
				System.out.println("Exception flow");
				throw new RuntimeException("Vehicle not present in the parking lot");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}

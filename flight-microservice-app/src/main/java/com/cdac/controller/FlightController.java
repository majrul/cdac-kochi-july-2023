package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.FlightDetails;
import com.cdac.dto.Status;
import com.cdac.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/flights/add")
	public Status add(@RequestBody FlightDetails flightDetails) {
		flightService.addFlight(flightDetails);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Flight added!");
		return status;
	}
}

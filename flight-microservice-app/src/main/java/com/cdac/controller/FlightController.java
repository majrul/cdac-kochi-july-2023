package com.cdac.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.FlightDetails;
import com.cdac.dto.Status;
import com.cdac.entity.Flight;
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
	
	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return flightService.getAvailableFlights();
	}
	
	@GetMapping("/flights/{source}/{destination}/{date}")
	public List<Flight> getFlights(@PathVariable String source, @PathVariable String destination, @PathVariable LocalDate date) {
		return flightService.getAvailableFlights(source, destination, date);
	}
	
	@GetMapping("/flights/seats-available")
	public Status getFlights(@RequestParam String flightNo, @RequestParam LocalDate travelDate, @RequestParam int noOfSeats) {
		boolean available = flightService.areSeatsAvailable(flightNo, travelDate, noOfSeats);
		Status status = new Status();
		status.setStatus(available);
		return status;
	}
	
	@PostMapping("/flights/block-seats")
	public Status blockSeats(@RequestBody BookingDetails bookingDetails) {
		flightService.confirmBooking(bookingDetails.getFlightNo(), bookingDetails.getTravelDate(), bookingDetails.getNoOfSeats());
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Seats blocked!");
		return status;
	}
}

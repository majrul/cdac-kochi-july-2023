package com.cdac.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.Status;

@FeignClient(name="flight-microservice")
public interface FlightServiceCommunicator2 {

	@GetMapping("/flights/seats-available")
	public Status isBookingPossible(@RequestParam Map<String, Object> params);
	
	@PostMapping("/flights/block-seats")
	public Status blockSeats(@RequestBody Map<String, Object> params);
	
	public default Status checkAndBlockSeats(BookingDetails bookingDetails) {		
		Map<String, Object> params = new HashMap<>();
		params.put("flightNo", bookingDetails.getFlightNo());
		params.put("travelDate", bookingDetails.getTravelDate());
		params.put("noOfSeats", bookingDetails.getPassengers().size());
		
		Status status = isBookingPossible(params);
		
		if(status.isStatus())
			status = blockSeats(params);
		
		return status;
	}
}

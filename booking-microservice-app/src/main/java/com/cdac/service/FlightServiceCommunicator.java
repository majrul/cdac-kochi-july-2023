package com.cdac.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.Status;

@Service
public class FlightServiceCommunicator {

	public Status checkAndBlockSeats(BookingDetails bookingDetails) {
		String url = "http://localhost:9001/flights/seats-available?flightNo={flightNo}&travelDate={travelDate}&noOfSeats={noOfSeats}";
		
		Map<String, Object> params = new HashMap<>();
		params.put("flightNo", bookingDetails.getFlightNo());
		params.put("travelDate", bookingDetails.getTravelDate());
		params.put("noOfSeats", bookingDetails.getPassengers().size());
		
		//utility class provided by spring for accessing any REST api
		RestTemplate restTemplate = new RestTemplate();
		Status status = restTemplate.getForObject(url, Status.class, params);
		
		if(status.isStatus()) {
			url = "http://localhost:9001/flights/block-seats";
			status = restTemplate.postForObject(url, params, Status.class);
		}
		return status;
	}
}

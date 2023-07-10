package com.cdac.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.FlightDetails;
import com.cdac.entity.Flight;
import com.cdac.repository.FlightRepository;

@Service
@Transactional
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public void addFlight(FlightDetails flightDetails) {
		LocalDate startDate = flightDetails.getStartDate();
		LocalDate endDate = flightDetails.getEndDate();
		
		long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
		
		for(int i=0; i<noOfDays; i++) {
			Flight flight = new Flight();
			/*
			 * flight.setFlightNo(flightDetails.getFlightNo());
			 * flight.setSource(flightDetails.getSource();
			 * ...
			 */
			BeanUtils.copyProperties(flightDetails, flight);
			
			flight.setFlightDate(startDate);
			flight.setAvailableSeats(99);

			flightRepository.save(flight);
			
			startDate = startDate.plus(1, ChronoUnit.DAYS);
		}
	}
	
	public List<Flight> getAvailableFlights() {
		return flightRepository.findAll();
	}
	
	public List<Flight> getAvailableFlights(String source, String destination, LocalDate travelDate) {
		return flightRepository.findAvailableFlights(source, destination, travelDate);
	}
	
	public boolean areSeatsAvailable(String flightNo, LocalDate travelDate, int noOfSeats) {
		return flightRepository.findIfSeatsAvailable(flightNo, travelDate, noOfSeats) == 1;
	}
	
	public void confirmBooking(String flightNo, LocalDate travelDate, int noOfSeats) {
		if(areSeatsAvailable(flightNo, travelDate, noOfSeats))
			flightRepository.blockSeats(noOfSeats, flightNo, travelDate);
	}
}

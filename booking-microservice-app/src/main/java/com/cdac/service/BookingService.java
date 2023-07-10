package com.cdac.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.BookingDetails;
import com.cdac.dto.Status;
import com.cdac.entity.Booking;
import com.cdac.exception.BookingException;
import com.cdac.repository.BookingRepository;

@Service
@Transactional
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FlightServiceCommunicator flightServiceCommunicator;
	
	public int bookFlight(BookingDetails bookingDetails) {
		//first we need to check with the flight-microservice
		//whether enough seats are available or not
		//that means, we need to hit this api from here:
		// --> http://localhost:9001/flights/seats-available?flightNo=AI-123&travelDate=2023-07-15&noOfSeats=100
		//if yes, we need to ask the flight-microservice to block the seats for us
		//that means, now we need to hit this api from here:
		//--> localhost:9001/flights/block-seats
		//then we will store the booking details in the tables for this service
		

		Status status = flightServiceCommunicator.checkAndBlockSeats(bookingDetails);
		if(status.isStatus()) {
			//TODO: fix the code below, the passengers data is not getting copied
			Booking booking = new Booking();
			BeanUtils.copyProperties(bookingDetails, booking);
			booking.setBookingDate(LocalDate.now());
			booking.setNoOfSeats(bookingDetails.getPassengers().size());
			bookingRepository.save(booking);
			return booking.getId();
		}
		throw new BookingException("Booking failed, not enough seats!");
	}
}

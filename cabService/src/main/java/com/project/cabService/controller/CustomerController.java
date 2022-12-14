package com.project.cabService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cabService.dto.BookingRequestDto;
import com.project.cabService.dto.BookingResponseDto;
import com.project.cabService.pojos.Booking;
import com.project.cabService.services.IBookingService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private IBookingService bookingService;
	
	@PostMapping("/bookRide")
	public ResponseEntity<BookingResponseDto> bookRide(@RequestBody BookingRequestDto request){
		Booking booking = bookingService.bookRide(request.getCustomerEmail(), request.getCarForDriverId());
		BookingResponseDto bookingResponse = new BookingResponseDto(booking.getCustomer().getEmail(),booking.getCar().getDriver().getEmail(),booking.getCar().getCar().getName(),booking.getCar().getCar().getNumberPlate());
		return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
	}
}

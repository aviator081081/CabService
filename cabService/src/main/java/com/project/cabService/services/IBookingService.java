package com.project.cabService.services;

import java.util.List;

import com.project.cabService.pojos.Booking;

public interface IBookingService {

	public Booking bookRide(String email,Integer carForDriverId);
	public List<Booking>getAllBookings(String email);
	public Booking cancelRide(Integer id);
	public String cancelBooking(String email);
}

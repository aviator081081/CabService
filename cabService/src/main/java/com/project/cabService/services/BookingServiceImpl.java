package com.project.cabService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cabService.pojos.Booking;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;
import com.project.cabService.repositories.IBookingRepo;
import com.project.cabService.repositories.ICarForDriverRepo;
import com.project.cabService.repositories.IUserRepo;

@Service
public class BookingServiceImpl implements IBookingService {
	@Autowired
	IBookingRepo bookingRepo;

	@Autowired
	ICarForDriverRepo carForDrivrRepo;
	@Autowired
	IUserRepo userRepo;

	@Override
	public Booking bookRide(String email, Integer carForDriverId) {
		CarForDriver carForDriver = carForDrivrRepo.getReferenceById(carForDriverId);
		User customer = userRepo.findByEmail(email);
		if(customer == null) {
			//customer not found exception
		}
		Booking booking = bookingRepo.save(new Booking(customer, carForDriver));
		if(booking == null) {
			//unable to book exception
		}
		return booking;
	}

	@Override
	public List<Booking> getAllBookings(String email) {
		List<Booking> bookingList = bookingRepo.findAllByCustomerEmail(email);
		return bookingList;
	}

	@Override
	public Booking cancelRide(Integer id) {
		Booking booking = bookingRepo.getReferenceById(id);
		if (booking == null) {
			// booking not found exception
		}
		bookingRepo.deleteById(id);
		return booking;
	}

	@Override
	public String cancelBooking(String email) {
		Booking booking = bookingRepo.deleteByEmail(email);
		return null;
	}

}

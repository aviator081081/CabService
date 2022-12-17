package com.project.cabService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cabService.pojos.Booking;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Integer>{
	@Query("select b from Booking b where b.customer = (select u from User u where u.email = ?1)")
	public List<Booking> findAllByCustomerEmail(String email);
	@Transactional
	@Modifying
	@Query("delete from Booking b where b.customer = (select u from User u where u.email = ?1)")
	public Booking deleteByEmail(String email);
	
}

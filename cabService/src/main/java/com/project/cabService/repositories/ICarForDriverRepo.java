package com.project.cabService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.project.cabService.pojos.Car;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;

public interface ICarForDriverRepo extends JpaRepository<CarForDriver, Integer>{
	
	@Transactional
	@Modifying
	@Query("update CarForDriver cfd set cfd.assignedStatus = true where cfd.driver = (select u from User u where u.email = ?1)")
	public void approveByDriverEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update CarForDriver cfd set cfd.assignedStatus = true where cfd.id = ?1")
	public void approveById(Integer id );
	
	@Query("select cfd from CarForDriver cfd where cfd.driver = (select u from User u where u.email = ?1)")
	public CarForDriver findByUserEmail(String email);
	
	@Query("select cfd from CarForDriver cfd where cfd.assignedStatus=0")
	public List<CarForDriver> findAllPendingRequests();
	
	@Query("select cfd from CarForDriver cfd where cfd.assignedStatus=1")
	public List<CarForDriver> findAllApprovedRequests();
	
	@Query("select cfd.driver from CarForDriver cfd where cfd.id = ?1")
	public User findDriver(Integer id);
	
	@Query("select cfd.car from CarForDriver cfd where cfd.driver = (select u from User u where u.email = ?1) and cfd.assignedStatus = false")
	public List<Car> findAllUsedCarsByDriverEmail(String email);
	
	@Transactional
	@Modifying
	@Query("delete from CarForDriver cfd where cfd.driver = (select u.id from User u where u.email = ?1)")
	public void deleteByDriverEmail(String email);

}

package com.project.cabService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.cabService.pojos.Car;


@Repository
public interface ICarRepo extends JpaRepository<Car, Integer>{
	
	@Query("select c from Car c where c.numberPlate = ?1")
	public Car findByNumberPlate(String numberPlate);
}

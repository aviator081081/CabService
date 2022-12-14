package com.project.cabService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cabService.dto.CarForDriverDto;
import com.project.cabService.dto.CarRequestDto;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;
import com.project.cabService.services.ICarForDriverService;
import com.project.cabService.services.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	ICarForDriverService carForDriver;

	@Autowired
	IDriverService driverService;

	@PostMapping("/requestCar")
	public ResponseEntity<CarForDriverDto> requestCar(@RequestBody CarRequestDto requestForCar) {

		CarForDriver requestedEntity = carForDriver.requestCar(requestForCar);
		CarForDriverDto carForDriverDto = new CarForDriverDto(requestedEntity.getId(),
				requestedEntity.getDriver().getEmail(), requestedEntity.getCar().getName(),
				requestedEntity.getCar().getNumberPlate());
		return new ResponseEntity<>(carForDriverDto, HttpStatus.OK);
	}

	@DeleteMapping("/withdraw")
	public ResponseEntity<User> withdrawDriver(@RequestParam String email) {
		User user = driverService.withdraw(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}

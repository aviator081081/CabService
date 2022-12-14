package com.project.cabService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cabService.dto.CarForDriverDto;
import com.project.cabService.pojos.Car;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;
import com.project.cabService.services.IAdminService;
import com.project.cabService.services.ICarForDriverService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	ICarForDriverService carForDriverService;
	
	@GetMapping("/test")
	public void test() {
		System.out.println("tested");
	}
	
	@PostMapping("/addDriver")
	public ResponseEntity<User> addDriver(@RequestBody User user){
		User addedUser = adminService.addUser(user);
		return new ResponseEntity<>(addedUser, HttpStatus.OK);
	}
	
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<User>> getAllDrivers(){
		
		List<User> userList = adminService.getAllUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDriver")
	public ResponseEntity<User> deleteDriver(@RequestParam String email){
		User deletedUser = adminService.deleteUser(email);
		return new ResponseEntity<>(deletedUser,HttpStatus.OK);
	}
	
	@PostMapping("/addCar")
	public ResponseEntity<Car> addCar(@RequestBody Car car){
		Car addedCar = adminService.addCar(car);
		return new ResponseEntity<>(addedCar, HttpStatus.OK);
	}
	
	@GetMapping("/fetchAllCars")
	public ResponseEntity<List<Car>> getAllCars(){
		
		List<Car> carList = adminService.getAllCars();
		return new ResponseEntity<>(carList,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCar")
	public ResponseEntity<Car> deleteCar(@RequestParam String numberPlate){
		Car deletedCar = adminService.deleteCar(numberPlate);
		return new ResponseEntity<>(deletedCar,HttpStatus.OK);
	}
	
	@GetMapping("/approveRequestByEmail")
	public ResponseEntity<CarForDriver> approveRequest(@RequestParam String email){
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		CarForDriver approvedRequest = carForDriverService.approveRequest(email);
		return new ResponseEntity<>(approvedRequest,HttpStatus.OK);
	} 
	@GetMapping("/approveRequestById")
	public ResponseEntity<CarForDriver> approveRequest(@RequestParam Integer id){
		
		CarForDriver approvedRequest = carForDriverService.approveRequest(id);
		return new ResponseEntity<>(approvedRequest,HttpStatus.OK);
	} 
	
	@GetMapping("/getRequestById")
	public ResponseEntity<CarForDriver> fetchRequest(@RequestParam Integer id){
		
		CarForDriver approvedRequest = carForDriverService.getRequest(id);
		return new ResponseEntity<>(approvedRequest,HttpStatus.OK);
	} 
	
	@GetMapping("/getPendingRequests")
	public ResponseEntity<List<CarForDriverDto>> fetchAllPendingRequest(){
		
		List<CarForDriverDto> pendingRequestList = carForDriverService.getAllPendingRequests().stream().map(m -> new CarForDriverDto(m.getId(),m.getDriver().getEmail(),m.getCar().getName(),m.getCar().getNumberPlate()) ).toList();;
		return new ResponseEntity<>(pendingRequestList,HttpStatus.OK);
	} 
	
	@GetMapping("/getApprovedRequests")
	public ResponseEntity<List<CarForDriverDto>> fetchAllApprovedRequest(){
		
		List<CarForDriverDto> approvedRequestList = carForDriverService.getAllApprovedRequests().stream().map(m -> new CarForDriverDto(m.getId(),m.getDriver().getEmail(),m.getCar().getName(),m.getCar().getNumberPlate()) ).toList();
		return new ResponseEntity<>(approvedRequestList,HttpStatus.OK);
	} 

}

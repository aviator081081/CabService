package com.project.cabService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cabService.dto.CarRequestDto;
import com.project.cabService.pojos.Car;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;
import com.project.cabService.repositories.ICarForDriverRepo;
import com.project.cabService.repositories.ICarRepo;
import com.project.cabService.repositories.IUserRepo;

@Service
public class CarForDriverServiceImpl implements ICarForDriverService {

	@Autowired
	ICarForDriverRepo carForDriverRepo;

	@Autowired
	ICarRepo carRepo;

	@Autowired
	IUserRepo userRepo;

	@Override
	public CarForDriver requestCar(CarRequestDto request) {

		User driver = userRepo.findByEmail(request.getDriverEmail());

		if (driver == null) {
			// throw driver not found exception
		}

		Car car = carRepo.findByNumberPlate(request.getNumberPlate());

		if (car == null) {
			// throw car not found exception
		}
		CarForDriver requestedCarForDriver = carForDriverRepo.save(new CarForDriver(driver, car));
//		return requestedCarForDriver;
		return requestedCarForDriver;
	}

	@Override
	public CarForDriver approveRequest(String email) {
		carForDriverRepo.approveByDriverEmail(email);
//		CarForDriver approvedCar = carForDriverRepo.getReferenceById(id);
		CarForDriver approvedCar = carForDriverRepo.findByUserEmail(email);
		return approvedCar;
	}

	@Override
	public CarForDriver approveRequest(Integer id) {
		carForDriverRepo.approveById(id);
		CarForDriver approvedCar = carForDriverRepo.findById(id).get();

//		return approvedCar;
		return approvedCar;
	}

	@Override
	public CarForDriver getRequest(Integer id) {
		CarForDriver approvedCar = carForDriverRepo.findById(id).get();
		return approvedCar;
	}

	@Override
	public List<CarForDriver> getAllPendingRequests() {
		List<CarForDriver> list = carForDriverRepo.findAllPendingRequests();
		return list;
	}

	@Override
	public List<CarForDriver> getAllApprovedRequests() {
		List<CarForDriver> list = carForDriverRepo.findAllApprovedRequests();
		return list;
	}

	@Override
	public User getDriver(Integer id) {
		User user = carForDriverRepo.findDriver(id);
		return user;
	}

}

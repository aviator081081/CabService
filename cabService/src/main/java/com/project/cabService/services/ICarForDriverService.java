package com.project.cabService.services;

import java.util.List;

import com.project.cabService.dto.CarRequestDto;
import com.project.cabService.pojos.CarForDriver;
import com.project.cabService.pojos.User;

public interface ICarForDriverService {
	public CarForDriver requestCar(CarRequestDto carForDriver);
	public CarForDriver approveRequest(String email); //email of driver
	public CarForDriver approveRequest(Integer id); //id of carForDriver entity
	public CarForDriver getRequest(Integer id);
	public List<CarForDriver> getAllPendingRequests();
	public List<CarForDriver> getAllApprovedRequests();
	public User getDriver(Integer id);
}

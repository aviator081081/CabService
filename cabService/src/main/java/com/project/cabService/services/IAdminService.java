package com.project.cabService.services;

import java.util.List;

import com.project.cabService.pojos.Car;
import com.project.cabService.pojos.User;

public interface IAdminService {
	public List<User> getAllUser();
	public User addUser(User user);
	public User deleteUser(String email);
	public User getUser(Integer id);
	public User getUser(String email);
	
	public Car addCar(Car car);
	public Car getCar(Integer id);
	public Car getCar(String numberPlate);
	public List<Car>getAllCars();
	public Car deleteCar(String NumberPlate);
}

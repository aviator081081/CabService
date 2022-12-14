package com.project.cabService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cabService.pojos.Car;
import com.project.cabService.pojos.User;
import com.project.cabService.repositories.ICarRepo;
import com.project.cabService.repositories.IUserRepo;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	IUserRepo userRepo;

	@Autowired
	ICarRepo carRepo;

	@Override
	public List<User> getAllUser() {

		List<User> userList = userRepo.findAll();

		return userList;
	}

	@Override
	public User addUser(User user) {
		Optional<User> oUser = getAllUser().stream().filter(u -> u.getEmail().equals(user.getEmail())).findFirst();

		if (!oUser.isEmpty()) {
			// throw useralreadypresentexception;
		}
		User user1 = userRepo.save(user);
		return user1;
	}

	@Override
	public User deleteUser(String email) {

		User user = getUser(email);

		if (user == null) {
			// throw usernotfoundexception
		}
		userRepo.delete(user);
		return user;

	}

	@Override
	public User getUser(Integer id) {
		User user = userRepo.getReferenceById(id);
		return user;
	}

	@Override
	public User getUser(String email) {
		User user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public Car addCar(Car car) {
		Optional<Car> oCar = getAllCars().stream().filter(c -> c.getNumberPlate().equals(car.getNumberPlate()))
				.findFirst();
		if (!oCar.isEmpty()) {
			// throw car already present exception
		}
		Car addedCar = carRepo.save(car);
		return addedCar;
	}

	@Override
	public Car getCar(Integer id) {
		Car car = carRepo.getReferenceById(id);
		if (car == null) {
			// throw car not exception
		}
		return car;
	}

	@Override
	public Car getCar(String numberPlate) {
		Car car = carRepo.findByNumberPlate(numberPlate);
		if (car == null) {
			// throw car not exception
		}
		return car;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> carList = carRepo.findAll();

		return carList;
	}

	@Override
	public Car deleteCar(String numberPlate) {
		Car car = carRepo.findByNumberPlate(numberPlate);
		carRepo.delete(car);
		return car;
	}

}

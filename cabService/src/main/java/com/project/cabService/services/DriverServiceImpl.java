package com.project.cabService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cabService.pojos.User;
import com.project.cabService.repositories.ICarForDriverRepo;
import com.project.cabService.repositories.IUserRepo;
@Service
public class DriverServiceImpl implements IDriverService{

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private ICarForDriverRepo carForDriverRepo;
	
	@Override
	public User withdraw(String email) {
		User user = userRepo.findByEmail(email);
		carForDriverRepo.deleteByDriverEmail(email);
		Integer id = userRepo.deleteByEmail(email);
		if(user == null && id != 1) {
			//usernot found exception
		}
		
		return user;
	}

}

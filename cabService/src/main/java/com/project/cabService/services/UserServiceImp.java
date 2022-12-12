package com.project.cabService.services;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.cabService.pojos.User;
import com.project.cabService.repositories.IUserRepo;

public class UserServiceImp implements IUserService {

	@Autowired
	IUserRepo userRepo;
	
	@Override
	public List<User> getAllUser() {
		
		List<User> userList = userRepo.findAll();
		
		return userList;
	}

	@Override
	public User addUser(User user) {
		User user1 = userRepo.save(user);
		return user1;
	}

	@Override
	public User deleteUser(Integer id) {
		
		User user = getUser(id);
		
		if(user == null) {
			//throw usernotfoundexception
		}
		userRepo.delete(user);
		return user;
			
	}

	@Override
	public User getUser(Integer id) {
		User user = userRepo.getReferenceById(id);
		return user;
	}

}

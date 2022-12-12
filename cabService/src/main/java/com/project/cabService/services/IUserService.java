package com.project.cabService.services;

import java.util.List;

import com.project.cabService.pojos.User;

public interface IUserService {
	public List<User> getAllUser();
	public User addUser(User user);
	public User deleteUser(Integer id);
	public User getUser(Integer id);
}

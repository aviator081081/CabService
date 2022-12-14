package com.project.cabService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cabService.pojos.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email = ?1")
	public User findByEmail(String email);

	@Transactional
	@Modifying
	@Query("delete from User u where u.email=?1")
	public Integer deleteByEmail(String email);
}

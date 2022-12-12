package com.project.cabService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cabService.pojos.User;
@Repository
public interface IUserRepo extends JpaRepository<User, Integer>{

}

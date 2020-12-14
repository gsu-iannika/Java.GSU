package com.by.gsu.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.by.gsu.pms.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUserNameAndUserPassword(String userName, String password);

}

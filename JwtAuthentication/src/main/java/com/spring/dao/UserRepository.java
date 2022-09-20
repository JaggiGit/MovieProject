package com.spring.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select u from User u where u.userEmail =:email")  
	public User getUserByName(@Param("email")  String username ) ;
	
}

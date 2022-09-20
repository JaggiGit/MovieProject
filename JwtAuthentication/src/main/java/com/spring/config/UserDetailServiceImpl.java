package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.dao.UserRepository;
import com.spring.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo ;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepo.getUserByName(userName) ;
		
		if(user==null)
		{
			throw new UsernameNotFoundException("could not find user!!") ;
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	
	}

}

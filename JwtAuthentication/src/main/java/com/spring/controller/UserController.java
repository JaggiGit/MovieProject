package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
	
	
	@RequestMapping("/")
	public String welcome()
	{
		return "Hello Welcome" ;
	}
	
	
}

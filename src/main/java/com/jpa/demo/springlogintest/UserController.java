package com.jpa.demo.springlogintest;

import java.util.Optional;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController
{
	
	@Autowired
	Userservice userservice;
	
	
	
	
	@GetMapping("/hello")
	public String test()
	{
	    	return "hello welcome";
	}
	
	@GetMapping("/user/{id}")
	public Userinfo checkinfo(@PathVariable int id )
	{
		return userservice.checkUser(id);
		
	}
	@PostMapping("/adduser")
	public String addinfo(@RequestBody Userinfo user)
	{
		return userservice.adduser(user);
	}
	

	
	
}	
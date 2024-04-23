package com.jpa.demo.springlogintest;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice 
{
    
	@Autowired
	Userrepository userrepo;

    
   


	public String adduser(Userinfo user) 
	{
//		String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));	
//		user.setPassword(decodedPassword);
		Optional<Userinfo> existingUser = userrepo.findByUsername(user.getUsername());
	    
	    if (existingUser.isPresent()) {
	        
	        return "Username already exists: " + existingUser.get().getUsername();
	    } else {
	        Userinfo u = userrepo.save(user);
	        return "User added successfully:"+ u;
	    }
	}




	public  Userinfo checkUser(int id) 
	{
		Optional <Userinfo> opt= userrepo.findById(id);
	   
		if(opt.isPresent())
		{
			return opt.get();
		}
		return null;
		
	}
}

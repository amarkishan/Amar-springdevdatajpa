@PostMapping("/register")
//	public void Adduser(@RequestBody Userinfo user)
//	{
//		
//		
//		String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));
//		Optional <Userinfo>  u= userrepo.findByUsername(user.getUsername());
//		
//		user.setPassword(decodedPassword);
//		if(!u.isPresent())
//		{
//			userrepo.save(user);
//		}

           else
           {
              return null
           }

}

//			
	}	
		
		
http://localhost:9094:/hello
http://localhost:9094:/adduser
http://localhost:9094/user		'
//
INSERT INTO Userinfo (id, username, email, password, firstName, lastName)
VALUES (1, 'rhythm', 'some@example.com', NULL, 'amar', 'test');
		
INSERT INTO userinfo (id, username, email, password, first_name, last_name)
VALUES (1, 'rhythm', 'some@example.com', NULL, 'amar', 'test');
		
		
		@PostMapping("/adduser")
	public String addinfo(@RequestBody Userinfo user)
	{
		return userservice.adduser(user);
	}
	
		public String adduser(Userinfo user) 
	{
		String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));	
		user.setPassword(decodedPassword);
		Optional<Userinfo> existingUser = userrepo.findByUsername(user.getUsername());
	    
	    if (existingUser.isPresent()) {
	        
	        return "Username already exists: " + existingUser.get().getUsername();
	    } else {
	        Userinfo u = userrepo.save(user);
	        return "User added successfully"+ u;
	    }
	}
		
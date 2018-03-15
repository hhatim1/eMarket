package com.hhatim.login.services;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hhatim.login.models.Users;
import com.hhatim.login.repositories.LogRepository;

@Service
public class LogService {
	
	private LogRepository lRepo;
	public LogService(LogRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	public Object loginUser(String email, String password) {
		Users user = lRepo.findByEmail(email);
		//System.out.println(user); void above 
		if(user == null) {
			return "User email not found in database";
		} else {		
			if (BCrypt.checkpw(password, user.getPassword())) {
			    System.out.println("It matches");
				return user;
			} else {	
			    System.out.println("It does not match");
			    return "User password doesn't work!";
		  }		
	   }		
    }
}


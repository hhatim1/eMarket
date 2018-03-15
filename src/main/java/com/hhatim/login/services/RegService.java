package com.hhatim.login.services;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hhatim.login.models.Users;
import com.hhatim.login.repositories.LogRepository;
import com.hhatim.login.repositories.RegRepository;

@Service
public class RegService {
	
	private RegRepository regRepo;
	private LogRepository logRepo;
	public RegService(RegRepository regRepo, LogRepository lr) {
		this.regRepo = regRepo;
		logRepo = lr;
	}
	public Object registerUser(String c_pass, Users user, RedirectAttributes redirectAttributes) {
		//check to see if the user.email already exists in the database
		boolean userExists = false;
		//if(logRepo.findByEmail(user.getEmail()) instanceof Users) {
		if(logRepo.findByEmail(user.getEmail()) != null) {
			userExists = true;
			redirectAttributes.addFlashAttribute("errors", "email already in use");
		}
		
		if(c_pass.equals(user.getPassword()) && !userExists) {
			//passwords match, encode password
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			return regRepo.save(user);
		}else {
//			send errors;
			return "errors";
			
		}
		
	}

}

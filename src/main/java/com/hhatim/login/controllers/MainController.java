package com.hhatim.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hhatim.login.models.Users;
import com.hhatim.login.services.LogService;
import com.hhatim.login.services.RegService;



@Controller

 public class MainController {

	private RegService rService;
	private LogService lService;
	public MainController(RegService rService, LogService lService) {
		this.rService = rService;
		this.lService = lService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") Users user, @ModelAttribute("errors") String errors) {
		return "home.jsp";
	}
	
	@PostMapping("/register/user")
	public String saveUser(@Valid@ModelAttribute("user")Users user, BindingResult result, @RequestParam(value="c_password")String c_pass, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()){
			redirectAttributes.addFlashAttribute("errors", "registration errors");
			return "home.jsp";
		}
		rService.registerUser(c_pass, user, redirectAttributes);
		return "redirect:/";
		//System.out.println(user.c_password);					
	}
	@PostMapping("/login_user")
	public String loginUser(@RequestParam(value="email")String email, @RequestParam(value="password")String password, HttpSession session, RedirectAttributes redirectAttributes) {
		Object val = lService.loginUser(email, password);
		if (val instanceof String) {
			redirectAttributes.addFlashAttribute("log", val);	
		    return "redirect:/";	
	    }
		return "redirect:/dashboard";		
	}
/////////////////////////////////////////////////
	@PostMapping("/logout_user")
	public String logoutUser(HttpSession session, RedirectAttributes redirectAttributes) {
		return "redirect:/";
		
		}	
}
////////////////////////////////////////////









package com.FlightReservation_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation_app.entity.User;
import com.FlightReservation_app.repository.UserRepository;
import com.FlightReservation_app.service.SecurityService;


@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	SecurityService securityService;
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		LOGGER.warn("inside showLogin Method");
		return "login/login";
	}
	@RequestMapping("/showReg")
	public String showRegistration() {
		LOGGER.info("inside showReg Method");
		return "login/showReg";
	}
	@RequestMapping("/saveRegistration")
	public String saveReg(@ModelAttribute("User") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login/login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "login/findFlights";
		}else {
			modelMap.addAttribute("msg", "Invalid UserName and Password");
			return "login/login";
		}
//		User user = userRepo.findByEmail(email);
//		if(user!=null) {
//		if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
//			return "login/findFlights";
//		}else {
//			modelMap.addAttribute("msg", "Invalid UserName and Password");
//		return "login/login";
//		}
//		}else {
//			modelMap.addAttribute("msg", "Invalid UserName and Password");
//			return "login/login";
//		
//		}
	}
	

}

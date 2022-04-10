package com.FlightReservation_app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.FlightReservation_app.entity.User;
import com.FlightReservation_app.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user1 = userRepo.findByEmail(username);
		if(user1==null) {
			new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user1.getEmail(), user1.getPassword(), user1.getRoles());//This user class is built in
	}

}
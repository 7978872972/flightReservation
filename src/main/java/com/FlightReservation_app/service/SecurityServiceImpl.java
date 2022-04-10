package com.FlightReservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	@Autowired
 	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		//if all details true it will generate one token then pass the token it will authenticate then return the result.
		authenticationManager.authenticate(token);
		boolean result = token.isAuthenticated();
		return result;
	}

}

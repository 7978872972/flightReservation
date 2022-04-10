package com.FlightReservation_app.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/showReg","/","/index.html","/verifyLogin","/showLogin","/saveRegistration","/login/*")//User can access
		.permitAll()
		.antMatchers("/admin/showAddFlight")
		.hasAnyAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable();
	}

}

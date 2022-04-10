package com.FlightReservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}

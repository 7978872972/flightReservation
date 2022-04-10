package com.FlightReservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation_app.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}

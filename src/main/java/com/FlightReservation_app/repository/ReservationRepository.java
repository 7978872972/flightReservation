package com.FlightReservation_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation_app.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

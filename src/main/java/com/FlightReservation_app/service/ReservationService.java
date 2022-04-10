package com.FlightReservation_app.service;


import com.FlightReservation_app.dto.ReservationRequest;
import com.FlightReservation_app.entity.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);

}

package com.FlightReservation_app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FlightReservation_app.dto.ReservationRequest;
import com.FlightReservation_app.entity.Flight;
import com.FlightReservation_app.entity.Passenger;
import com.FlightReservation_app.entity.Reservation;
import com.FlightReservation_app.repository.FlightRepository;
import com.FlightReservation_app.repository.PassengerRepository;
import com.FlightReservation_app.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		
		Long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);//flightDetails save in the flight details first we will get the flight details then we save in the passenger table
		Flight flight = findById.get();
		
		Reservation r = new Reservation();
		r.setFlight(flight);
		r.setPassenger(passenger);
		r.setCheckedIn(false);
		r.setNumberOfBags(0);
		reservationRepo.save(r);
		
		return r;
	}

}

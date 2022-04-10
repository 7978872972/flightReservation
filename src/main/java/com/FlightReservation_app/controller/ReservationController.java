package com.FlightReservation_app.controller;

import javax.management.relation.RelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FlightReservation_app.dto.ReservationRequest;
import com.FlightReservation_app.entity.Reservation;
import com.FlightReservation_app.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
		
	}

}

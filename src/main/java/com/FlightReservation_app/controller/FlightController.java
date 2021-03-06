package com.FlightReservation_app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation_app.entity.Flight;
import com.FlightReservation_app.repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlight")
	public String findFlight(@RequestParam("From") String from,@RequestParam("To") String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,ModelMap modelMap) {
		List<Flight> findFlights = flightRepo.findFlights(from,to,departureDate);
		modelMap.addAttribute("findFlights", findFlights);
		return "dispalyFlights";
	}
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		modelMap.addAttribute("flight", flight);
		return "showReservation";
	}
	@RequestMapping("/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}

}


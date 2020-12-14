package com.by.gsu.pms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.by.gsu.pms.entity.Registration;
import com.by.gsu.pms.model.PassengerModel;
import com.by.gsu.pms.service.RegistrationService;
import com.by.gsu.pms.service.FlightService;
import com.by.gsu.pms.validation.FlightNotAvailableException;
import com.by.gsu.pms.validation.UserNotFoundException;

@RestController
@RequestMapping("/booking")
public class RegistrationController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	RegistrationService registrationService;

	@PostMapping("/flight")
	public ResponseEntity<?> doFlightBooking(@RequestParam(value="flightId") Long flightId, @RequestParam(value="userId") Long userId, @RequestBody List<PassengerModel> passengerList) throws Exception{

		Registration registration = new Registration();

			try {
				registration = registrationService.doFlightBooking(userId, flightId, passengerList);
			} 
			catch (FlightNotAvailableException | UserNotFoundException e) {
				return new ResponseEntity<>("Invalid Operation "+e.getMessage(),HttpStatus.BAD_REQUEST);
			}

		return new ResponseEntity<>(registration,HttpStatus.OK);
	}

}

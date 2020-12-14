package com.by.gsu.pms.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.gsu.pms.entity.Registration;
import com.by.gsu.pms.entity.Flight;
import com.by.gsu.pms.entity.Passenger;
import com.by.gsu.pms.entity.User;
import com.by.gsu.pms.model.PassengerModel;
import com.by.gsu.pms.repo.RegistrationRepository;
import com.by.gsu.pms.repo.PassengerRepository;
import com.by.gsu.pms.repo.UserRepository;
import com.by.gsu.pms.utils.FareUtils;
import com.by.gsu.pms.validation.FlightNotAvailableException;
import com.by.gsu.pms.validation.UserNotFoundException;
import com.by.gsu.pms.validation.Validation;

@Service
public class RegistrationService
{
	
	@Autowired
	RegistrationRepository bookingrepository;
	
	@Autowired PassengerRepository passengerrepository;
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Validation validation;
	
	@Autowired
	FareUtils fareUtils;
	
	public Registration doFlightBooking(Long userId, Long fligtId , List<PassengerModel> passengers) throws Exception
	{
		
		Flight flight = null;
		User user =  null;
		Registration booked = null;
		
		Optional<Flight> flightOptional  =  flightService.findById(fligtId);
		boolean isFlightByAvailableSeats = false;

		if(flightOptional.isPresent()) 
		{
			flight  = flightOptional.get();
			isFlightByAvailableSeats = validation.validateFlightByAvailableSeats(flight.getAvailableSeats(),passengers.size());
		}
		else
		{
			throw new FlightNotAvailableException(" Flight not available ");
		}
		
		Optional<User> userOptional  =  userRepository.findById(userId);
		
		if(userOptional.isPresent()) 
		{
			user  = userOptional.get();
		}
		else
		{
			throw new UserNotFoundException("You have enter wrong User Id");
		}
		
		if(isFlightByAvailableSeats)
		{
			List <Passenger> passengerList = mappingPassengerModelListToPassengerList(passengers);

			Double totalFare = fareUtils.calculateTotalFare(flight.getFare(),passengers.size());
			
			Registration registration = new Registration();
			registration.setDate(LocalDate.now());
//			registration.setPassportNumber();
			registration.setUser(user);
			registration.setFlight(flight);
			registration.setTotalFare(totalFare);
			registration.setPassengers(passengerList);
			booked=bookingrepository.save(registration);
			
			try {
			flightService.updateFlightByNumberOfSeats(flight, passengers.size());
			}catch(Exception ex) {
				throw new Exception("Flight Entity not updated");
			}
			
		}
		else
		{
			throw new FlightNotAvailableException(" Seats not available ");
		}
		
		return booked;
		
		
		
	}

	private void createPassenger(List<Passenger> passengerList, Registration booking) {
		for(Passenger passenger:passengerList)
		{
			passenger.setBooking(booking);
			passengerrepository.save(passenger);
		}
			
		
	}

	private List<Passenger> mappingPassengerModelListToPassengerList(List<PassengerModel> passengers) 
	{
		List<Passenger> passangerList = new ArrayList<>();
		
		for(PassengerModel passModel: passengers)
		{
			Passenger pass = new Passenger();
			pass.setPassengerAge(passModel.getPassengerAge());
			pass.setPassengerGender(passModel.getPassengerGender());
			pass.setPassengerName(passModel.getPassengerName());
			
			passangerList.add(pass);
		}
		return passangerList;
		
	}

	
}

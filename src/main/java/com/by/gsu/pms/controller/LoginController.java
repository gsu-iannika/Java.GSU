package com.by.gsu.pms.controller;

import com.by.gsu.pms.builder.ReportBuilder;
import com.by.gsu.pms.repo.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.by.gsu.pms.service.UserService;
import com.by.gsu.pms.validation.Validation;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	Validation validation;

	@GetMapping("/user")
	public ResponseEntity<?> validateUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {
		try {
			if (validation.validateUser(userName, password)) {

				return new ResponseEntity<>(userService.loginUser(userName, password), HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("username/password cannot be empty", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid Credential : " + e.getMessage(), HttpStatus.UNAUTHORIZED);

		}

	}

	@Autowired
	private RegistrationRepository registrationRepository;

	@GetMapping(value = "/file")
	public void getFile(
			@RequestParam(name = "withNames") boolean withNames,
			@RequestParam(name = "withDates") boolean withDates,
			@RequestParam(name = "withPassport") boolean withPassport,
			@RequestParam(name = "withFlight") boolean withFlight,
			@RequestParam(name = "withFare") boolean withFare,

			HttpServletResponse response) {
		ReportBuilder rb = new ReportBuilder(registrationRepository);

		Thread[] threads = new Thread[4];
		threads[0] = new Thread(() -> {
			if(withFlight) rb.withFlight();
		});
		threads[1] = new Thread(() -> {
			if(withDates) rb.withDates();
		});
		threads[2] = new Thread(() -> {
			if(withNames) rb.withNames();
		});
		threads[3] = new Thread(() -> {
			if(withPassport) rb.withPassport();
		});

		for (Thread t: threads) { // parallel execution of files processing
			t.start(); // method "start" executes method "run" (which was override before) in the other thread
		}

		for (Thread t: threads) {
			try {
				t.join(); // waiting for every Thread finishes
			} catch (InterruptedException e) {
				System.out.println("Threads failed :(");
			}
		}


	}

}

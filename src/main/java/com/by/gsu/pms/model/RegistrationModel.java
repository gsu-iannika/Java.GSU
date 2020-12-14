package com.by.gsu.pms.model;

import java.time.LocalDate;
import java.util.Date;


public class RegistrationModel {


	private String passportNumber;
	private Long flightId;
	private Long userId;
	private LocalDate date;
	private Integer totalFare;
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Integer totalFare) {
		this.totalFare = totalFare;
	}
	public RegistrationModel(String passportNumber, Long flightId, Long userId, LocalDate date,
							 Integer totalFare) {
		super();
		this.passportNumber = passportNumber;
		this.flightId = flightId;
		this.userId = userId;
		this.date = date;
		this.totalFare = totalFare;
	}
	public RegistrationModel() {
		super();
	}
	
	
}

package com.by.gsu.pms.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "registration")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "registrationId")
public class Registration {

	private String passportNumber;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registration_id", nullable = false)
	private Long registrationId;

	@Column(name = "passport_number", nullable = false)
	private String registrationNumber;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "total_fare", nullable = false)
	private Double totalFare;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
	Flight flight;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "registration")
	List<Passenger> passengers;

	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public Registration(Long registrationId, String passportNumber, LocalDate date, Double totalFare,
						User user, Flight flight, List<Passenger> passengers) {
		super();
		this.registrationId = registrationId;
		this.passportNumber = passportNumber;
		this.date = date;
		this.totalFare = totalFare;
		this.user = user;
		this.flight = flight;
		this.passengers = passengers;
	}
	public Registration() {
		super();
	}
	
	public Registration(Long registrationId, String passportNumber, LocalDate date, Double totalFare,
						User user, Flight flight) {
		super();
		this.registrationId = registrationId;
		this.passportNumber = passportNumber;
		this.date = date;
		this.totalFare = totalFare;
		this.user = user;
		this.flight = flight;
	}


}

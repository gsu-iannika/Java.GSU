package com.by.gsu.pms.utils;

import org.springframework.stereotype.Component;

@Component
public class FareUtils {
	
	public Double calculateTotalFare(Double fare, Integer numberOfPassengers) {
		return (fare*numberOfPassengers);
	}

}

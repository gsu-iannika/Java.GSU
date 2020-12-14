package com.by.gsu.pms.utils;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class OptionalUtils {

	public static Object checkOptional(Optional<?> optionalObject) {
		
		Object object = null;
		
		if(optionalObject.isPresent())
		{
			object = optionalObject.get();
			return object;
		}
			
		else
			return object;	
	}

}

package com.in28minutes.learnspringframework.examples.c1;

// GameRunner
import java.util.Arrays;

import org.springframework.stereotype.Service;


//@Component
@Service
public class BusinessCalculationService {
	
	private DataService dataService;
	
	// Constructor Injection
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData())
				.max().orElse(0);
	}
	
}

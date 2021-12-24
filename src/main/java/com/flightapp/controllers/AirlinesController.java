package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.AirlinesModel;
import com.flightapp.services.AirlinesDynamoService;
import com.flightapp.services.AirlinesService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/flight")
public class AirlinesController {
	
//	@Autowired
//	AirlinesService service;
	@Autowired
	AirlinesDynamoService service;
	@PostMapping("/airline/inventory/add")
	public AirlinesModel createFlight(@RequestBody AirlinesModel model) {
		
		return service.createFlight(model);
	}
	@GetMapping("/airlines")
	public List<AirlinesModel> getFlights() {
		
		return service.getFlights();
	}
	
	@PutMapping("/airlines")
	public AirlinesModel editFlight(@RequestBody AirlinesModel model) {
		
		return service.editFlight(model);
	}
	
}

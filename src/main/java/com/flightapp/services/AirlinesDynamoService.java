package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.AirlinesModel;
import com.flightapp.repository.AirlinesDynamoRepository;

@Service
public class AirlinesDynamoService {
	
	@Autowired
	private AirlinesDynamoRepository repo;

	public AirlinesModel createFlight(AirlinesModel model) {
		// TODO Auto-generated method stub
		return repo.createFlight(model);
	}

	public AirlinesModel editFlight(AirlinesModel model) {
		// TODO Auto-generated method stub
		return repo.editFlight(model);
	}

	public List<AirlinesModel> getFlights() {
		// TODO Auto-generated method stub
		return repo.getFlights();
	}
}

package com.flightapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.flightapp.entities.AirlinesModel;

@Repository
public class AirlinesDynamoRepository {
	
	private  DynamoDBMapper mapper;
	@Autowired
    public AirlinesDynamoRepository(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

	

	public AirlinesModel editFlight(AirlinesModel model) {
		// TODO Auto-generated method stub
		mapper.save(model,
				new DynamoDBSaveExpression()
				.withExpectedEntry("flightNo",
						new ExpectedAttributeValue(
								new AttributeValue().withS(model.getFlightNo()))) );
		return model;
	}

	public List<AirlinesModel> getFlights() {
		// TODO Auto-generated method stub
		return mapper.scan(AirlinesModel.class, new DynamoDBScanExpression());
	}

	public AirlinesModel createFlight(AirlinesModel model) {
		// TODO Auto-generated method stub
		mapper.save(model);
		return model;
	}
	
}

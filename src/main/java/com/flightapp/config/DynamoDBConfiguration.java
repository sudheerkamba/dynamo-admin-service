package com.flightapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAWSDb());
	}
	
	public AmazonDynamoDB buildAWSDb()
	{
		return AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								"dynamodb.us-east-2.amazonaws.com", "us-east-2"))
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials("AKIA6IMXU2BTIVHSCC5V","EuamXLkzvEAjy8iAxsZF8nTE+KypHG6B4HcnL5dp")))
				.build();
	}
	
	
}

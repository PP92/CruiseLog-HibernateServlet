package com.pp.service;

import com.github.javafaker.Faker;
import com.pp.model.Cruise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CruiseService {
	private static CruiseService cruiseService = null;
	private final Logger logger = LoggerFactory.getLogger(CruiseService.class);

	// singleton
	public static CruiseService getInstance() {
		if (cruiseService == null)
			cruiseService = new CruiseService();

		return cruiseService;
	}

	public Cruise getRandomCruise() {
		Faker faker = new Faker();
		Random random = new Random();

		Cruise randomCruise = new Cruise();
		String captainName = faker.name().fullName();
		int distance = random.nextInt(100) + 100;

		List<String> locations = new ArrayList<>();
		locations.add("Chorwacja");
		locations.add("Grecja");
		locations.add("Majorka");
		locations.add("Bałtyk");
		locations.add("Sycylia");

		String location = locations.get(random.nextInt(locations.size()));

		randomCruise.setCaptainName(captainName);
		randomCruise.setLocation(location);
		randomCruise.setDistance(distance);
		logger.info("Wylosowano rejs - kapitan: " + randomCruise.getCaptainName());
		return randomCruise;
	}
}

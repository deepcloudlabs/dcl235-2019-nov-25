package com.example.world.app;

import com.example.world.domain.City;
import com.example.world.domain.Country;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteCountryToJson {

	public static void main(String[] args) throws Exception {
		Country turkey = new Country("TUR", "Turkey", "Asia", 1, 2, 3);
		City ankara = new City(turkey, 1, "Ankara", 1);
		City istanbul = new City(turkey, 2, "Istanbul", 2);
		turkey.setCapital(ankara);
		turkey.getCities().add(ankara);
		turkey.getCities().add(istanbul);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(turkey);
		System.out.println(json);
	}

}

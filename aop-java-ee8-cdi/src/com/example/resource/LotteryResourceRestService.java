package com.example.resource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.aop.Profile;
import com.example.service.LotteryService;

@Path("numbers")
public class LotteryResourceRestService {

	@Inject
	private LotteryService lotteryService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Profile(TimeUnit.NANOSECONDS)
	public List<List<Integer>> getLotteryNumbers(@QueryParam("min") int min, @QueryParam("max") int max,
			@QueryParam("size") int size, @QueryParam("length") int length) {
		return lotteryService.draw(min, max, size, length);
	}

}

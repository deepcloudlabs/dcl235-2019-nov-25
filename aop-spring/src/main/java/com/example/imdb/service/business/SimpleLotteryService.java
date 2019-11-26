package com.example.imdb.service.business;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import com.example.imdb.service.LotteryService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class SimpleLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int min, int max, int size) {
		return new SecureRandom().ints(min, max).distinct().limit(size).sorted().boxed().collect(Collectors.toList());
	}

}

package com.example.service.business;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.example.aop.Profile;
import com.example.service.LotteryService;
import com.example.service.RandomNumberGenerator;

@Named
@Singleton
public class StandardLotteryService implements LotteryService {

	@Inject
	private RandomNumberGenerator randomNumberGenerator;

	@Override
	@Profile(TimeUnit.MILLISECONDS)
	public List<Integer> draw(int min, int max, int size) {
		return IntStream.generate(() -> this.randomNumberGenerator.generateRandomInt(min, max)).distinct().limit(size)
				.sorted().boxed().collect(Collectors.toList());
	}

	@Override
	@Profile(TimeUnit.MILLISECONDS)
	public List<List<Integer>> draw(int min, int max, int size, int length) {
		return IntStream.range(0, length).mapToObj(i -> this.draw(min, max, size)).collect(Collectors.toList());
	}

}

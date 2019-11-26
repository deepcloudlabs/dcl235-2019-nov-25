package com.example.service;

import java.util.List;

public interface LotteryService {
	List<Integer> draw(int min, int max, int size);

	List<List<Integer>> draw(int min, int max, int size, int length);
}

package com.example.imdb.service;

import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface LotteryService {
	List<Integer> draw(int min, int max, int size);
}

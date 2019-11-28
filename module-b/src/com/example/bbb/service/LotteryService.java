package com.example.bbb.service;

import java.util.List;

public interface LotteryService {
	List<Integer> draw(int min,int max,int size);
}

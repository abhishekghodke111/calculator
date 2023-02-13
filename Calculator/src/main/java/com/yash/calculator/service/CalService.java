package com.yash.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.calculator.model.Numbers;
import com.yash.calculator.repository.CalRepo;

@Service
public class CalService {

	@Autowired
	CalRepo calrepo;

	public Numbers saveHistory(Numbers numbers) {
		return calrepo.save(numbers);
	}

	public List<Numbers> historyList() {
		List<Numbers> history = new ArrayList<>();
		calrepo.findAll().forEach(history::add);
		return history;

	}

}

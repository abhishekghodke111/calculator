package com.yash.calculator.controller;

import java.util.List;
import java.util.regex.Pattern;
import java.lang.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.calculator.model.Numbers;
import com.yash.calculator.repository.CalRepo;
import com.yash.calculator.service.CalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/userapi")
public class CalController {

	@Autowired
	CalService calservice;

	@Autowired
	CalRepo calrepo;

	@PostMapping("/add")
	public Numbers addition(@RequestBody Numbers objnum) {
		double sum = 0;
		String s = objnum.getInserted();
		String[] ss = s.split(Pattern.quote(objnum.getSign()));
		int i = 1;
		while (i < ss.length) {
			System.out.println(ss[i]);
			i = i + 1;
		}

		double numOne = Double.parseDouble(ss[0]);
		double numTwo = Double.parseDouble(ss[1]);
		String check = objnum.getSign();
		char che = check.charAt(0);
		System.out.println(objnum.getSign());
		System.out.println(che);
		if (che == '+') {
			sum = numOne + numTwo;
		} else if (che == '-') {
			sum = numOne - numTwo;
		} else if (che == 'x') {
			sum = numOne * numTwo;
		} else if (che == '÷') {
			sum = numOne / numTwo;
		} else if (che == '^') {
			sum = Math.pow(numOne, numTwo);
		}

		else if (che == '%') {
			sum = numOne * numTwo / 100;
		} else if (che == '√') {
			sum = Math.sqrt(numOne);
		} else if (che == '/') {
			sum = 1 / (numTwo);
		}
		objnum.setResult(sum);
		Numbers objnum2 = calrepo.save(objnum);
		return objnum2;
	}

	@PostMapping("/test")
	public String test(@RequestBody Numbers objnum) {
		Numbers objnum2 = calrepo.save(objnum);
		objnum2.setInserted(objnum.getInserted());
		calservice.saveHistory(objnum2);
		return objnum.getInserted();

	}

	@GetMapping("/history")
	public List<Numbers> history() {
		List<Numbers> history = calrepo.findAll();
		return history;
	}

	@PostMapping("/drop")
	public int drop() {
		calrepo.deleteAll();
		return 1;
	}

}

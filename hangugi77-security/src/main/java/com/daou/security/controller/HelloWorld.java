package com.daou.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorld {
	@GetMapping("/hello")
	public String helloWorld() {
		return "helloWorld";
	}

//	@GetMapping("/login")
//	public String index() {
//		return "index";
//	}

	@GetMapping("/map")
	public Map<Integer, Integer> map() {
		return Map.of(1, 1, 2, 2, 3,3, 4, 4);
	}
}

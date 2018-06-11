package com.daou.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String c() {
		return "login";
	}

	@GetMapping("/login")
	public String l() {
		return "login";
	}

	@GetMapping("/home")
	public String h() {
		return "home";
	}

	@PostMapping("/")
	public String cc() {
		return "home";
	}

	@PostMapping("/login")
	public String ll() {
		return "login";
	}

}

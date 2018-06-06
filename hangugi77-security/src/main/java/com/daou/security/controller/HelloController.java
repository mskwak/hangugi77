package com.daou.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String c() {
		return "welcome";
	}

	@GetMapping("/login")
	public String l() {
		return "index";
	}
}

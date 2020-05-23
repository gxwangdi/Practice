package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServicesController {

	@GetMapping("/rest")
	public String restHello() {
		return "<h1>Hello REST</h1>";
	}
}

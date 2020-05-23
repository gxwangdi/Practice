package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {

//	@RequestMapping("/hello")
//	public String sayHello() {
//		System.out.println("MvcController.sayHello() called.");
//		// Returned String needs to match templates hello.html for the association to work.  
//		return "hello";
//	}
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		ModelAndView mav = new ModelAndView("hello");
		// key needs to match the ${} in templates/hello.html
		mav.addObject("message", "Greetings message from MvcController.");
		System.out.println("MvcController.sayHello() called.");
		// Returned String needs to match templates hello.html for the association to work.  
		return mav;
	}
}

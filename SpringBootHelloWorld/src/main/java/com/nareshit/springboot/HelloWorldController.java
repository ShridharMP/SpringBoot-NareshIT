package com.nareshit.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String showHelloWorld() {
		return "HelloWorld using SpringBoot Application";
	}
	
	@RequestMapping("/overload")
	public String overloadedHelloWorld() {
		return "overloaded HelloWorld using SpringBoot Application";
	}
	
	@RequestMapping("/overload1")
	public String overloadedHelloWorld2() {
		return "overloaded1 HelloWorld using SpringBoot Application";
	}
}

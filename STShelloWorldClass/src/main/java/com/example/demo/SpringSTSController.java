package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSTSController {

	@RequestMapping("/")
	public String displayHelloWorld() {
		return "STS Plugin HelloWorld";
	}
}

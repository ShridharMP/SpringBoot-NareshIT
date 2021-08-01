package com.nareshit.springboot.SpringInitilizerDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/")
	public String showHelloWorld()
	{
		return "Spring Initilizer Helloworld project";
	}

}

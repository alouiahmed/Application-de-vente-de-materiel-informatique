package com.esprit.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestApi {
	private String title="Hello Order Service";
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println(title);
		return title;
	}
}

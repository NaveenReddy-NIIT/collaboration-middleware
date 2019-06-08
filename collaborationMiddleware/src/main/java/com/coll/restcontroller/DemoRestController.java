package com.coll.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/demo")
	public String showDemo() 
	{
		return "Hello from Rest Url";
	}
	
}

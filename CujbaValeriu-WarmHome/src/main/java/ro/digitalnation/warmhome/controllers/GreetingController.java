package ro.digitalnation.warmhome.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.digitalnation.warmhome.models.Greeting;

@RestController
public class GreetingController {

	@GetMapping("/greet")
	public String greet() {
		return "hello";
	}
	
	@GetMapping("/greeting")
	public Greeting greeting() {
		return new Greeting(1, "greetings!");
	}
}

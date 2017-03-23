package demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

	@GetMapping("/")
	String greet(@RequestParam(defaultValue = "World") String name) {
		return "Hello " + name;
	}
}

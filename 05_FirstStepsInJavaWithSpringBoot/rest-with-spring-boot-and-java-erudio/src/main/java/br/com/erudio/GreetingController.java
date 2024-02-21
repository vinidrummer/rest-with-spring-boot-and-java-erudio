package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World")  // recebe um parâmetro pelo RequestParam e armazena na String name
			String name) { // parametro opcional: localhost:8080/greeting?name=Vini
		return new Greeting(counter.getAndIncrement(), String.format(template, name));
	}

}

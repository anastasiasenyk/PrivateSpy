package com.middle.htmlparser;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HtmlparserApplication {
	public static void main(String[] args) {
		SpringApplication.run(HtmlparserApplication.class, args);
	}

	@GetMapping
	public String getFlowers(){
		return "Welcome to your Private Spy!";
	}
}

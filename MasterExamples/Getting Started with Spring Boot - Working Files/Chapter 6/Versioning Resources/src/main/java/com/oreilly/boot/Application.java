package com.oreilly.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
public class Application extends WebMvcConfigurerAdapter {

	@RequestMapping("/thymeleaf")
	public String tleaf() {
		return "template";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

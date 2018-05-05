package com.oreilly.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@ServletComponentScan
public class Application {

	@RequestMapping("/thymeleaf")
	public String tleaf() {
		return "template";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

package com.oreilly.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDataApplication {

	@Autowired
	private StockRepository repo;
	
	@RequestMapping("/stocks/{symbol}")
	public Stock stock(@PathVariable("symbol") String symbol){
		return repo.findBySymbol(symbol);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}
}

package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootMongoApplication {

	@Autowired
	private StockRepository repo;
	
	@RequestMapping("/stocks")
	private Stock stocks(){
		Stock stock = new Stock();
		stock.setCompanyName("Tesla");
		stock.setSymbol("TLSA");
		stock.setCeo("Elon Musk");
		stock.setPrice(250.00d);
		
		repo.save(stock);
		return repo.findBySymbol("TLSA");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}

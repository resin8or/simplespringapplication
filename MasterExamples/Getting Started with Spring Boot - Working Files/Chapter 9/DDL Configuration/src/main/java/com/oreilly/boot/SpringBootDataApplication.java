package com.oreilly.boot;

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
	
	@RequestMapping("/stocks/create")
	public String createStock(){
		Stock stock = new Stock();
		stock.setCeo("Kevin");
		stock.setCompanyName("Coffee Planet");
		stock.setSymbol("COF");
		stock.setStockId(5);
		stock.setPrice(5.00d);
		repo.save(stock);
		return "created";
	}

	@RequestMapping("/stocks/{symbol}")
	public Stock stock(@PathVariable("symbol") String symbol){
		return repo.findBySymbol(symbol);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}
}

package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;

@SpringBootApplication
@RestController
public class SpringBootMongoApplication {

	@Autowired
	private MongoTemplate template;
	
	@RequestMapping("/stocks")
	private Stock stocks(){
		Stock stock = new Stock();
		stock.setCompanyName("Tesla");
		stock.setSymbol("TLSA");
		stock.setCeo("Elon Musk");
		stock.setPrice(250.00d);
		
		template.insert(stock,"stock");
		return template.findOne(new BasicQuery("{symbol:'TLSA'}"), Stock.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}

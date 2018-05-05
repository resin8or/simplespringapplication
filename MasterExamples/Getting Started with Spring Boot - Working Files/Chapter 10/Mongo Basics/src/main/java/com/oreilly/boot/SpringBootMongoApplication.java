package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@SpringBootApplication
@RestController
public class SpringBootMongoApplication {

	@Autowired
	private MongoDbFactory mongo;
	
	@RequestMapping("/stocks")
	private DBObject stocks(){
		DB db = mongo.getDb("sandbox");
		DBCollection collection = db.getCollection("stocks");
		
		collection.insert(new BasicDBObject().append("companyName","Ford").append("symbol","F"));
		return collection.findOne(new BasicDBObject().append("symbol", "F"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}
}

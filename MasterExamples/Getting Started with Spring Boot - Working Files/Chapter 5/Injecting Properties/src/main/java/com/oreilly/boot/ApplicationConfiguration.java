package com.oreilly.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationConfiguration {

//	@Bean
	public MyMessage myMessage(@Value("${my.messageValue}") String messageValue){
		MyMessage myMessage = new MyMessage();
		myMessage.setMessageValue(messageValue);
		return myMessage;
	}

}

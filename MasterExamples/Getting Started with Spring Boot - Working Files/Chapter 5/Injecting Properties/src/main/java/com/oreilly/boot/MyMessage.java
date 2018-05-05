package com.oreilly.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="my", locations="classpath:example.properties")
public class MyMessage {

	private String messageValue;

	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}
}

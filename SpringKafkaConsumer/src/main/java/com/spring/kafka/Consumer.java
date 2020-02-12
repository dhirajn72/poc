/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.freemarker.services.MailService;
import com.spring.kafka.pojo.SmtpService;

public class Consumer {

	@Autowired
	@Qualifier("mailService")
	protected MailService mailService;

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${kafka.topic.mytopic}")
	public void receive(String payload) {
		ObjectMapper objectMapper = new ObjectMapper();

		LOGGER.info("received payload='{}'", payload);

		try {
			SmtpService service = objectMapper.readValue(payload, SmtpService.class);
			LOGGER.info("Service received :" + service);
			mailService.sendEmail(service);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/***
 * 
 *
 *
 ***/
package com.spring.kafka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.kafka.pojo.SmtpService;
import com.spring.kafka.pojo.util.Jackson;

/**
 * @author dhiraj
 *
 */
@SpringBootApplication
public class SpringKafkaProducer implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SpringKafkaProducer.class, args);
		System.out.println(Arrays.toString(args));
		Producer producer = applicationContext.getBean(Producer.class);
		SmtpService service = getDummyServiceData();
		producer.send("my-replicated-topic", Jackson.getValueAsString(service));
		System.out.println("main ends !!");
	}

	// TODO- DELETEME!
	// dummy method to get data for testing purpose, in real time, Producer should
	// get the SmtpService
	// Object
	/**
	 * 
	 * @return
	 */
	private static SmtpService getDummyServiceData() {
		String from = "dhiraj@com.com";
		String[] to = { "dhiraj@com.com" };
		String[] cc = { "dhiraj@com.com", "dhiraj@com.com" };
		String[] bcc = { "dhiraj@com.com", "dhiraj@com.com" };

		SmtpService service = new SmtpService();
		service.setService_id(97);// Uses email-emplate-1
		// service.setService_id(98);// uses email-template-2
		// service.setService_id(99);// uses email-template-3

		service.setFrom(from);
		service.setTo(to);
		service.setCc(cc);
		service.setBcc(bcc);
		service.setSubject("Email from Kafka Producer");
		service.setModel(getModel());
		service.setMailContent("Kafka mail Content");
		service.setTemplateId(78);

		return service;
	}

	// TODO- DELETEME!
	// dummy method to get data for testing purpose, in real time, Producer should
	// get the Map object
	/**
	 * 
	 * @return
	 */
	private static Map<String, Object> getModel() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", "Dhiraj");
		map.put("lastName", "Singh");
		map.put("amount", "1000000");
		map.put("signature", "www.com.com");
		map.put("location", "Bangalore");
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext(org
	 * .springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		SpringKafkaProducer.applicationContext = arg0;
	}
}

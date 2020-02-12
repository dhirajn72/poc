/**
 * 
 */
package com.kafka.email;

/**
 * @author dhiraj
 *
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @author dhiraj
 *
 */
public class SimpleHLConsumer {

	static InputStream input;

	public static void main(String[] args) throws MessagingException {

		List<String> mydest = new ArrayList<>();
		// mydest.add("dhirajn72@gmail.com");
		// mydest.add("dhirajkumar.co.in@gmail.com");
		mydest.add("rajendrabsau@gmail.com");

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("enable.auto.commit", "true");
		props.put("session.timeout.ms", "10000");
		props.put("fetch.min.bytes", "5000");
		props.put("receive.buffer.bytes", "262144");
		props.put("max.partition.fetch.bytes", "2097152");

		try {
			input = new FileInputStream("src/main/resources/application.properties");
		} catch (FileNotFoundException ex) {
			Logger.getLogger(SimpleHLConsumer.class.getName()).log(Level.SEVERE, null, ex);
		}

		// Defining a kafka consumer
		KafkaConsumer consumer = new KafkaConsumer(props);

		// Subscribe to a topic
		consumer.subscribe(Arrays.asList("my-replicated-topic"));

		while (true) {

			ConsumerRecords<String, String> records = consumer.poll(10);

			for (ConsumerRecord<String, String> record : records) {

				System.out.println(record.offset() + "---" + record.key() + "==> " + record.value());
				BrokerEmail ms = new BrokerEmail(mydest, mydest, "Message from Kafka producer :" + record.topic(),
						record.value());
				ms.sendSTMPEmail(input);

			}
		}

	}

}
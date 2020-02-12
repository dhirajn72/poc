/**
 * 
 */
package com.spring.oxm.client;

import java.util.function.Consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.oxm.Customer;
import com.spring.oxm.Customers;
import com.spring.oxm.MarshallUnmarshall;

/**
 * @author dhiraj
 *
 */
public class Unmarshaller {
	public static void main(String[] args) {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			MarshallUnmarshall unmarshall = applicationContext.getBean(MarshallUnmarshall.class);
			// Customer customer = (Customer) unmarshall.unmarshall("customers.xml");
			Customers customer = (Customers) unmarshall.unmarshall("customers.xml");

			/***
			 * 
			 * forEach method of Java 1.8 for iteration and printing
			 * 
			 */
			customer.getCustomers().forEach(new Consumer<Customer>() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.function.Consumer#accept(java.lang.Object)
				 */
				public void accept(Customer t) {
					System.out.println(t);
				}
			});

			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * 
 */
package com.spring.oxm.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.oxm.Address;
import com.spring.oxm.Customer;
import com.spring.oxm.Customers;
import com.spring.oxm.MarshallUnmarshall;

/**
 * @author dhiraj
 *
 */
public class Marshaller {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MarshallUnmarshall marshaller = (MarshallUnmarshall) context.getBean(MarshallUnmarshall.class);

		Address address = new Address("#42", "KA", "IN");

		Customer customer = new Customer(99, "dhiraj", "dhiraj@com.com", "9743854499", address);

		// marshaller.marshall(customer, "customers.xml");

		/***
		 * 
		 * When you have list of customers,
		 * 
		 * 
		 */
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		customers.add(customer);
		customers.add(customer);
		customers.add(customer);
		customers.add(customer);
		customers.add(customer);

		Customers cust = new Customers();
		cust.setCustomers(customers);

		marshaller.marshall(cust, "customers.xml");

	}

}

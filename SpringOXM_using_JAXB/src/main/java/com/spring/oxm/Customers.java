/**
 * 
 */
package com.spring.oxm;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dhiraj
 *
 */
@XmlRootElement
public class Customers {

	private List<Customer> customers;

	@XmlElement(name = "customer")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);

	}

}

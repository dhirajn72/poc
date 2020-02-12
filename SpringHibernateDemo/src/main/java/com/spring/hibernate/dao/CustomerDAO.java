/**
 * 
 */
package com.spring.hibernate.dao;

import com.spring.hibernate.entity.Customer;

/**
 * @author dhiraj
 *
 */
public interface CustomerDAO {
	void addCustomer(Customer customer);

	void removeCustomer(int id);

	void updateCustomer(Customer customer);

	Customer getCustomer(int id);

}

/**
 * 
 */
package com.spring.hibernate.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.hibernate.entity.Customer;

/**
 * @author dhiraj
 *
 */

@Transactional
// @Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.hibernate.dao.CustomerDAO#addCustomer(com.spring.hibernate.entity.
	 * Customer)
	 */
	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		try {
			hibernateTemplate.save(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.hibernate.dao.CustomerDAO#removeCustomer(int)
	 */
	@Override
	public void removeCustomer(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.hibernate.dao.CustomerDAO#updateCustomer(com.spring.hibernate.
	 * entity.Customer)
	 */
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.hibernate.dao.CustomerDAO#getCustomer(int)
	 */
	@Transactional
	@Override
	public Customer getCustomer(int id) {
		Customer customer = null;
		try {
			customer = (Customer) hibernateTemplate.get(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}

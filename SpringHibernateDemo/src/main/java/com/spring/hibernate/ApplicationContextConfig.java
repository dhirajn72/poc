/**
 * 
 */
package com.spring.hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.hibernate.dao.CustomerDAOImpl;

/**
 * @author dhiraj
 *
 */

@Configuration
@ComponentScan(basePackages = "com.spring.hibernate")
public class ApplicationContextConfig {

	@Bean
	public CustomerDAOImpl getCustomerDAOImpl() {
		return new CustomerDAOImpl();
	}
}

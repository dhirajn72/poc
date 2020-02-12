/**
 * 
 */
package com.spring.soap.cxf;

import javax.jws.WebService;

/**
 * @author dhiraj
 *
 */
@WebService
public interface AccountDAO {

	String deposit(long ammount);

	int requestCheckBook(String message);

}

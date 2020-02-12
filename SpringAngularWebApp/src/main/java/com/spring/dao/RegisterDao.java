/**
 * 
 */
package com.spring.dao;

import com.spring.test.exceptions.UserAlreadyExistsException;
import com.spring.test.to.RegisterTo;

/**
 * @author dhiraj
 *
 */
public interface RegisterDao {

	Integer registerUser(RegisterTo to) throws UserAlreadyExistsException;

}

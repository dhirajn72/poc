/**
 * 
 */
package com.spring.kafka.pojo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.kafka.pojo.SmtpService;

/**
 * @author dhiraj
 *
 */
public class Jackson {

	/**
	 * @param service
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String getValueAsString(SmtpService service) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(service);
	}
}

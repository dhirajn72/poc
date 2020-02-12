/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.freemarker.services;

import java.io.IOException;

import com.spring.kafka.pojo.SmtpService;

/**
 * @author dhiraj
 *
 */
public interface MailService {
	public void sendEmail(SmtpService service) throws IOException;

}

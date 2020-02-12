/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.freemarker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.spring.freemarker.services.MailService;
import com.spring.freemarker.services.impl.MailServiceImpl;

/**
 * @author dhiraj
 *
 */

@Configuration
@ComponentScan(basePackages = "com.spring.freemarker")
public class ApplicationConfig {

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
		fmConfigFactoryBean.setTemplateLoaderPath("/templates/");
		return fmConfigFactoryBean;
	}

	@Bean
	public MailService getMailService() {
		return new MailServiceImpl();
	}

}
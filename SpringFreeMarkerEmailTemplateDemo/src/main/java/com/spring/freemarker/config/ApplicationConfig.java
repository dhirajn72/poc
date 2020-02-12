/**
 * 
 */
package com.spring.freemarker.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.spring.freemarker.utils.EmailUtils;

/**
 * @author dhiraj
 *
 */

@Configuration
@ComponentScan(basePackages = "com.spring.freemarker")
public class ApplicationConfig {

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(EmailUtils.getAppProperties().getProperty("host"));
		mailSender.setPort(Integer.valueOf(EmailUtils.getAppProperties().getProperty("port")));
		mailSender.setUsername(EmailUtils.getAppProperties().getProperty("username"));
		/**
		 * 
		 * // TODO ! remove this password
		 * 
		 */

		mailSender.setPassword(EmailUtils.getAppProperties().getProperty("password"));

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable",
				EmailUtils.getAppProperties().get("mail.smtp.starttls.enable"));
		javaMailProperties.put("mail.smtp.auth", EmailUtils.getAppProperties().get("mail.smtp.auth"));
		javaMailProperties.put("mail.transport.protocol", EmailUtils.getAppProperties().get("mail.transport.protocol"));
		javaMailProperties.put("mail.debug", EmailUtils.getAppProperties().get("mail.debug"));

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean fmConfigFactoryBean = new FreeMarkerConfigurationFactoryBean();
		fmConfigFactoryBean.setTemplateLoaderPath("/templates/");
		return fmConfigFactoryBean;
	}

}
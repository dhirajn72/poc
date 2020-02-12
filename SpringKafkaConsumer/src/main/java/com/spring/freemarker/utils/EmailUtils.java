/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.freemarker.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dhiraj
 *
 */
public class EmailUtils {
	private static Properties appProperties;

	static {
		appProperties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/main/resources/mailconfig.properties");
			appProperties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Properties getAppProperties() {
		return appProperties;
	}
}

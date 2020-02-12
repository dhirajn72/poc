/**
 * 
 */
package com.spring.oxm;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

/**
 * 
 * Centralized class to take care of marshalling and unmarshalling
 * 
 * 
 * @author dhiraj
 *
 */
public class MarshallUnmarshall {

	/**
	 * 
	 * These two beans are not configured in spring container. These will be
	 * injected by the spring framework itself. Please see, applicationContext.xml
	 * for more info.
	 * 
	 */
	@Autowired
	private Marshaller marshaller;
	@Autowired
	private Unmarshaller unmarshaller;

	/**
	 * @param object
	 * @param fname
	 */
	public void marshall(Object object, String fname) {

		try {
			FileOutputStream outputStream = new FileOutputStream(fname);
			marshaller.marshal(object, new StreamResult(outputStream));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param fname
	 * @return
	 */
	public Object unmarshall(String fname) {
		Object object = null;

		try {
			FileInputStream inputStream = new FileInputStream(fname);
			object = unmarshaller.unmarshal(new StreamSource(inputStream));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;

	}

}

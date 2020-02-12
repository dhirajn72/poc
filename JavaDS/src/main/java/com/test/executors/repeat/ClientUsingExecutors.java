/**
 * 
 */
package com.test.executors.repeat;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author dhiraj
 *
 */
public class ClientUsingExecutors {
	public static void main(String[] args) {

		try {

			ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
			Thread1 t1 = new Thread1(producerAndConsumer);
			Thread2 t2 = new Thread2(producerAndConsumer);

			Executor es = Executors.newFixedThreadPool(2);
			
			
			es.execute(t1);
			es.execute(t2);
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

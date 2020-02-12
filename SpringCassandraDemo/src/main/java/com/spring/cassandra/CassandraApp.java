package com.spring.cassandra;

/**
 * 
 *
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;

/**
 * @author dhiraj
 *
 */
public class CassandraApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraApp.class);

	private static Cluster cluster;
	private static Session session;
	private static CassandraOperations cassandraOps;

	static {
		try {
			cluster = Cluster.builder().addContactPoints(InetAddress.getByName("127.0.0.1")).build();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		session = cluster.connect("mykeyspace");
		cassandraOps = new CassandraTemplate(session);

	}

	public static void main(String[] args) {
		LOGGER.info("Inserting values");
		insert();
		System.out.println("************");
		LOGGER.info("Fetching all values");
		String cql = "select * from employee";
		List<Employee> employees = cassandraOps.select(cql, Employee.class);
		employees.forEach(new Consumer<Employee>() {
			@Override
			public void accept(Employee t) {
				System.out.println(t);
			}
		});
		System.out.println("**********");
		LOGGER.info("Fetching only specific value with id: " + 22);
		Select select = QueryBuilder.select().from("employee");
		select.where(QueryBuilder.eq("id", 22));
		Employee e = cassandraOps.selectOne(select, Employee.class);
		System.out.println(e);
		System.out.println("**************");
		LOGGER.info("Updating specific value with id: " + 26);
		Update update = QueryBuilder.update("employee");
		update.setConsistencyLevel(ConsistencyLevel.ONE);
		update.with(QueryBuilder.set("age", 28));
		update.where(QueryBuilder.eq("id", 26));
		cassandraOps.execute(update);
		System.out.println("*************");
		LOGGER.info("Deleting specific value with id: " + 15);
		Delete delete = QueryBuilder.delete().from("employee");
		delete.setConsistencyLevel(ConsistencyLevel.ONE);
		delete.where(QueryBuilder.eq("id", 15));
		cassandraOps.execute(delete);

		LOGGER.info("Terminating cluster");
		// cassandraOps.truncate("employee");

	}

	public static void insert() {
		for (int i = 1; i < 50; i++) {
			cassandraOps.insert(new Employee(i, "Name-" + i));
			LOGGER.info("Inserted value: " + i);

		}

	}

}

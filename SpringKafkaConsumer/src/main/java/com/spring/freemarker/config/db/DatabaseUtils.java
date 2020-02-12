/***
 * 
 *
 *
 ***/
package com.spring.freemarker.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.spring.freemarker.utils.EmailUtils;
import com.spring.kafka.pojo.SmtpService;

/**
 * @author dhiraj
 *
 */
public class DatabaseUtils {

	private static final String QUERY = EmailUtils.getAppProperties().getProperty("sql");
	private static final String DRIVER_NAME = EmailUtils.getAppProperties().getProperty("driverName");
	private static final String DATABASE_NAME = EmailUtils.getAppProperties().getProperty("databaseName");
	private static final String DATABASE_USER_NAME = EmailUtils.getAppProperties().getProperty("databaseUserName");
	private static final String DATABASE_PASSWORD = EmailUtils.getAppProperties().getProperty("databasePassword");
	private static final String DATABASE_URL = EmailUtils.getAppProperties().getProperty("databaseUrl");
	private static final String DATABASE_PORT = EmailUtils.getAppProperties().getProperty("databasePort");

	/**
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(DATABASE_URL + ":" + DATABASE_PORT + "/" + DATABASE_NAME,
				DATABASE_USER_NAME, DATABASE_PASSWORD);
		return con;
	}

	/**
	 * @param service
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static JavaMailSender getMailSender(SmtpService service) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		PreparedStatement stmt = null;
		try {
			stmt = getConnection().prepareStatement(QUERY);
			stmt.setInt(1, service.getService_id());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mailSender.setHost(rs.getString(2));
				mailSender.setPort(rs.getInt(3));
				mailSender.setUsername(EmailUtils.getAppProperties().getProperty("username"));
				mailSender.setPassword(EmailUtils.getAppProperties().getProperty("password"));
				Properties javaMailProperties = new Properties();
				javaMailProperties.put("mail.smtp.starttls.enable", rs.getString(4));
				javaMailProperties.put("mail.smtp.auth", rs.getString(5));
				javaMailProperties.put("mail.transport.protocol", rs.getString(6));
				javaMailProperties.put("mail.debug", rs.getString(7));
				mailSender.setJavaMailProperties(javaMailProperties);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailSender;
	}
}

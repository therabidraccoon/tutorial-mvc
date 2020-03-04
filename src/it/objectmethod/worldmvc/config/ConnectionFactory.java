package it.objectmethod.worldmvc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/world";
	private static final String USER = "root";
	private static final String PASS = "rootroot";

//	private static Context ctx;

//	public static Connection getConnection() {
//		Connection conn = null;
//		try {
//			if(ctx == null) {
//				ctx = new InitialContext();
//			} 
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+"jdbc/local");
//			if (ds==null) {
//				throw new Exception("Impossibile trovare la configurazione per la connessione");
//			}
//			conn = ds.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();		
//		}
//		return conn;
//	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}

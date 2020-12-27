package com.xpncs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//we should turn our factory into singleton
	//make a private static reference to yourself - one and only copy
	private static ConnectionFactory cf = new ConnectionFactory(1);
	
	//provide a single point of access to the connection factory
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	

	//this is a connection pool
	private Connection[] conn;
	
	//if making singleton, all constructors must be private otherwise other people could make copies
	
	private ConnectionFactory(int numberOfConnections) {
		
		String url = System.getenv("DB_URL");
		
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		

		

		try {
			this.conn = new Connection[numberOfConnections];
			for (int i = 0; i < this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				this.conn[i] = conn;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//if for real implementation, synchronize if using multiple threads.
	//add locks for safety
	// .wait and .notify
	//this one is only for one thread
	public Connection getConnection() {
		return this.conn[0];
	};
	
	public void releaseConnection(Connection conn) {
		//do nothing - release conn after use if in multiple threads
	};
	
	
}

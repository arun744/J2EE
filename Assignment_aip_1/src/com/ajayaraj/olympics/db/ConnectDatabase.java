package com.ajayaraj.olympics.db;

import java.sql.*;
import java.util.Properties;

import java.io.Serializable;

public class ConnectDatabase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1565651259601322424L;
	private static final String dbDriver = "com.mysql.jdbc.Driver";
	private static final String dbURL = "jdbc:mysql://localhost:3306/utsaipdb";
	private static final String dbuser = "root";
	private static final String dbpass = "password";
	private Connection connectdb;
	
	
	public Connection connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

			Properties login = new Properties();
			login.setProperty("user", dbuser);
			login.setProperty("passsword", dbpass);
			Class.forName(dbDriver).newInstance();
			connectdb = DriverManager.getConnection(dbURL, dbuser, dbpass);
			
			return connectdb;
	}
	
	public void close() throws SQLException{
		connectdb.close();
	}
	
	public ResultSet query(String sql) throws SQLException{
		Statement command = connectdb.createStatement();
		return command.executeQuery(sql);
	}
	
	public Connection getConnectdb() {
		return connectdb;
	}

	public void setConnectdb(Connection connectdb) {
		this.connectdb = connectdb;
	}
}

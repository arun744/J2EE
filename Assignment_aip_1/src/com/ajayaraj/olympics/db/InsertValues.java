package com.ajayaraj.olympics.db;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertValues {
    
/*	private ConnectDatabase myDB;
	private Connection conn = null;
	
	public void insertvalues(String filename) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	
	InputStream url = this.getClass().getResource(filename).openStream();
	DataInputStream input = new DataInputStream(url);
	BufferedReader in = new BufferedReader(new InputStreamReader(input));
//	PrintWriter out = new PrintWriter(new FileWriter("london.sql"));
	String line;
	while ((line = in.readLine()) != null) {
	    String[] fields = line.split(",");
	    String category = fields[0];
	    String code = fields[1];
	    String description = fields[2];
	    String price = fields[3];
	    executeInsert(code,category,description, price);
	    }
}
	
	public void executeInsert(String code, String category, String description, String price) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		myDB = new ConnectDatabase();
		conn = myDB.connect();
		String sql = "insert into productTbl values (?, ?, ?, ?)";
		PreparedStatement prepStat = conn.prepareStatement(sql);
		prepStat.setString(1,code);
		prepStat.setString(2, category);
		prepStat.setString(3, description);
		prepStat.setString(4, price);
		prepStat.executeUpdate();
	}*/
}

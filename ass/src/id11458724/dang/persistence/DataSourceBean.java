package id11458724.dang.persistence;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Database source name retrieve from weblogic server
	private String dbDataSource = "thinMySQLDataSource";
	// Connection to the database
	private Connection conn;

	// Open connection
	public void connect() throws ClassNotFoundException, SQLException, NamingException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(getDbDataSource());
		conn = ds.getConnection();
	}

	// Return record set from a SELECT query
	public ResultSet query(String sql) throws SQLException {
		Statement stm = conn.createStatement();
		return stm.executeQuery(sql);
	}
	
	// Execute INSERT, UPDATE, DELETE query
	public int update(String sql) throws SQLException {
		Statement stm = conn.createStatement();
		return stm.executeUpdate(sql);
	}

	// Close connection
	public void close() throws SQLException {
		conn.close();
	}

	/**
	 * @return the dbDataSource
	 */
	public String getDbDataSource() {
		return dbDataSource;
	}

	/**
	 * @param dbDataSource the dbDataSource to set
	 */
	public void setDbDataSource(String dbDataSource) {
		this.dbDataSource = dbDataSource;
	}
}

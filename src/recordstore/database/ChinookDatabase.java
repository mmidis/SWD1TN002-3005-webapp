package recordstore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
	private static final String URL = "jdbc:sqlite:/Chinook_Sqlite.sqlite";
	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(URL);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException();
		}

	}
	public void close(ResultSet results, PreparedStatement statement, Connection conn) {
		 try {
	            if (results != null) {
	                results.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
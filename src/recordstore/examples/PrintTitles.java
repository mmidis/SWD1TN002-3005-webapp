package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintTitles {
public static void main(String[] args) throws SQLException {
	ChinookDatabase db = new ChinookDatabase();
	Connection conn = db.connect();
	
	PreparedStatement statement = conn.prepareStatement("SELECT Title FROM Album ORDER BY Title ASC;");
	ResultSet results = statement.executeQuery();
	
	while (results.next()) {
		System.out.println(results.getString("Title"));
	}
	
	db.close(results, statement, conn);
	
}

}

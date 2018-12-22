package recordstore.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import recordstore.database.ChinookDatabase;

public class PrintTitlesByArtist {
	public static void main(String[] args) throws SQLException {
		String sql = "SELECT * FROM Album WHERE ArtistId = (SELECT ArtistId FROM Artist WHERE Name = ?)";
		ChinookDatabase db = new ChinookDatabase();
		Connection conn = db.connect();
		PreparedStatement statement = conn.prepareStatement(sql);

		// Scanner....
		String input = "AC/DC";
		statement.setString(1, input);

		ResultSet results = statement.executeQuery();
		while (results.next()) {
			System.out.println(results.getString("Title"));
		}

		db.close(results, statement, conn);
	}
}

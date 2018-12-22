package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

public class ArtistDao {
	private ChinookDatabase db = new ChinookDatabase();
	
	public ArtistDao(ChinookDatabase db) {
		this.db = db;
	}
	
	public Artist findArtist(long id) {
		Connection connection = db.connect();
		PreparedStatement statement = null; 
		ResultSet results = null;
		
		try {
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();
			
			if (results.next()) {
				String name = results.getString("Name"); //results on vastaukset tietokannasta
				Artist artist = new Artist(id, name);
				return artist;
			} else {
				return null; 
			}
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			db.close(results, statement, connection);
		}
		
	}
	
	public List<Artist> getAllArtists() {
		Connection connection = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		List<Artist> list = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement("SELECT * Artist ORDER BY Name ASC");
			results = statement.executeQuery();
			
			while(results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				list.add(new Artist(id,name));
						
			}
		   } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            db.close(results, statement, connection);
	        }

	        return list;
	    }
	}

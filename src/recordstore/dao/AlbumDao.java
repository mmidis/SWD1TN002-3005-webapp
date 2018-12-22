package recordstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recordstore.database.ChinookDatabase;
import recordstore.models.Album;


public class AlbumDao {
	private ChinookDatabase db = new ChinookDatabase();
	
	public AlbumDao(ChinookDatabase db) {
		this.db = db;
	}
	
	public List<Album> findAlbumsByArtist(long artistId) {
		Connection connection = db.connect();
		PreparedStatement statement = null; 
		ResultSet results = null;
		
		List<Album> list = new ArrayList<>();
		
		try {
			statement = connection.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
			
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			
			if (results.next()) {
				String title = results.getString("Title"); //results on vastaukset tietokannasta
				Album album = new Album(artistId, title);
				return list;
			} else {
				return null; 
			}
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			db.close(results, statement, connection);
		}
		
	}
	
//	public List<Album> getAllAlbums() {
//		Connection connection = db.connect();
//		PreparedStatement statement = null;
//		ResultSet results = null;
//		
//		List<Album> list = new ArrayList<>();
//		
//		try {
//			statement = connection.prepareStatement("SELECT * Album ORDER BY Name ASC");
//			results = statement.executeQuery();
//			
//			while(results.next()) {
//				long id = results.getLong("albumId");
//				String title = results.getString("Title");
//				list.add(new Album(id,title));
//						
//			}
//		   } catch (SQLException e) {
//	            throw new RuntimeException(e);
//	        } finally {
//	            db.close(results, statement, connection);
//	        }
//
//	        return list;
//	    }
	
	
	}

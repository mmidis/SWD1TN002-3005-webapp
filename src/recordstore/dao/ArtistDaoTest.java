package recordstore.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

public class ArtistDaoTest {
	
	private ArtistDao dao;

	@BeforeEach
	public void setUp() {
		ChinookDatabase database = new ChinookDatabase();
		this.dao = new ArtistDao(database);
	}
	@Test
	public void testArtistListIsNotEmpty() {
		ArtistDao dao = new ArtistDao(null);
		List<Artist> all = dao.getAllArtists();

		assertEquals(false, all.isEmpty());
	}
	
	@Test
	public void testTheNameOfTheFirstArtist() {
		List<Artist> all = dao.getAllArtists();
		
		assertEquals("A Cor Do Som", all.get(0).getName());
	}
}

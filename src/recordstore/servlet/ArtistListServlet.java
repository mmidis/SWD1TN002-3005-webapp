package recordstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recordstore.dao.ArtistDao;
import recordstore.database.ChinookDatabase;
import recordstore.models.Artist;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {
	
	private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Artist> artists = artistDao.getAllArtists();

        req.setAttribute("artists", artists);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/artistList.jsp");
        dispatcher.include(req, resp);

    }
}
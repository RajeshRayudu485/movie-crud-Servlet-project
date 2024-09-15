package movie_crud;

import java.io.IOException;

import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											

@WebServlet("/add-movie")
@MultipartConfig
public class addMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("addmovie.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		int rating = Integer.parseInt(req.getParameter("rating"));
		String[] gener = req.getParameterValues("gener");
		Part part = req.getPart("poster");
		InputStream input = part.getInputStream();
		byte[] poster = new byte[input.available()];
		input.read(poster);

		Movie movie = new Movie();
		movie.setMovieName(name);
		movie.setDescription(description);
		movie.setLanguage(language);
		movie.setGener(gener);
		movie.setRating(rating);
		movie.setPoster(poster);

		resp.getWriter().print("<h1 style=text-align:center;background-color:hotpink>Movie Added Success</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	
	}

}

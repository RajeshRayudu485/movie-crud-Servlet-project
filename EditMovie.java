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

import org.apache.catalina.Manager;

@WebServlet("/update-movie")
@MultipartConfig
public class EditMovie extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		String language=req.getParameter("language");
		int rating=Integer.parseInt(req.getParameter("rating"));
		String[]gener=req.getParameterValues("gener");
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		Part part = req.getPart("poster");
		InputStream input=part.getInputStream();
		byte[] poster = new byte[input.available()];
		input.read(poster);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		 
		Movie movie = manager.find(Movie.class, id);
		movie.setMovieName(name);
		movie.setDescription(description);
	    movie.setLanguage(language);
	    movie.setGener(gener);
	    movie.setRating(rating);
	    if(poster.length>0)
	    movie.setPoster(poster);
	
		
		transaction.begin();
		manager.merge(movie);
		transaction.commit();
	
		
		resp.getWriter().print("<h1 style=text-align:center;background-color:hotpink>Movie Updated Success	</h1>");
		req.getRequestDispatcher("fetch-all").include(req, resp);
		
	}
}

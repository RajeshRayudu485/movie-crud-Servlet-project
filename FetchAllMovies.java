package movie_crud;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch-all")
public class FetchAllMovies  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("servlet");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		List<Movie> movie = manager.createQuery("select x from  Movie x").getResultList();
		if (movie.isEmpty()) {
			resp.getWriter().print("<h1>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
            req.setAttribute("movies", movie);
            req.getRequestDispatcher("fetch-all.jsp").include(req, resp);
		}
	}
	
}

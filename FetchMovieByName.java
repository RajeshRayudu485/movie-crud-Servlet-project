package movie_crud;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetch-movie")
public class FetchMovieByName extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("servlet");
		EntityManager manager=factory.createEntityManager();
		
          Movie movie = manager.find(Movie.class, name);
          
          if (movie.getMovieName().isEmpty()) {
			resp.getWriter().print("<h1>Movie Not Found </h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
            req.setAttribute("moviename", movie);
            req.getRequestDispatcher("fetchby-moviename.jsp").include(req, resp);
		}
	}

}

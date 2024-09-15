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

@WebServlet("/edit")
public class Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int id=Integer.parseInt(req.getParameter("id"));
	 
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("servlet");
	 EntityManager manager=factory.createEntityManager();
	
	 Movie movie = manager.find(Movie.class, id);
	 
	 req.setAttribute("movie", movie);
	 req.getRequestDispatcher("edit.jsp").forward(req, resp);
	 
	}
}

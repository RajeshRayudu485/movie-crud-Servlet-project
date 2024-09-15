package movie_crud;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int id=Integer.parseInt(req.getParameter("id"));
          
          EntityManagerFactory factory=Persistence.createEntityManagerFactory("servlet");
          EntityManager manager=factory.createEntityManager();
          EntityTransaction transaction=manager.getTransaction();
          
          Movie movie = manager.find(Movie.class, id);
          transaction.begin();
          manager.remove(movie);
          transaction.commit();
          
          resp.getWriter().print("<h1 style=text-align:center;background-color:hotpink;>Movie Deleted Success</h1>");
          req.getRequestDispatcher("fetch-all").include(req, resp);
		
	}
}

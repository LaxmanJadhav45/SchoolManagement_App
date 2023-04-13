package SchoolManagement.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStudentStream")
public class UpdateSStream extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String stream=req.getParameter("stream");
		
		Student s=em.find(Student.class, id);
		s.setStream(stream);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		 
	     resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("updated successfully");
		
		RequestDispatcher rd=req.getRequestDispatcher("updateStudent.html");
		rd.forward(req, resp);
		
		
		
	}
}

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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		double fees=Double.parseDouble(req.getParameter("fees"));
		
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		 resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("Student added");
		
	
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.forward(req, resp);
		
	}
}

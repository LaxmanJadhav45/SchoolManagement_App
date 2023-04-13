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

@WebServlet("/updateTeacherSalary")
public class UpdateTSalery extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		double salery=Double.parseDouble(req.getParameter("salery"));
		
		Teacher t=em.find(Teacher.class, id);
		t.setSalery(salery);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		 
	     resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("updated successfully");
		
		RequestDispatcher rd=req.getRequestDispatcher("updateTeacher.html");
		rd.forward(req, resp);
		
	}
}

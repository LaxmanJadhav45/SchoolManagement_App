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
import javax.servlet.http.HttpSession;
@WebServlet("/FindStudent")
public class ViewStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		Student s1=em.find(Student.class, id);
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getStream());
		System.out.println(s1.getFees());
		
//		HttpSession hs = req.getSession() ;
//		hs.setAttribute("student", s1);
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.forward(req, resp);
		
	
	}
	
}

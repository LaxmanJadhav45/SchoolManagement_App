package SchoolManagement.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginPrinciple")
public class Login_Page extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		Query q=em.createQuery("select p from Principal p where  p.email=?1 and p.password=?2");
		
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List< Principal> p=q.getResultList();
		
		if (p.size()>0) {
			
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("login successfull");
			
			RequestDispatcher rd=req.getRequestDispatcher("t_s.html");
			rd.forward(req, resp);
			
		}
		else {
//			PrintWriter pw=resp.getWriter();
//			pw.write("invalid");
			
			resp.setContentType("text/html") ;
			PrintWriter pw = resp.getWriter() ;
			pw.write("invalid credentials");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
		
//		System.out.println(email);
//		System.out.println(password);
//		
	}
}

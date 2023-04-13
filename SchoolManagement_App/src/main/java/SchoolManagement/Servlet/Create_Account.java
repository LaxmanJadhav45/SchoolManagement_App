package SchoolManagement.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/InsertPrincipalData")
public class Create_Account extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Lucky");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	String id = req.getParameter("id") ;
	String name=req.getParameter("name");
	int age=Integer.parseInt(req.getParameter("age"));
	long mobileno=Long.parseLong(req.getParameter("mobileno"));
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	Principal p=new Principal();
	 p.setId(Integer.parseInt(id));
	p.setName(name);
	p.setAge(age);
	p.setMobileNo(mobileno);
	p.setEmail(email);
	p.setPassword(password);
	
	
	et.begin();
	em.persist(p);
	et.commit();
	
	 resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter() ;
		pw.write("Principal added");
	
	RequestDispatcher rd=req.getRequestDispatcher("File1.html");
	rd.forward(req, resp);
	
	}
	
	

}

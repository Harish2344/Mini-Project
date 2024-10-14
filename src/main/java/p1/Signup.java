package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
     
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/project";
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
String query="insert into Signup value('"+fname+"','"+lname+"','"+email+"','"+mobile+"','"+password+"')"	;
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","Harish@234");
			PreparedStatement ps=con.prepareStatement(query);
		int x =	ps.executeUpdate();
			
		if(x>0) {
			RequestDispatcher r=request.getRequestDispatcher("Login.jsp") ;
					r.forward(request, response);
			
			p.println("<p>Signup successfully</p>");
			p.println("<a href='Login.jsp'>Login</a>");
		}
		else {
			p.println("Failed to signup");
		}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

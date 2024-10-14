package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/project";	
		
		String query="delete from Signup where Email=?";
		
		String email=request.getParameter("Email");
		
		
		
		
		
		try {
			PrintWriter p=response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Harish@234");
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,email);
		
		
		
		int x=ps.executeUpdate();
		if(x>0) {
			p.println("<p font-size-'30'>Deleted successfully!!!</p>");
		}
		else {
			p.println("<p font-size='30'>Not deleted</p>");
			p.println("<a href='Delete.jsp'>Try again</a>");
		}
			
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
			



		
		
		
		
		
		
		
		
		
		
		
	}

}

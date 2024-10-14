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


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="jdbc:mysql://localhost:3306/project";
		String username ="root";
		String password ="Harish@234";
		
		String query="update Signup set Password =? where Email=?";
		
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
	    
		
		try {
			PrintWriter p=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2,email);
			int x =ps.executeUpdate();
			
			if(x>0) {
				RequestDispatcher r=request.getRequestDispatcher("Login.jsp");
				r.forward(request, response);
			}else {
				p.println("<p font-size-30>not updated</p>");
				p.println("<a href='Update.jsp'>Try again</a>");
			}
			
				
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

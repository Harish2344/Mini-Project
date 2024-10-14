package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url="jdbc:mysql://localhost:3306/project";
		String query="select * from Signup where Email=? and Password=?";
		
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		try {
			PrintWriter p=response.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","Harish@234");
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			p.println("Login Successfully");
			RequestDispatcher r=request.getRequestDispatcher("Mini.jsp");
			r.forward(request, response);
		}else {
			RequestDispatcher r=request.getRequestDispatcher("Loginfailed.jsp");
			r.forward(request, response);
		
         			
		}
		con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
				
		
	}

}

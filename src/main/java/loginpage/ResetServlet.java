package loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetServlet
 */
@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String UserName=request.getParameter("UserName");
		String Password=request.getParameter("Password");
		String Password1=request.getParameter("Password1");
		if(Password.equals(Password1))
		{
		  Password=Password1;
		  try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Users WHERE UserName=(?)");
	        ps.setString(1,UserName);
	        ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 PreparedStatement ps1 = con.prepareStatement("UPDATE Users SET Password=(?) WHERE UserName=(?)"); 
			        ps1.setString(1, Password);
			        ps1.setString(2, UserName);
			        ps1.executeUpdate();
					out.println("<font size=12>Password Changed Successfully !<br>");
					
					out.println("Click here to <a href=Login.jsp>Login</a>");
				 
			}else {
	        
			out.println("<font color=red size=18>UserName Doesn't Exist!<br>");
			
			out.println("<a href=Reset.jsp>Try Again!!</a>");
			}
			}
			catch(Exception e)
			{
			System.out.print(e);
			e.printStackTrace();
			}
		}else {
			out.println("<font color=red size=18>Passwords Dont't Match!!<br>");
		    out.println("<a href=Reset.jsp>Try Again!</a>");
		}
	}

}

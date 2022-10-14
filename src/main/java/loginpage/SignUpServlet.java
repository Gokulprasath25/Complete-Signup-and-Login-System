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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("Name");
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
				 out.println("<font color=red size=18>User Name Already Exist!!<br>");
				    out.println("<a href=SignUp.jsp>Try Again!</a>");
			 }else {
	        PreparedStatement ps1 = con.prepareStatement("INSERT INTO Users(Name,UserName,Password) VALUES(?,?,?)"); 
	        ps1.setString(1, Name);
	        ps1.setString(2, UserName);
	        ps1.setString(3, Password);
	        ps1.executeUpdate();
			out.println("<font color=royalblue size=12>Your Account has been Successfully Regitered !<br>");
			
			out.println("<a href=Login.jsp>Login</a> here to continue.");
			}
			}
			catch(Exception e)
			{
			System.out.print(e);
			e.printStackTrace();
			}
		}else {
			out.println("<font color=red size=18>Passwords Dont't Match!!<br>");
		    out.println("<a href=SignUp.jsp>Try Again!</a>");
		}
		
	}

}

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter(); 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gokul","root","Root@25");
			String un=request.getParameter("txtName");
			String p=request.getParameter("txtpwd");
			PreparedStatement ps=con.prepareStatement("SELECT Name FROM users WHERE UserName = (?) AND Password=(?)");
			ps.setString(1, un);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				out.println("<font color=RoyalBlue size=10>Hello "+rs.getString(1)+",<br>");
				out.println("You've Successfully Logged in :)");
			}else
			{
		      out.println("<font color=red size=15>Login Failed!!<br>");
		      out.println("<a href=Login.jsp>Try Again!</a>");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}

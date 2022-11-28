

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.sql.Connection con=new DatabaseManager().getConnection();
		String voterid=request.getParameter("adminVoterId");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			PreparedStatement statement=con.prepareStatement("SELECT NAME,VOTER_ID, ADMIN_PASSWORD FROM ADMIN_TABLE WHERE VOTER_ID='"+voterid+"';");
			java.sql.ResultSet rs=((java.sql.Statement)statement).executeQuery("SELECT NAME,VOTER_ID, ADMIN_PASSWORD FROM ADMIN_TABLE WHERE VOTER_ID='"+voterid+"';");
			if(rs.next()) {
				String originalPassword=rs.getString(3);
				String adminName=rs.getString(1);
				
				if(originalPassword.equals(password)) {
					HttpSession session=request.getSession();
					session.setAttribute("name", adminName);
					response.sendRedirect("adminLoggedin.jsp");
				
				}
				else {
					response.sendRedirect("wrongPassword.jsp");
//					out.println(originalPassword);
				}
			}
			else {
				out.println("User Does Not Exist.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

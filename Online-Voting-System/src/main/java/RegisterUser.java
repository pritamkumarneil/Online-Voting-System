

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		java.sql.Connection con=new DatabaseManager().getConnection();
		String voterid=request.getParameter("voterId");
		String name=request.getParameter("firstName")+" "+request.getParameter("lastName");
		String email=request.getParameter("emailId");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			java.sql.PreparedStatement queryStatement=con.prepareStatement("SELECT NAME,VOTER_ID, USER_PASSWORD FROM USER_TABLE WHERE VOTER_ID='"+voterid+"';");
			ResultSet resultPointer=((java.sql.Statement)queryStatement).executeQuery("SELECT NAME,VOTER_ID, USER_PASSWORD FROM USER_TABLE WHERE VOTER_ID='"+voterid+"';");
			if(resultPointer.next()) {
				out.println("User Already Exist. Try Log In");
			}
			else {
				try {
						java.sql.PreparedStatement statement=con.prepareStatement("INSERT INTO USER_TABLE(VOTER_ID,NAME,EMAIL,PHONE,DOB,USER_PASSWORD,ADDRESS) VALUES('"+voterid+"','"+name+"','"+email+"','"+phone+"','"+dob+"','"+password+"','"+address+"');");
						int updatedRow=((java.sql.Statement)statement).executeUpdate("INSERT INTO USER_TABLE(VOTER_ID,NAME,EMAIL,PHONE,DOB,USER_PASSWORD,ADDRESS) VALUES('"+voterid+"','"+name+"','"+email+"','"+phone+"','"+dob+"','"+password+"','"+address+"');");
						if(updatedRow!=0) {
							response.sendRedirect("registrationSucces.jsp");
						}
						else {
							out.println("Some Error Occurd. Please Try after sometime.");
						}
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						out.println("sqlError"+phone);
						e.printStackTrace();
					}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}

}

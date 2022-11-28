

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * Servlet implementation class Userlogin
 */
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
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
		java.sql.Connection con=new DatabaseManager().getConnection();// CREATING CONNECTION WITH DATABASE;
		response.setContentType("text/html");// sets type of contenet that printwrite is gonna use 
		PrintWriter out=response.getWriter();
		if(con==null) {
			out.println("Connection coudn't established!");
			response.sendRedirect("index.jsp");
			return;
		}
		String voterid=request.getParameter("voterid");
		String password=request.getParameter("password");
		//out.println("Working dude!");
		try {
			
				java.sql.PreparedStatement queryStatement=con.prepareStatement("SELECT NAME,VOTER_ID, USER_PASSWORD FROM USER_TABLE WHERE VOTER_ID='"+voterid+"';");
				ResultSet resultPointer=((java.sql.Statement)queryStatement).executeQuery("SELECT NAME,VOTER_ID, USER_PASSWORD FROM USER_TABLE WHERE VOTER_ID='"+voterid+"';");
				if(resultPointer.next()) {// if data found int he database then store it in the string
					String originalPassword=resultPointer.getString(3);
					String name=resultPointer.getString(1);
					if(originalPassword.equals(password)) {
						HttpSession session=request.getSession();// this object 
						session.setAttribute("name", name+"-"+voterid);
//						session.getAttribute(name);
						response.sendRedirect("userLoggedin.jsp");
//						out.println("userLoggedin"+password);
					}
					else {
						response.sendRedirect("wrongPassword.jsp");
	//					out.println("Wrong Password TryAgain");
					}
				}
				else out.println("User Doesn't Exist.");
				
		}
		catch(java.sql.SQLException e) {
			e.printStackTrace();
			out.println("got exception"+voterid+" "+password);
			return;
		}
	}

}

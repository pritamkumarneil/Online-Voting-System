

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ActionOnVote
 */
public class ActionOnVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionOnVote() {
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
		HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect("index.jsp");
		}
		String arr[]=((String)session.getAttribute("name")).split("-");
		String voterid=arr[1];
		String partyName=request.getParameter("party_name");
		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
		try {
			PreparedStatement checkStatement=con.prepareStatement("SELECT VOTER_ID FROM VOTING_TABLE WHERE VOTER_ID='"+voterid+"';");
			ResultSet rs=((java.sql.Statement)checkStatement).executeQuery("SELECT VOTER_ID FROM VOTING_TABLE WHERE VOTER_ID='"+voterid+"';");
			if(rs.next()) {
//				out.println("You have already Casted the vote");
				response.sendRedirect("alreadyCasted.jsp");
			}
			else {
				try {
					PreparedStatement statement=con.prepareStatement("INSERT INTO VOTING_TABLE(VOTER_ID,PARTY_NAME) VALUES('"+voterid+"','"+partyName+"');");
					int affectedRow=((java.sql.Statement)statement).executeUpdate("INSERT INTO VOTING_TABLE(VOTER_ID,PARTY_NAME) VALUES('"+voterid+"','"+partyName+"');");
					if(affectedRow!=0) {
						response.sendRedirect("votingSuccess.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Voting Result</title>
  </head>
<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VOTING_SYSTEM","root","p@8292130776");
	session=request.getSession(false);
	String partyName[]={"","","","",""};
	
	int votecount[]={0,0,0,0,0};
	if(session==null){
		response.sendRedirect("sessionTimeOut.jsp");
	}
	else{
		PreparedStatement statement=con.prepareStatement("SELECT PARTY_NAME, COUNT(*) FROM VOTING_TABLE GROUP BY PARTY_NAME ORDER BY PARTY_NAME;");
		ResultSet rs=((Statement)statement).executeQuery("SELECT PARTY_NAME, COUNT(*) FROM VOTING_TABLE GROUP BY PARTY_NAME ORDER BY PARTY_NAME;");
		int i=0;
		while(rs.next()){
			partyName[i]=rs.getString(1);
			votecount[i]=rs.getInt(2);
			i++;
		}
	}
%>
  <%@include file="adminNavbar.jsp" %>
  <body>
    <div>
      <div class="result-container">
        <table class="result-table">
          <tr class="result-table-row">
            <th class="table-heading"><b>Party Symbol</b></th>
            <th class="table-heading"><b>Party Name</b></th>
            <th class="table-heading"><b>Votes</b></th>
          </tr>
          <tr class="result-table-row">
            <td class="party-logo result-data">
              <img src="images/Aap.jpg" alt="AAP" />
            </td>
            <td class="party-name">AAP</td>
            <td><%=votecount[0] %></td>
          </tr>
          <tr class="result-table-row">
            <td class="party-logo result-data">
              <img src="images/bjp.jpg" alt="BJP" />
            </td>
            <td class="party-name">BJP</td>
            <td><%=votecount[1] %></td>
          </tr>
          <tr class="result-table-row">
            <td class="party-logo result-data">
              <img src="images/bsp.jpg" alt="BSP" />
            </td>
            <td class="party-name">BSP</td>
            <td><%=votecount[2] %></td>
          </tr>
          <tr class="result-table-row">
            <td class="party-logo result-data">
              <img src="images/congress.png" alt="" />
            </td>
            <td class="party-name">Congress</td>
            <td><%=votecount[3] %></td>
          </tr>
          <tr class="result-table-row">
            <td class="party-logo result-data">
              <img src="images/CPI-banner.jpeg" alt="" />
            </td>
            <td class="party-name">CPI</td>
            <td><%=votecount[4] %></td>
          </tr>
          
        </table>
      </div>
    </div>
  </body>
</html>

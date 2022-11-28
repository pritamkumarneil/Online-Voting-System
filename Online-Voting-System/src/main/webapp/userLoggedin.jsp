<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession" %>
<%
	session=request.getSession(false);
	String arr[]=((String)session.getAttribute("name")).split("-");
	String name=arr[0];
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title><%=name%></title>
    <link rel="stylesheet" type="css" href="css/styles.css" />
  </head>
  <%@include file="userNavbar.jsp" %>
  <body>
    <div>
      <div class="form-container">
        <h1 style="font-style: italic">Hey <b><%=name%></b></h1>
        <div>
          <form action="ActionOnVote" method="post">
            <label> Choose party: </label>
            <select name="party_name">
              <option value="AAP">AAP</option>
              <option value="BJP">BJP</option>
              <option value="BSP">BSP</option>
              <option value="Congress">Congress</option>
              <option value="CPI">CPI</option>
            </select>
            <button type="submit">Cast Vote</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>

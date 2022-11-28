<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <%@include file="navbar.jsp" %>
  <body class="admin-body">
    <div class="admin-login-container">
      <div class="form-container">
        <h3>Admin Login</h3>
        <!-- this will call java post function after pressing logi button-->
        <form action="AdminLogin" method="post">
          <label for="voterid" class="form-elements form-label"
            ><b>Voter ID</b><span style="color: red">*</span> :</label
          >
          <input
            id="voterid"
            type="text"
            class="form-elements form-input"
            name="adminVoterId"
            required
          />
          <label for="password" class="form-elements form-label"
            ><b>Password</b><span style="color: red">*</span> :</label
          >
          <input
            id="password"
            type="password"
            class="form-elements form-input"
            name="password"
            required
          />
          <button type="submit" class="form-elements login-button">
            Login
          </button>
          <a class="form-elements login-a" href="forgotPassword.jsp"
            >Forgot Password</a
          >
        </form>
      </div>
    </div>
  </body>
</html>

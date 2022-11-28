<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Online Voting System</title>
    <link rel="stylesheet" type="css" href="css/styles.css" />
  </head>
  <%@include file="navbar.jsp" %>
  <body class="index-body">
    <div class="form-container">
      <form action="Userlogin" method="post">
        <h3>Log In</h3>
        <label for="username" class="form-elements form-label"
          ><b>Voter ID<span style="color: red">*</span> :</b></label
        ><br />
        <input
          type="text"
          id="username"
          class="form-elements form-input"
          name="voterid"
          required
        /><br />
        <label for="password" class="form-elements form-label"
          ><b>Password<span style="color: red">*</span> :</b></label
        ><br />
        <input
          type="password"
          id="password"
          class="form-elements form-input"
          name="password"
          required
        />
        <br />
        <button type="submit" class="form-elements login-button">Log In</button>
        <a href="registerUser.jsp">
          <button type="button" class="form-elements login-button">
            Register
          </button>
        </a>
        <br />
        <div class="forgot-and-admin">
          <a class="form-elements login-a" href="forgotPassword.jsp">
            Forgot Password</a
          >
          <!-- <a class="login-a" href="registerUser.jsp">Register New User</a><br /> -->
          <a class="form-elements login-a" href="adminLogin.jsp"
            ><span>Admin Login</span></a
          >
        </div>
      </form>
    </div>
  </body>
</html>

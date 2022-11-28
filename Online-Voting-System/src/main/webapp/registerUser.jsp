<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>User Registration</title>
    <link rel="stylesheet" type="css" href="css/styles.css" />
  </head>
  <%@include file="navbar.jsp" %>
  <body class="user-registration-body">
    <div class="user-registration-form-container">
      <div class="form-container">
        <h3>New User Registration!</h3>
        <form action="RegisterUser" method="post">
          <label for="firstName" class="form-elements"
            ><b>First Name</b><span style="color: red">*</span> :</label
          >
          <input
            id="firstName"
            class="form-elements form-input"
            type="text"
            name="firstName"
            required
          />
          <label for="lastName" class="form-elements"
            ><b>Last Name</b><span style="color: red">*</span> :</label
          >
          <input
            id="lastname"
            class="form-elements form-input"
            type="text"
            name="lastName"
            required
          />
          <label for="voterid" class="form-elements"
            ><b>Voter ID</b><span style="color: red">*</span> :</label
          >
          <input
            id="voterid"
            class="form-elements form-input"
            type="text"
            name="voterId"
            required
          />
          <label for="emailid" class="form-elements"
            ><b>Email Id</b><span style="color: red">*</span> :</label
          >
          <input
            id="emailid"
            class="form-elements form-input"
            type="email"
            name="emailId"
            required
          />
          <label for="phone" class="form-elements"
            ><b>Phone</b><span style="color: red">*</span> :</label
          >
          <input
            id="phone"
            class="form-elements form-input"
            type="number"
            name="phone"
            required
          />
          <label for="dob" class="form-elements"
            ><b>Date Of Birth</b><span style="color: red">*</span> :</label
          >
          <input
            id="dob"
            class="form-elements form-input"
            type="date"
            name="dob"
            required
          />
          <label for="password" class="form-elements"
            ><b>Password</b><span style="color: red">*</span> :</label
          >
          <input
            id="password"
            class="form-elements form-input"
            type="password"
            name="password"
            required
          />
          <label for="address" class="form-elements">Address:</label>
          <input
            id="address"
            class="form-elements form-input"
            type="text"
            name="address"
            required
          />
          <button type="submit" class="form-elements login-button">
            Register
          </button>
        </form>
      </div>
    </div>
  </body>
</html>

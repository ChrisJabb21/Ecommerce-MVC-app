<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
   <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <title>Furniture Hub</title>
 -->    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<!--Main site Navigation bar-->

 <!--Navbar starter -->
    <nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="${contextPath}/" >
    Furniture Hub</a>
  </div>
    <div class="navbar-start"
      style="flex-grow: 1; justify-content: center;"
      >
      <a class="navbar-item" href="${contextPath}/">
        Home
      </a>
      
      <a class="navbar-item" href="${contextPath}/products">
            Products
          </a>

       <a class="navbar-item" href="about.jsp">
            About
          </a>

       <a class="navbar-item" href="about.jsp">
            Contact Us
          </a>

     
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a class="button is-primary" href="${contextPath}/registration">
            <strong>Sign up</strong>
          </a>
          <a class="button is-light" href="${contextPath}/login">
            Log in
          </a>
        </div>
      </div>
    </div>
 
</nav>
<body>

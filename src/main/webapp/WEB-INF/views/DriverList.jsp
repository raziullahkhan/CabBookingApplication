<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Drivers List</title>
</head>
<body>

<!-- Navbar Starts here -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    <img src="../images/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
    CAB BOOKING PORTAL</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Other Drivers</a>
        </li>
      </ul>
    </div>
    <form action="/CabBookingApplication" class="d-flex">
        <button class="btn btn-outline-danger" type="submit" style="margin-left: 20px;">Logout</button>
    </form>
  </div>
</nav>
<!-- Navbar Ends here -->


<!-- Profile Details -->
<div style="text-align: center; margin-top: 40px;">
    <button type="button" class="btn btn-info" style="text-align: center; font-size: larger; width: 500px;"><b>List of Drivers</b></button>
</div>


<table class="table table-dark table-striped mt-3" style="width: 1200px; margin-left: 80px;">
     <thead>
        <tr>
          <th scope="col">Driver Id</th>
          <th scope="col">Driver Name</th>
          <th scope="col">Driver Email</th>
          <th scope="col">Licence No</th>
          <th scope="col">Address</th>
          <th scope="col">Driver Rating</th>
          <th scope="col">Mobile Number</th>

        </tr>
    </thead>
    <c:forEach var="driver" items="${drivers}">
    <tbody>
        <tr>
  		  <td>${driver.driverId}</td>
          <td>${driver.username}</td>
          <td>${driver.email}</td>
          <td>${driver.licenceNo}</td>
          <td>${driver.address}</td>
          <td>${driver.rating}</td>
          <td>${driver.mobileNumber}</td>
        </tr>
    </tbody>
    </c:forEach>
</table>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
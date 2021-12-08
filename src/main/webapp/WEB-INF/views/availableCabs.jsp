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

<title>Available Cabs</title>
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
            <a class="nav-link active" aria-current="page" href="/CabBookingApplication/customer/home/${customer.customerId}">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">View Cabs</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/CabBookingApplication/trip/book">Book Trip</a>
          </li>
        </ul>

    <form action="/CabBookingApplication" class="d-flex">
        <button class="btn btn-outline-danger" type="submit" style="margin-left: 20px;">Logout</button>
    </form>
    </div>
  </div>
</nav>


<div style="text-align: center; margin-top: 40px;">
<button type="button" class="btn btn-info" style="text-align: center; font-size: larger; width: 500px;"><b>List of available cabs</b></button>
</div>

<table class="table table-dark table-striped mt-3" style="width: 1200px; margin-left: 80px;">
   <thead>
        <tr>
          <th>Cab Id</th>
          <th>Car Type</th>
          <th>Per Km Rate</th>
        </tr>
    </thead>
    <c:forEach var="cab" items="${cabs}">
   <tbody>
        <tr>
          <td>${cab.cabId}</td>
          <td>${cab.carType}</td>
          <td>${cab.perKmRate}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
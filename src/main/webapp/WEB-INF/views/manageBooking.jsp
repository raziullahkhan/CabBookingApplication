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

<title>Booking Management</title>
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
          <a class="nav-link active" aria-current="page" href="/CabBookingApplication/admin/home/${admin.adminId}">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Manage Booking</a>
          </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Manage Drivers</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Manage Cabs</a>
        </li>
      </ul>
    </div>
    <form action="/CabBookingApplication" class="d-flex">
        <button class="btn btn-outline-danger" type="submit" style="margin-left: 20px;">Logout</button>
    </form>
  </div>
</nav>
<!-- Navbar Ends here -->

<div class="alert alert-warning" role="alert" style="text-align: center;">
    <a href="#" class="alert-link">Booking Management</a>
</div>

<div class="card border-secondary mb-3" style="max-width: 18rem;text-align: center;margin-left: 550px;">
    <div class="card-header">Sort Bookings By</div>
    <div class="card-body text-secondary">
      <p class="card-text">
        <div class="dropdown">
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
            Select Sort Order
            </a>        
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
              <li><a class="dropdown-item" href="/CabBookingApplication/admin/tripcabwise">Trips Cabwise</a></li>
              <li><a class="dropdown-item" href="/CabBookingApplication/admin/tripcustomerwise">Trips CustomerWise</a></li>
            </ul>
          </div>
      </p>
    </div>
</div>

<table class="table table-dark table-striped mt-1" style="width: 1350px; margin-left: 10px;">
    <thead>
        <tr>
          <th scope="col">Booking ID</th>
          <th scope="col">Customer ID</th>
          <th scope="col">Start Location</th>
          <th scope="col">End Loation</th>
          <th scope="col">Distance</th>
          <th scope="col">Total Bill</th>
          <th scope="col">Status</th>
          <th scope="col">Delete</th>
        </tr>
    </thead>
     
    <tbody>
    <c:forEach var="trip" items="${trips}">
        <tr>
          <td>${trip.tripBookingId}</td>
          <td>${trip.customerId}</td>
          <td>${trip.fromLocation}</td>
          <td>${trip.toLocation}</td>
          <td>${trip.distanceInKm}</td>
          <td>&#8377;${trip.bill}</td>
          <td>${trip.status}</td>
          <td><button type="submit" class="btn btn-sm btn-danger"><a href="/CabBookingApplication/trip/delete/${trip.tripBookingId}" style="text-decoration: none; color: white;">Delete</a></button></td>
        </tr>
        </c:forEach>
    </tbody>
</table>



<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
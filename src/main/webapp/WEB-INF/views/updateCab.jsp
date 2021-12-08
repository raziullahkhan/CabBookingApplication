<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Update Cab</title>
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
<a href="#" class="alert-link">Update Cab</a>
</div>



<div style="height: 200px; max-width: 500px; background-color: rgb(171, 240, 217); margin-top: 20px; margin-left: 420px; border:2px solid blue; border-radius: 20px;">
    <form:form action="/CabBookingApplication/cab/update" modelAttribute="cab" method="post" style="max-height: 300px; max-width: 400px; margin-left: 50px;">
          <div class="mb-2">
          <input type="hidden" class="form-control" id="cabId" name="cabId" value="${cab.cabId}">
        </div>
        <div class="mb-2">
          <label for="carType" class="form-label">Car Type</label>
          <input type="text" class="form-control" id="carType" name="carType" value="${cab.carType}">
        </div>
        <div class="mb-2">
            <label for="perKmRate" class="form-label">Rate per Km</label>
            <input type="number" class="form-control" id="perKmRate" name="perKmRate" value="${cab.perKmRate}">
        </div>
        <button type="submit" class="btn btn-success" style="margin-left: 160px;">Update Cab</button>
    </form:form>
</div>


<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
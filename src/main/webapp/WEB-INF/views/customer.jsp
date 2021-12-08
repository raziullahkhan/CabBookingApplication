<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Customer Dashboard</title>
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
          <a class="nav-link" href="/CabBookingApplication/cab/viewcablist/${customer.customerId}">View Cabs</a>
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
<!-- Navbar Ends here -->

<div class="alert alert-primary" role="alert" style="text-align: center;">
    Welcome <a href="#" class="alert-link">${customer.username}</a>. Book your cabs anywhere anytime.
</div>

<!-- Profile Details -->
<h3 style="text-align: center; margin-top: 40px;">Profile Details</h3>

<div class="card mb-3 mt-2" style="max-width: 740px; margin-left: 300px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="../images/profile.png" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${customer.username}</h5>
        <p class="card-text"><b>Customer Id</b> : ${customer.customerId}</p>
        <p class="card-text"><b>Email</b> : ${customer.email}</p>
        <p class="card-text"><b>Address</b> : ${customer.address}</p>
        <p class="card-text"><b>Mobile No</b>: ${customer.mobileNumber}</p>
        <p class="card-text" style="margin-left: 70px;"> <small class="text-muted"><button class="btn btn-primary" type="button"><a href="/CabBookingApplication/customer/edit/${customer.customerId}" style="text-decoration: none; color: white;">Update</a></button></small></p>
      </div>
    </div>
  </div>
</div>


<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
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

<title>Admin Dashboard</title>
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
            <a class="nav-link" href="/CabBookingApplication/trip/all/${admin.adminId}">Manage Booking</a>
          </li>
        <li class="nav-item">
          <a class="nav-link" href="/CabBookingApplication/driver/driverlist">Manage Drivers</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/CabBookingApplication/cab/allcab">Manage Cabs</a>
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
<a href="#" class="alert-link">Admin Dashboard</a>
</div>

<!-- Profile Details -->
<h3 style="text-align: center; margin-top: 40px;">Admin Profile Details</h3>

<div class="card mb-3 mt-2" style="max-width: 740px; margin-left: 300px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="../images/profile.png" class="img-fluid rounded-start" alt="image">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${admin.username}</h5>
        <form  method="">
      <p class="card-text"><b>Admin Id</b> : ${admin.adminId}</p>
        <p class="card-text"><b>Email</b> : ${admin.email}</p>
        <p class="card-text"><b>Address</b> : ${admin.address}</p>
        <p class="card-text"><b>Mobile No</b>: ${admin.mobileNumber}</p>
        <p class="card-text" style="margin-left: 70px;"><small class="text-muted"><button class="btn btn-primary" type="button"><a href="/CabBookingApplication/admin/edit/${admin.adminId}" style="text-decoration: none; color: white;">Update</a></button></small></p>
        </form>
      </div>
    </div>
  </div>
</div>


<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
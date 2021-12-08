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

<title>Cab Booking Signup</title>
</head>
<body style="background-color: rgb(188, 181, 192);">
<h1 style="text-align: center; font-family:Georgia, 'Times New Roman', Times, serif;">CAB BOOKING PORTAL</h1>
<div style="height: 520px; max-width: 500px; background-color: rgb(171, 240, 217); margin-top: 20px; margin-left: 420px; border:2px solid blue; border-radius: 20px;">
    <h3 style="text-align: center;">SIGNUP</h3>
    <form:form action="add" method="post" modelAttribute="customer" style="max-height: 300px; max-width: 400px; margin-left: 50px;">
        <div class="mb-2">
          <label for="username" class="form-label">Username</label>
          <input type="text" class="form-control" id="username" path="username" name="username">
        </div>
        <div class="mb-2">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" path="email" name="email">
        </div>
        <div class="mb-2">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" path="address" name="address">
        </div>
        <div class="mb-2">
            <label for="mobileNumber" class="form-label">Mobile Number</label>
            <input type="text" class="form-control" id="mobileNumber" path="mobileNumber" name="mobileNumber">
        </div>
        <div class="mb-2">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" path="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary" style="margin-left: 160px;">Signup</button>
        <p style="text-align: center;">Already Signed Up? <a href="/CabBookingApplication/login/form" style="text-decoration: none;">Login</a></p>
    </form:form>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
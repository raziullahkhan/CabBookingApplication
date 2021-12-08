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

<title>Cab Booking Login</title>
</head>
<body style="background-color: rgb(188, 181, 192);">
    <h1 style="text-align: center; font-family:Georgia, 'Times New Roman', Times, serif;">CAB BOOKING PORTAL</h1>
<div style="max-height: 400px; max-width: 500px; background-color: rgb(171, 240, 217); margin-top: 100px; margin-left: 420px; border:2px solid blue; border-radius: 20px;">
    <h3 style="text-align: center;">LOGIN</h3><br>
    <form action="validate" method="post" style="max-height: 300px; max-width: 400px; margin-left: 50px;">
        <div style="margin-left: 100px;">
        	<h5>${fail}</h5>
            <label for="role">Select Your Role: </label>
            <select name="role" id="role">
              <option value="Admin">Admin</option>
              <option value="Customer" selected>Customer</option>
              <option value="Driver">Driver</option>
            </select>
          </div>
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="email" class="form-control" id="username" name="username">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-success" style="margin-left: 160px;">Login</button>
    </form>
    <br>
    <p style="text-align: center;">New user? <a href="/CabBookingApplication/customer/signup" style="text-decoration: none;">SignUp</a></p>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
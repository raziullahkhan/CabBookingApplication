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

<title>Cab Booking Trip</title>
</head>
<body style="background-color: rgb(211, 215, 224);">

<div style="height: 580px; max-width: 500px; background-color: rgb(119, 221, 187); margin-top: 20px; margin-left: 420px; border:2px solid blue; border-radius: 20px;">
    <h3 style="text-align: center;">Book Your Trip</h3>
    <form:form action="add" method="post" modelAttribute="trip" style="max-height: 300px; max-width: 400px; margin-left: 50px;">
        <div class="mb-2">
          <label for="customerId" class="form-label">Customer Id</label>
          <input type="number" class="form-control" id="customerId" name="customerId" required>
        </div>
        <div class="mb-2">
            <label for="driverId" class="form-label">Driver Id</label>
            <input type="number" class="form-control" id="driverId" name="driverId">
        </div>
        <div class="mb-2">
            <label for="fromLocation" class="form-label">Starting Location</label>
            <input type="text" class="form-control" id="fromLocation" name="fromLocation" required>
        </div>
        <div class="mb-2">
            <label for="toLocation" class="form-label">Destination</label>
            <input type="text" class="form-control" id="dest" name="toLocation" required>
        </div>
        <div class="mb-2">
          <label for="distanceInKm" class="form-label">Distance (Km)</label>
          <input type="number" class="form-control" id="distanceInKm" name="distanceInKm" required>
        </div>
        <div class="mb-2">
            <label for="bill" class="form-label">Bill Amount</label>
            <input type="text" class="form-control" id="bill" name="bill">
        </div>
        <br>
        <button type="submit" class="btn btn-primary" style="margin-left: 160px;">Book Trip</button>
    </form:form>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
<h1>Find Flights</h1>
<form action="findFlight" method="post">
From:<input type="text" name="From">
To:<input type="text" name="To">
departureDate:<input type="text" name="departureDate">
<input type="submit" value="find">
</form>

</body>
</html>
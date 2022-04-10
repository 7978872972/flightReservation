<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Flight Details</h2>
Flight Number=${flight.flightNumber}</br>
Flight operatingAirlines=${flight.operatingAirlines}</br>
Flight departureCity=${flight.departureCity}</br>
Flight arrivalCity=${flight.arrivalCity}</br>
Flight dateOfDeparture=${flight.dateOfDeparture}</br>
Flight estimatedDepartureTime=${flight.estimatedDepartureTime}</br>
<h2>Enter Passenger Details</h2>
<form action="completeReservation" method="post">
<pre>
firstName<input type="text" name="firstName">
lastName<input type="text" name="lastName">
middleName<input type="text" name="middleName">
email<input type="text" name="email">
phone<input type="text" name="phone">
<input type="hidden" name="flightId" value="${flight.id}">
<h2>Enter Card Details</h2>
Card Number<input type="text" name="CardNumber">
NAme On The Card<input type="text" name="NameOnTheCard">
CVV<input type="text" name="CVV">
Expire Dtae<input type="text" name="ExpireDate">
<input type="submit" name="Reserve">
</pre>
</form>
</body>
</html>
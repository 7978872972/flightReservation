<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
<h1>Create New Account</h1>
<form action="saveRegistration" method="post">
<pre>
firstName<input type="text" name="firstName"/>
lastName<input type="text" name="lastName"/>
email<input type="text" name="email"/>
password<input type="text" name="password"/>
<input type="submit" name="save"/>
</pre>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login Here</h1>
<form action="verifyLogin" method="post">
<pre>
email<input type="text" name="email">
password<input type="password" name="password">
<input type="submit" name="login">
</pre>
</form>
${msg}
</body>
</html>
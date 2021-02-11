<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


details : <br>

<form action="getdetails" method="post">
	cid : <input type="number", name="cid">
	<input type="submit" value="submit">
	

</form>

${customers}

</body>
</html>
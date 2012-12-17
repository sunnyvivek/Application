<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Wheather Detail</title>
</head>
<body>
<hr>
City   : ${wetherData.city}</br>
State : ${wetherData.state}</br>
Temprature : ${wetherData.temp} F</br>
<hr>
<input type=button value="Back" onCLick="history.back()">
</body>
</html>
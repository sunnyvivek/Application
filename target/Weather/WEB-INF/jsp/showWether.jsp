<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Wether Info</title>
<style>
body {
	font-family: Calibri;
}

table {
	border: 1px solid;
	border-collapse: collapse;
}

td {
	border: 1px solid;
}

th {
	background: #ffbb00 solid;
}

</style>
</head>
<body>

	<h2>Display Wheather Details</h2>
	<form:form method="post" action="displayWhether" commandName="wetherData">
	<%-- <form:form method="POST" commandName="wetherForm"> --%>
		<table>
			<tr><font color="red"><form:errors path="zipCode" /></font>
				<td>Zip Code :</td>
				<td><form:input path="zipCode" /></td>
			</tr>
		</table>
		<br />

		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>

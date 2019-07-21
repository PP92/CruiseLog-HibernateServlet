<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/FormStyle.css" type="text/css">
<title>Formularz nowego jachtu</title>
</head>
<body>

	<div class="form-style-5">
		<form action="CruisesController" method="get">
			<h1>Dodaj nowy Jacht:</h1>
			<input type="hidden" name="task" value="addYacht" />
			<br> Nazwa yachtu
			<input type="text" name="yachtName" required />
			<br> Model
			<input type="text" name="model" required />
			<br> Długość [m]
			<input type="number" step="0.01" name="length" required />
			<br> Liczba koi
			<input type="number" name="berths" required />
			<br>
			<input type="submit" value="Utwórz!" />
		</form> <br>
		<form action="CruisesController">
			<input type="hidden" name="task" value="listYachts" />
			<input type="submit" value="Powrót do listy jachtów" />
		</form> <br>
		<form action="CruisesController">
			<input type="hidden" name="task" value="listCruises" />
			<input type="submit" value="Powrót do listy rejsów" />
		</form>

	</div>
</body>
</html>
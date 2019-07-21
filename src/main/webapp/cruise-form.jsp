<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/FormStyle.css" type="text/css">
<title>Formularz nowego rejsu</title>
</head>
<body>

	<div class="form-style-5">




		<form action="CruisesController" method="get">
			<h1>Dodaj nowy rejs:</h1>
			<input type="hidden" name="task" value="addCruise" />
			<br> Imię kapitana:
			<input type="text" name="captainName" required />
			<br> Miejsce:
			<input type="text" name="location" required />
			<br> Przepłynięte mile
			<input type="number" name="distance" required />
			<br>

			<input type="submit" value="Utwórz!" />
		</form> <br>
		<form action="CruisesController">
			<input type="hidden" name="task" value="listCruises" />
			<input type="submit" value="Powrót do listy" />
		</form>

	</div>
</body>
</html>
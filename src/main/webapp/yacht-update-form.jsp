<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edytuj dane jachtu</title>
<link rel="stylesheet" href="css/FormStyle.css" type="text/css">
</head>
<body>

	<div class="form-style-5">
		<form action="CruisesController" method="get">
			${cruiseToUpdate.id}
			<h1>Zaktualizuj dane yachtu</h1>
			<input type="hidden" name="task" value="updateYacht" />
			<input type="hidden" name="yachtId" value="${yachtToUpdate.id}" />

			<br>Nazwa jachtu:
			<input type="text" name="yachtName" value="${yachtToUpdate.yachtName}" required />
			<br>Model:
			<input type="text" name="model" value="${yachtToUpdate.model}" required />
			<br> Długość
			<input type="number" name="length" value="${yachtToUpdate.length}" required />
			<br>Liczba koi
			<input type="number" name="berths" value="${yachtToUpdate.berths}" required />
			<input type="submit" value="Zapisz!" />
		</form> <br>

		<form action="CruisesController">
			<input type="hidden" name="task" value="listYachts" />
			<input type="submit" value="Powrót do listy" />
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edytuj dane rejsu</title>
<link rel="stylesheet" href="css/FormStyle.css" type="text/css">
</head>
<body>

	<div class="form-style-5">
		<form action="CruisesController" method="get">
			<h1>Edytuj dane rejsu</h1>
			<input type="hidden" name="task" value="updateCruise" />
			<input type="hidden" name="cruiseId" value="${cruiseToUpdate.id}" />
			<br> Imię kapitana:
			<input type="text" name="captainName" value="${cruiseToUpdate.captainName}" required />
			<br> Miejsce:
			<input type="text" name="location" value="${cruiseToUpdate.location}" required />
			<br> Przepłynięte mile:
			<input type="number" name="distance" value="${cruiseToUpdate.distance}" required />
			<br> Yacht: <select name="yachtId">
				<option value="0">WYBIERZ JACHT</option>
				<c:forEach var="entry" items="${yachtsList}">
					<c:choose>
						<c:when test="${cruiseToUpdate.yacht.id==entry.id}">
							<option selected value="${entry.id}">${entry.model}</option>
						</c:when>
						<c:otherwise>
							<option value="${entry.id}">${entry.model}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select> <br>
			<input type="submit" value="Zapisz!" />
		</form> <br>


		<form action="CruisesController">
			<input type="hidden" name="task" value="listCruises" />
			<input type="submit" value="Powrót do listy" />
		</form>
	</div>
</body>
</html>
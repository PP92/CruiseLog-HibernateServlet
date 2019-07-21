<%@page import="com.pp.model.Cruise"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dane rejsu</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<h1>Dane rejsu</h1>

		<div class="row header">
			<div class="cell">Dane rejsu</div>
			<div class="cell"></div>
	</div>
		<div class="row">
			<div class="cell">ID</div>
			<div class="cell">${param.cruiseId}</div>
	</div>
		<div class="row">
			<div class="cell">Kapitan</div>
			<div class="cell">${cruise.captainName}</div>
	</div>
		<div class="row">
			<div class="cell">Miejsce</div>
			<div class="cell">${cruise.location}</div>
	</div> <c:if test="${cruise.yacht!=null}">
			<div class="row">
				<div class="cell">Jacht:</div>

				<div class="cell">
					<form action="CruisesController" method="get">
						<input type="hidden" name="task" value="showYacht" />
						<input type="hidden" name="yachtId" value="${cruise.yacht.id}" />
						<input type="hidden" name="cruiseId" value="${param.cruiseId}" />
						<input type="submit" value="${cruise.yacht.model}" />
					</form>
			</div>

			</div>
		</c:if>
		<div class="row">
			<div class="cell">Przepłynięte mile</div>
			<div class="cell">${cruise.distance}</div>
	</div>


		<div class="row">
			<div class="cell">
				<form action="CruisesController" method="get">
					<input type="hidden" name="task" value="editCruise" />
					<input type="hidden" name="cruiseId" value="${param.cruiseId}" />
					<input type="submit" value="Edytuj" />
				</form>
		</div>
			<div class="cell">
				<form action="CruisesController" method="get">
					<input type="hidden" name="task" value="deleteCruise" />
					<input type="hidden" name="cruiseId" value="${param.cruiseId}" />
					<input type="submit" value="Usuń" />
				</form>
		</div>
	</div> <br>
		<form action="CruisesController">
			<input type="submit" value="Powrót do listy" />
		</form>
	</div>
</body>
</html>
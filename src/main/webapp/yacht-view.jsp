<%@page import="com.pp.model.Cruise"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dane jachtu</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<h1>Dane jachtu</h1>

		<div class="row header">
			<div class="cell">Dane jachtu</div>
			<div class="cell"></div>
	</div>
		<div class="row">
			<div class="cell">ID</div>
			<div class="cell">${yacht.id}</div>
	</div>
		<div class="row">
			<div class="cell">Nazwa</div>
			<div class="cell">${yacht.yachtName}</div>
	</div>
		<div class="row">
			<div class="cell">Model</div>
			<div class="cell">${yacht.model}</div>
	</div>
		<div class="row">
			<div class="cell">Długość [m]</div>
			<div class="cell">${yacht.length}</div>
	</div>
		<div class="row">
			<div class="cell">Ilość koi</div>
			<div class="cell">${yacht.berths}</div>
	</div>
	<br>
		<form action="CruisesController">
			<input type="hidden" name="task" value="showCruise" />
			<input type="hidden" name="cruiseId" value="${param.cruiseId}" />
			<input type="submit" value="Powrót" />
		</form>
	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Lista jachtów</title>
</head>
<body>
	<div class="wrapper">
			<h1>Lista jachtów</h1>
		<div class="table">

			<div class="row header">
				<div class="cell">Lp.</div>
				<div class="cell">ID</div>
				<div class="cell">Nazwa</div>
				<div class="cell">Model</div>
				<div class="cell">Długość[m]</div>
				<div class="cell">Liczba koi</div>
				<div class="cell"></div>
				<div class="cell"></div>
				
		</div> <c:forEach var="entry" items="${yachtsList}" varStatus="loop">
				<div class="row">
					<div class="cell">${loop.index + 1}</div>
					<div class="cell">${entry.id}</div>
					<div class="cell">${entry.yachtName}</div>
					<div class="cell">${entry.model}</div>
					<div class="cell">${entry.length}</div>
					<div class="cell">${entry.berths}</div>
					<div class="cell">
						<form action="CruisesController" method="get">
							<input type="hidden" name="task" value="editYacht" />
							<input type="hidden" name="yachtId" value="${entry.id}" />
							<input type="submit" value="Edytuj" />
						</form>
				</div>
					<div class="cell">
						<form action="CruisesController" method="get">
							<input type="hidden" name="task" value="deleteYacht" />
							<input type="hidden" name="yachtId" value="${entry.id}" />
							<input type="submit" value="Usuń" />
						</form>
				</div>
				</div>
			</c:forEach>
	</div>

		<form action="yacht-form.jsp">
			<input type="submit" value="Dodaj nowy jacht" />
		</form> <br>
		<form action="CruisesController">
			<input type="hidden" name="task" value="listCruises" />
			<input type="submit" value="Powrót do listy rejsów" />
		</form>
	</div>
	
</body>
</html>
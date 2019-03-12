<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container bg-light mt-3 p-3">
		<div class="form-row">
			<label for="gold" class="col-form-label col-sm-1" >Your Gold:</label>
			<input class="form-control col-sm-1" disabled id="gold" value="<c:out value="${game.getGold()}"/>">
			<a href="/reset" class="btn btn-danger col-sm-2 offset-sm-8">Declare Bankruptcy</a>
		</div>
		<div class="row">
		<c:forEach items="${game.getLocations()}" var="l">
			<div class="card text-center col m-3 p-3">
				<h3><c:out value="${l.getName()}"/></h3>
				<h4><c:out value="${l.getDescription()}"/></h4>
				<form action="process" method="POST">
					<input type="hidden" name="location" value=<c:out value="${l.getName()}"></c:out>>
					<button type="submit" class="btn btn-secondary col-sm-8">Find Gold!</button>
				</form>
			</div>
		</c:forEach>
		</div>
		<div class="form-group">
			<label>Activities:</label>
			<div class="container overflow-auto" style="max-height:8em">
			<c:forEach items="${game.getLog()}" var="log">
				<p class="mb-0" style="color: <c:out value='${log.getColor()}'></c:out>">
					<c:out value="${log.getLogLine()}"/>
				</p>
			</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
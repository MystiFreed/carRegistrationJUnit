<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle Edit</title>
</head>
<body>
	<form action = "registrationEditorServlet" method="post">
	Vehicle Information:<br />
	Make: <input type ="text" name = "make" value="${vehToEdit.make}">
	Model: <input type = "text" name = "model" value= "${vehToEdit.model}">
	Year: <input type ="text" name = "year" value="${vehToEdit.year}">
	VIN: <input type = "text" name = "vin" value= "${vehToEdit.vin}">
	<input type = "hidden" name = "id" value="${vehToEdit.id}">
	<input type = "submit" value="Save Edited Vehicle">
	<br />
	Owner Information:<br />
	First Name: <input type ="text" name = "firstName" value="${ownerToEdit.firstName}">
	Last Name: <input type = "text" name = "lastName" value= "${ownerToEdit.lastName}">
	<input type = "hidden" name = "id" value="${ownerToEdit.id}">
	<input type = "submit" value="Save Edited Owner">
	</form>
</body>
</html>
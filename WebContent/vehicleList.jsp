<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Current Registered Vehicles</title>
</head>
<body>
<form method = "post" action = "editVehicleServlet"> 
	<table>
	<c:forEach items="${requestScope.allVehicles}" var="currentvehicle">
	<tr>
 		<td><input type="radio" name="id" value="${currentvehicle.id}"></td>
 		<td>${currentvehicle.make}</td>
 		<td>${currentvehicle.model}</td>
 	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "Edit Selected Vehicle" name="doThisToVehicle">
	<input type = "submit" value = "Delete Selected Vehicle" name="doThisToVehicle">
	</form>
	<br />
	<font face ="fantasy" size="4"> 
	<a href ="index.html">Back to Entry Screen</a><br />
	</font>
</body>
</html>
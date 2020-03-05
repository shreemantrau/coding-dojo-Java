<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninjas">
	<form:label path="dojo">
	<form:select path="dojo">Dojo:
		<c:forEach items="${dojos}" var="dojo">
			<option value="${dojo.id}">${dojo.name}</option>
		</c:forEach>
	</form:select>
	</form:label>
	
	<form:label path="firstName">First Name:
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	</form:label>
	
	<form:label path="lastName">Last Name:
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	</form:label>
	
	<form:label path="age">Age:
	<form:errors path="age"/>
	<form:input path="age"/>
	</form:label>
	
	<input type="submit" value="Create">
</form:form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><c:out value="${event.name}"/></title>
</head>
<body>
	
		<h1><c:out value="${event.name}"/></h1>
		<a href="/logout"> <h2>Logout</h2> </a>
		
			<h3>Edit Event</h3>
			<form:form method="post" action="/events/${id}/edit" modelAttribute="eve">
				<input type="hidden" name="_method" value="put">
				<h4 class="avoid">
					<form:label path="name">Name:</form:label>
					<form:input  type="text" path="name"/>
				</h4>
				<h4 class="avoid">
					<form:label path="date">Date:</form:label>
					<form:input  type="date" path="date"/>
				</h4>
				<h4 class="avoid">
					<form:label path="location">Location:</form:label>
					<form:select cssClass="state" path="state">
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>
					</form:select>
					<form:input cssClass="smfields" type="text" path="location"/>
				</h4>
				<form:hidden path="user" value="${user.id}"/>
				<input  type="submit" value="Edit"/>
			</form:form>
			<form:errors  path="eve.*"/>
		
		
		
</body>
</html>
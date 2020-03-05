<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Welcome</title>
</head>
<body>
	
		<h1>Welcome</h1>
		
			<h1>Register</h1>
			<form:form method="post" action="/register" modelAttribute="u">
				
					<form:label path="firstName">First Name:</form:label>
					<form:input type="text" path="firstName"/>
				
					<form:label path="lastName">Last Name:</form:label>
					<form:input  type="text" path="lastName"/>
				
				
					<form:label path="email">Email:</form:label>
					<form:input type="email" path="email"/>
				
				
					<form:label path="location">Location:</form:label>
					<form:select cssClass="state" path="state">
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>
					</form:select>
					<form:input  type="text" path="location"/>
				
					<form:label path="password">Password:</form:label>
					<form:password path="password"/>
				
					<form:label path="confirmPassword">Confirm Password:</form:label>
					<form:password  path="confirmPassword"/>
				
				<input class="btn" type="submit" value="Register"/>
			</form:form>
			<form:errors path="u.*"/>
		<c:out value="${error}"/>
		
			<h1>Login</h1>
			<form action="/login" method="post">
				<h4>Email:<input  type="email" name="email"></h4>
				<h4>Password:<input  type="password" name="password"></h4>
				<input class="btn" type="submit" value="Login">
			</form>
			
		
</body>
</html>
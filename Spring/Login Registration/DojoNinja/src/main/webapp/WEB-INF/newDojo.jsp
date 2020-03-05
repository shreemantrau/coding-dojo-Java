<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> New Dojo! </h1>
 
 <form:form action="/createDojo" method="POST" modelAttribute="dojo">
 	<form:label path="name"> Name
 	<form:errors path="name"/>
 	<form:input path="name"/>
 	</form:label>
 
 <input type="submit" value="create">
 </form:form> 
 
</body>
</html>
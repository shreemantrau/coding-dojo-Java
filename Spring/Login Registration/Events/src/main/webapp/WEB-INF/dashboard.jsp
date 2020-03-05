<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<title>Events</title>
</head>
<body>
	<div id="container">
		<h1 class="fltleft">Welcome, <c:out value="${user.firstName}"/></h1>
		<a class="fltright" href="/logout"><h3>Logout</h3></a>
		
		<c:if test="${sameState.size() == 0}"><h5>There are currently no events in your area...</h5></c:if>
		<c:if test="${sameState.size() != 0}"><h2>Here are some of the events in your state:</h2></c:if>
		
        <c:if test="${sameState.size() > 0}">
			<table class="table table-striped table-bordered table-hover">
				<thead>
	  				<tr>
	    				<th scope="col">Name</th>
					    <th scope="col">Date</th>
					    <th scope="col">Location</th>
					    <th scope="col">Host</th>
					    <th scope="col">Action/Status</th>
	  				</tr>
				</thead>
				<tbody>
					<c:forEach items="${sameState}" var="ss">
	  				<tr>
	  					<td><a href="/events/${ss.id}"><c:out value="${ss.name}"/></a></td>
					    <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${ss.date}"/></td>
					    <td><c:out value="${ss.location}"/></td>
					    <td><c:out value="${ss.user.firstName}"/></td>
                        <c:choose>
                        <c:when test="${ss.user == user}">
                            <td>*Attending* | <a href="/events/${ss.id}/edit">Edit</a> | <a href="events/${ss.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${ss.getJoinedUsers()}" var="attendee">
                                <c:if test="${attendee == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="/events/${ss.id}/join">Join</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>*Attending* | <a href="events/${ss.id}/cancel">Cancel</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                        </c:choose>  
	  				</tr>
	  				</c:forEach>
				</tbody>
			</table>
	</c:if>
	
	
	<br> <br>
		<c:if test="${diffState.size()>0 }" > <h3>Here are some of the events in other states:</h3> </c:if>
		<c:if test="${diffState.size()==0 }"><h3>There are no events in othe other states</h3> </c:if>
		<c:if test="${diffState.size() > 0}">
		<table class="table table-striped table-bordered table-hover">
			<thead>
  				<tr>
    				<th scope="col">Name</th>
				    <th scope="col">Date</th>
				    <th scope="col">Location</th>
				    <th scope="col">State</th>
				    <th scope="col">Host</th>
				    <th scope="col">Action</th>
  				</tr>
			</thead>
			<tbody>
				<c:forEach items="${diffState}" var="ds">
  				<tr>
  					<td><a href="/events/${ds.id}"><c:out value="${ds.name}"/></a></td>
				    <td><fmt:formatDate pattern ="MMMM dd, yyyy" value ="${ds.date}"/></td>
				    <td><c:out value="${ds.location}"/></td>
				    <td><c:out value="${ds.state}"/></td>
				    <td><c:out value="${ds.user.firstName}"/></td>
					<c:choose>
                        <c:when test="${ds.user == user}">
                            <td>*Attending* | <a href="/events/${ds.id}/edit">Edit</a> | <a href="events/${ds.id}/delete">Delete</a></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="attending" value="${false}"/>
                            <c:forEach items="${ds.getJoinedUsers()}" var="goer">
                                <c:if test="${goer == user}">
                                    <c:set var="attending" value="${true}"/>
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${attending == false}">
                                    <td><a href="/events/${out.id}/join">Join</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td>*Attending* | <a href="events/${out.id}/cancel">Cancel</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
  				</tr>
  				</c:forEach>
			</tbody>
		</table>
		
		</c:if>
		
		<br> <br> <br>
		
			<h2>Create an Event:</h2>
			<form:form method="post" action="/createEvent" modelAttribute="e">
				<h4 class="avoid">
					<form:label path="name">Name:</form:label>
					<form:input  type="text" path="name"/>
				</h4>
				<h4>
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
					<form:input type="text" path="location"/>
				</h4>
				<form:hidden path="user" value="${user.id}"/>
				<input  type="submit" value="Create"/>
			</form:form>
			<form:errors  path="e.*"/>
		</div>
		<div id="rghtpnl">
		</div>

</body>
</html>
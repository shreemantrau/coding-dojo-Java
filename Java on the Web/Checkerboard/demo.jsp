<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>demo</title>
</head>
<body>

<%!
	public int add(int a, int b){
	int c=a+b;
	return c;
}
%>

<%
	int a=1;
int b=2;


%>

<h2><% 	for(int i=0;i<10;i++){ %>
 	<h4><%= i %></h1>
	<%}%></h4>

<h3><%=add(a,b)
%></h3>

<p>The date is <%=new Date() %></p>
</body>
</html>
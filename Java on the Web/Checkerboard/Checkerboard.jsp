<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Styles.css">
<title>A web Page</title>
</head>
<body>

<body><div class="container"><% int width=0; int height=0;
if(request.getParameter("width") != null){
	width = Integer.parseInt(request.getParameter("width"));	
}
if(request.getParameter("height") != null){
	height = Integer.parseInt(request.getParameter("height"));
} %>
	<h1>Checkerboard: <%= width %>w X <%= height %>h</h1>
	<% for(int i=0; i<height; i++){
		if(i%2 == 0){%>
		<div class="roweven">
			<%for(int j=0; j<width; j++){
				if(j%2 == 0){%>
					<div class="one"></div>
				<%} else {%>
					
					<div class="two"></div>
				<%}
			}%>
			</div>
			
		<%} else{%>
		
			<div class="rowodd">
			
			<%for(int j=0; j<width; j++){
				if(j%2 == 0){%>
					<div class="one"></div>
				<%} else {%>
					<div class="two"></div>
				<%}
			}%>
			</div>
		<%} %>
	<%} %>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container-fluid">
        <div class="panel panel-success">
	<div class="panel-heading" align="center">
	
		<h4>
			<b><font color="black" style="font-family: fantasy;"> 
			<%
			 	String name = (String) request.getAttribute("uname");
			
			 	if (name != null) {
			%>
					Welcome <%=name%>, to DOCKERS!!!!  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="login.jsp">Sign Out</a>
			<%
			 	}
			%>
			</font> </b>
		</h4>
	</div>
	<div class="panel-body"align="center">
                 
                
                	<img alt="" src="Capture.PNG" width="900">
                
                </div>
<div class="panel-footer" align="center"><font style="color: #111">Copyright @2017  Tech Mahindra Pvt. Ltd., All Rights Reserved. </font></div>
        </div>
    </div>
</body>
</html>
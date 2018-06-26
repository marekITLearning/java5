<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!	String user, psw; %>
	
	<%
		user = request.getParameter("user");
		psw = request.getParameter("psw");
		if (user.equals("a") && psw.equals("b")) {
			%>
				<jsp:forward page="welcome.jsp"></jsp:forward>
			<%
		} else { %>
			
			<h2>Wrong username or password</h2>
			
			<%
		}
	%>


</body>
</html>
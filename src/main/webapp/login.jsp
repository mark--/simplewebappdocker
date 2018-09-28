
<%@page import="simplewebapp.Login"%>
<html>
<body>
	<%
	    if (new Login().login(request.getParameter("login"), request.getParameter("password"), session))
	    {
	        response.sendRedirect("start.jsp");
	    }
	    else
	    {
	        response.sendRedirect("index.jsp?msg=Ungueltig");
	    }
	%>
</body>
</html>

<%@page import="simplewebapp.Login"%>
<html>
<body>
	<h2>Hello World!</h2>

	<%=request.getParameter("msg")%>

	<form action="login.jsp">
		<label>Login</label><br /> <input type="text" name="login"> <br />
		<label>Passwort</label><br /> <input type="password" name="password"><br />
		<input type="submit" value="Login"><br />
	</form>

</body>
</html>

<html> 
<head> 
<title>Página que irá fazer um redirecionamento</title> 
</head> 

<body> 
	<h1> <% out.println("Página que irá fazer um redirecionamento"); %> </h1> 
<%
	response.sendRedirect("pagina-redirecionada.jsp");
%>
</body> 
</html>

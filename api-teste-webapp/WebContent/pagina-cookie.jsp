<html> 
<head> 
<title>Página que gera o cookie teste</title> 
</head> 

<body> 
	<h1> <% out.println("Página que gera o cookie teste=teste"); %> </h1> 
<%
	Cookie cookie = new Cookie("teste","teste");
	response.addCookie(cookie);
%>
</body> 
</html>

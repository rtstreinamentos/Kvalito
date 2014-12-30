<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Header Request</title>
</head>
<body>
	<h4>INFORMAÇÃO DO CABEÇALHO HTTP</h4>
	<table border="1">
		<%!Enumeration enm, header;
	String hName, hValue;%>
		<%
			enm = request.getHeaderNames();
			while (enm.hasMoreElements()) {
				hName = (String) enm.nextElement();
				header = request.getHeaders(hName);
				if (header != null) {
					while (header.hasMoreElements()) {
						hValue = (String) header.nextElement();
					}
				}
		%>
		<tr>
			<td><%=hName%></td>
			<td><%=hValue%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
	<h2>Create Lead</h2>
	<form action="updateOneLead" method ="post">
		<pre>
			<input type ="hidden" name="id" value="${lead.id}"/>
			<table>
		  <tr>
			<td>First Name</td>
			<td><input type="text" name="firstName" value="${lead.firstName}"/></td>
		  </tr> 
		  <tr>
		   <td>Last Name</td>
			<td><input type="text" name="lastName" value="${lead.lastName}"/></td>
		 </tr>
		 
		 <tr>
		   <td>Email</td>
			<td><input type="text" name="email" value="${lead.email}"/></td>
		 </tr>
		 
		 <tr>
		   <td>Mobile</td>
			<td><input type="text" name ="mobile" value="${lead.mobile}"/> </td>
		 </tr>
		</table>
	        <input type="submit" value="Update"/>
		
		</pre>
	
	</form>
	${msg}
	
</body>
</html>
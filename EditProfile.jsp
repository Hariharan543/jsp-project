<%@page import="com.dsrc.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! RegisterBean rb; %>
<%
	rb=(RegisterBean)session.getAttribute("details");

%>

<form action="EditController">
<center><b>EDIT</b></center>
<table>
<tr><td>Name</td><td><input type="text" name="name" value="<%= rb.getName() %>"></td></tr>
<tr><td>Age</td><td><input type="text" name="age" value="<%= rb.getAge() %>"></td></tr>

<tr><td>PhoneNumber</td><td><input type="text" name="phone" value="<%= rb.getPhoneNumber() %>"></td></tr>
<tr><td>Email</td><td><input type="text" name="email"></td></tr>
<tr><td>LoginId</td><td><input type="text" name="lid"></td></tr>

<tr><td><input type="submit" value="Edit"></td></tr>
</table>

</form>
<%
if(request.getAttribute("errorReason")!=null)
{ 
%>

<font color="red"><%= request.getAttribute("errorReason") %></font>

<% 
}
%>
</body>
</html>
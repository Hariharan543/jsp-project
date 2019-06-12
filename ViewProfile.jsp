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

<form action="ViewProfileController">
<table>
<tr><td>Name</td><td><%= rb.getName() %></td></tr>
<tr><td>Age</td><td><%= rb.getAge() %></td></tr>

<tr><td>PhoneNumber</td><td><%= rb.getPhoneNumber() %></td></tr>
<tr><td>Email</td><td><%= rb.getEmail() %></td></tr>
<%-- <tr><td>LoginId</td><td><%= request.getParameter("lid") %></td></tr>
<tr><td>Enter Password</td><td><%= request.getParameter("pass") %></td></tr>
<tr><td>Confirm Password</td><td><%= request.getParameter("cpass") %></td></tr> --%>

</table>

</form>
<a href="EditProfile.jsp">Edit My Profile</a>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm()
{
	var x=document.forms["myform"]["name"].value;
	if(x=="")
		{
		alert("name must be enterd");
		return false;
		}
	var y=document.forms["myform"]["age"].value;
	if(y=="")
		{
		alert("age must be enterd");
		return false;
		}
	var z=document.forms["myform"]["phone"].value;
	if(x=="")
		{
		alert("phoneno must be enterd");
		return false;
		}
	var a=document.forms["myform"]["email"].value;
	if(a=="")
		{
		alert("Email must be enterd");
		return false;
		}
	var b=document.forms["myform"]["name"].value;
	if(b=="")
		{
		alert("LoginId must be enterd");
		return false;
		}
	var c=document.forms["myform"]["name"].value;
	if(c=="")
		{
		alert("Password must be enterd");
		return false;
		}
	
	var d=document.forms["myform"]["name"].value;
	if(x=="")
		{
		alert("ConfirmPassword must be enterd");
		return false;
		}
	
	if(isNaN(y)||y<1||y>100)
		{
		alert("age shold be 1 to 100");
		return false;
		}
	}
</script>
</head>
<body>
<form action="RegistrationController" name="myform" onsubmit="return validateForm()">
<center><b>Registration</b></center>
<table>
<tr><td>Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Age</td><td><input type="text" name="age"></td></tr>
<tr><td>Gender</td><td><input type="radio" name="r1">Male<input type="radio" name="r1">Female</td></tr>
<tr><td>PhoneNumber</td><td><input type="text" name="phone"></td></tr>
<tr><td>Email</td><td><input type="text" name="email"></td></tr>
<tr><td>LoginId</td><td><input type="text" name="lid"></td></tr>
<tr><td>Password</td><td><input type="text" name="pass"></td></tr>
<tr><td><input type="submit" value="register"></td></tr>


</table>

</form>
<a href="HomePage.jsp">Home</a>

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
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
	var x=document.forms["myform"]["lid"].value;
	if(x=="")
		{
		alert("Enter LoginId");
		return false;
		}
	var y=document.forms["myform"]["npass"].value;
	if(y=="")
		{
		alert("Enter NewPassword");
		return false;
		}
	
	}
	</script>
</head>
<body>
<form action="ChangePasswordController" name="myform" onsubmit="return validateForm()">
<table>
<tr><td>LoginId</td><td><input type="text" name="lid"></td></tr>
<tr><td>Old Password</td><td><input type="text" name="pass"></td></tr>
<tr><td>New Password</td><td><input type="text" name="npass"></td></tr>
<tr><td><input type="submit" value="Change"></td></tr>
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
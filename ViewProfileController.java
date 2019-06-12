package com.dsrc.controller;
import com.dsrc.bean.RegisterBean;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProfileController
 */
@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterBean rb=new RegisterBean();
	PrintWriter out=response.getWriter();
		String Name=rb.getName();
		int Age=rb.getAge();
		String Gender=rb.getGender();
		int PhoneNumber=rb.getPhoneNumber();
		String Email=rb.getEmail();
		String UserName=rb.getLoginId();
		
		out.println("<html><body><form><table>");
		out.println("<tr><td>Name</td><td>"+Name+"</td></tr>");
		out.println("<tr><td>Age</td><td>"+Age+"</td></tr>");
		out.println("<tr><td>Gender</td><td>"+Gender+"</td></tr>");
		out.println("<tr><td>PhoneNumber</td><td>"+PhoneNumber+"</td></tr>");
		out.println("<tr><td>Email</td><td>"+Email+"</td></tr>");
		out.println("<tr><td>UserName</td><td>"+UserName+"</td></tr>");
		out.println("</table></form></body></html>");
		
	}


}

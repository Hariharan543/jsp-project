package com.dsrc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.RegisterBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.exceptions.RegistrationBusinessException;
import com.dsrc.exceptions.RegistrationException;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("name");
		int Age=Integer.parseInt(request.getParameter("age"));
	String Gender=request.getParameter("gender");
		int PhoneNumber=Integer.parseInt(request.getParameter("phone"));
		String Email=request.getParameter("email");
		String LoginId=request.getParameter("lid");
	
		RegisterBean regBean=new RegisterBean();
		regBean.setName(Name);
		regBean.setAge(Age);
		regBean.setGender(Gender);
		regBean.setPhoneNumber(PhoneNumber);
		regBean.setEmail(Email);
		regBean.setLoginId(LoginId);
		
		
		
		ProfileManagementBO pmbo=new ProfileManagementBO();
		try{
			boolean res=pmbo.editUser(regBean);
		
		if(res)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");  
			 request.setAttribute("Name", regBean.getName());
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");  
			 request.setAttribute("errorReason", "Registration failed");
			rd.forward(request, response);
		}}
		catch(RegistrationException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("EditProfile.jsp");  
			 request.setAttribute("errorReason", e.getMessage());
			rd.forward(request, response);
			
		}
		
	}
		
	}



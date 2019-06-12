package com.dsrc.controller;

import java.io.IOException;

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
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("name");
		int Age=Integer.parseInt(request.getParameter("age"));
		String Gender=request.getParameter("gender");
		int PhoneNumber=Integer.parseInt(request.getParameter("phone"));
		String Email=request.getParameter("email");
		String LoginId=request.getParameter("lid");
		String Password=request.getParameter("pass");
		String ConfirmPassword=request.getParameter("cpass");
		RegisterBean regBean=new RegisterBean();
		regBean.setName(Name);
		regBean.setAge(Age);
		regBean.setGender(Gender);
		regBean.setPhoneNumber(PhoneNumber);
		regBean.setEmail(Email);
		regBean.setLoginId(LoginId);
		regBean.setPassword(Password);
		regBean.setConfirmPassword(ConfirmPassword);
		
		
		ProfileManagementBO pmbo=new ProfileManagementBO();
		try{
			boolean res=pmbo.registerUser(regBean);
		
		if(res)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");  
			 request.setAttribute("Name", regBean.getName());
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");  
			 request.setAttribute("errorReason", "Registration failed");
			rd.forward(request, response);
		}}
		catch(RegistrationException|RegistrationBusinessException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");  
			 request.setAttribute("errorReason", e.getMessage());
			rd.forward(request, response);
			
		}
		
	}


}

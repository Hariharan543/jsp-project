package com.dsrc.controller;
import com.dsrc.bean.RegisterBean;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsrc.bean.LoginBean;
import com.dsrc.bo.ProfileManagementBO;
import com.dsrc.dao.ProfileManagementDAO;
import com.dsrc.exceptions.LoginBusinessException;
import com.dsrc.exceptions.LoginException;
import com.dsrc.exceptions.RegistrationBusinessException;
import com.dsrc.exceptions.RegistrationException;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{	
String LoginId = request.getParameter("lid");
String Password = request.getParameter("pass");


LoginBean logBean = new LoginBean(); 

logBean.setLoginId(LoginId);
logBean.setPassword(Password);
ProfileManagementDAO dao=new ProfileManagementDAO(); 

RegisterBean res = dao.validateLogin(logBean);


if(res.getAge()>0)
{
	HttpSession sess=request.getSession();
	RequestDispatcher rd=request.getRequestDispatcher("ViewProfile.jsp");  
	sess.setAttribute("details", res);
	rd.forward(request, response);
}
else
{
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
	 request.setAttribute("errorReason", "Login failed");
	rd.forward(request, response);
}}
catch( LoginException | RegistrationException e)
{
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
	 request.setAttribute("errorReason", e.getMessage());
	rd.forward(request, response);
	
}}}
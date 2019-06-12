package com.dsrc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bo.ProfileManagementBO;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChangePasswordBean cBean=new ChangePasswordBean();
		String LoginId=request.getParameter("lid");
		String OldPassword=request.getParameter("pass");
		String NewPassword=request.getParameter("npass");
		cBean.setLoginId(LoginId);
		cBean.setOldPassword(OldPassword);
		cBean.setNewPassword(NewPassword);
	try{
		boolean res=new ProfileManagementBO().changePassword(cBean);
		if(res)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			// request.setAttribute("errorReason", "updated");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");  
			  request.setAttribute("errorReason", "Not updated");
			rd.forward(request, response);
		}
	}
	catch(Exception e)
	{
		e.getMessage();
	}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

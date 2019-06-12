package com.dsrc.dao;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.dsrc.bean.ChangePasswordBean;
import com.dsrc.bean.LoginBean;
import com.dsrc.bean.RegisterBean;
import com.dsrc.exceptions.LoginException;
import com.dsrc.exceptions.RegistrationException;
import com.dsrc.exceptions.ViewProfileException;


public class ProfileManagementDAO {
	
	public RegisterBean validateLogin(LoginBean logBean) throws RegistrationException, LoginException
	{
		
		RegisterBean rb=new RegisterBean();
		// Do the logic for verifying the credentials with DB.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try {
			;
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","dsrc");
			//Statement st=con.createStatement();
				PreparedStatement ps= con.prepareStatement("select * from Registration where loginid=? and password=?");
				ps.setString(1, logBean.getLoginId());
				ps.setString(2, logBean.getPassword());
		
				
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					rb.setName(rs.getString(1));
					rb.setAge(rs.getInt(2));
					rb.setPhoneNumber(rs.getInt(4));
					rb.setLoginId(rs.getString(5));
					
					
				}
				
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
				throw new LoginException(e.getMessage());
				}
			
		return rb;
		
	}
	public boolean registerUser(RegisterBean regBean) throws RegistrationException
	{
		boolean result=false;
		// Do the logic for saving the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try {
    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","dsrc");
				PreparedStatement ps= con.prepareStatement("insert into Registration values(?,?,?,?,?,?,?)");
				ps.setString(1, regBean.getName());
				ps.setInt(2, regBean.getAge());
				ps.setString(3, regBean.getGender());
				ps.setInt(4, regBean.getPhoneNumber());
				ps.setString(5, regBean.getLoginId());
				ps.setString(6, regBean.getPassword());
				ps.setString(7, regBean.getConfirmPassword());
				int res=ps.executeUpdate();
				if(res>0)
				{
					result=true;
				}
		}
				
				catch (Exception e) {
					// TODO Auto-generated catch block
				throw new RegistrationException(e.getMessage());
				}
			
				
    	
		return result;
		
	}
	public  RegisterBean viewProfile(String LoginId) throws ViewProfileException
	{
		return null;
		
		//Do the logic for return the bean filled with the details of the logged in user.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
	/*	try {
			RegisterBean regBean=new RegisterBean();
		    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","dsrc");
				PreparedStatement ps= con.prepareStatement("select*from Registration");
				
				int res=ps.executeUpdate();
				if(res>0)
				{
					result=true;
				}
		}
				
				catch (Exception e) {
					// TODO Auto-generated catch block
				throw new RegistrationException(e.getMessage());
				}
		return null;
	}*/}
	
	public boolean editUser(RegisterBean regBean) throws RegistrationException
	{
		
		// Do the logic for modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		boolean result=false;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","dsrc");
				PreparedStatement ps= con.prepareStatement("update Registration set Name=?,Age=?,Gender=?,PhoneNumber=? where LoginId=?");
				ps.setString(1, regBean.getName());
				ps.setInt(2, regBean.getAge());
				ps.setString(3, regBean.getGender());
				ps.setInt(4, regBean.getPhoneNumber());
				ps.setString(5, regBean.getLoginId());
				//ps.setString(6, regBean.getPassword());
				//ps.setString(7, regBean.getConfirmPassword());
				int res=ps.executeUpdate();
				if(res>0)
				{
					result=true;
				}
		}
				
				catch (Exception e) {
					// TODO Auto-generated catch block
				throw new RegistrationException(e.getMessage());
				}
			
		return result;
		
	}
	public boolean changePassword(ChangePasswordBean cBean) throws RegistrationException
	{
		
	
		boolean b=false;

		// Do the logic for  modifying the records in database.
		// In case of validation Errors , raise your own exception with customized message using ProfileMgmtException class.
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			String LoginId1=cBean.getLoginId();
			String oldPassword = cBean.getOldPassword();
			String Newpass = cBean.getNewPassword();
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","dsrc");
		
		PreparedStatement ps= con.prepareStatement("update Registration set Password=? where LoginId=? and Password=?");
		ps.setString(1, Newpass);
		ps.setString(2, LoginId1);
		ps.setString(3, oldPassword );
		int res=ps.executeUpdate();
		if(res>0)
		{
			b=true;
		}
	}
		catch (Exception e)
		{
		throw new RegistrationException(e.getMessage());
		}
		return b;
	}
}

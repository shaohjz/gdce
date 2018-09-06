package com.isscollege.gdce.service.impl;

import java.sql.SQLException;

import com.isscollege.gdce.dao.IUserDao;
import com.isscollege.gdce.dao.impl.UserDaoImpl;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.service.ILoginService;

public class LoginServiceImpl implements ILoginService
{
	private IUserDao dao;
	
	public LoginServiceImpl()
	{
		dao = new UserDaoImpl(); 
	}
	
	@Override
	public User login(User user)
	{	
		User loginUser = new User();
		
		try
		{
			loginUser = dao.queryUserByName(user.getName());
			if ((loginUser!= null)&&(loginUser.getPassword().equals(user.getPassword())))
			{
				dao.updateUser_loginstate_ByName(user);
				loginUser = dao.queryUserByName(user.getName());
				
				
				return loginUser;
				
			}
		
		}
		catch (SQLException e)
		{
			//loginState = false;
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean logout(User user) {
		boolean loginState = false;
		System.out.println("logintservice ------logout------"+user.getName());
		try
		{
		   loginState = dao.updateUser_loginstate_ByName(user);
		}
		catch (SQLException e)
		{
			loginState = true;
			e.printStackTrace();
		}		
		return loginState;
	}
	
	@Override
	public boolean ajaxValidateLoginname(String name)
	{
		try 
		{
			return dao.ajaxValidateLoginname(name);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean ajaxValidateLoginpassword(String name,String password)
	{
		try 
		{
			return dao.ajaxValidateLoginpassword(name,password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean ajaxValidateLoginState(String name)
	{
		try 
		{
			return dao.ajaxValidateLoginState(name);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}

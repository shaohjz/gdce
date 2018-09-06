package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.IUserDao;
import com.isscollege.gdce.dao.impl.UserDaoImpl;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.service.IRegisterService;

public class RegisterServiceImpl implements IRegisterService 
{
	private IUserDao dao;
	
	public RegisterServiceImpl()
	{
		dao = new UserDaoImpl();
	}

	@Override
	public boolean addCompany(Company company)
	{
		try 
		{
			return dao.insertCompany(company);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false; 
		}
	}
	
	@Override
	public boolean addUser(User user)
	{
		try 
		{
			return dao.insertUser(user);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean ajaxValidateLoginname(String name)
	{
		try 
		{
			if(dao.ajaxValidateLoginname(name)==false)
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean ajaxValidateCompanyId(String companyId)
	{
		try 
		{
			return dao.ajaxValidateCompanyId(companyId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean addManager(User user) throws SQLException
	{
		if (dao.queryUserByName(user.getName()) == null)
		{
			return dao.addManager(user);
		}
		return false;
	}

	@Override
	public List<User> queryManager() throws SQLException 
	{
		return dao.queryManager();
	}

	@Override
	public int queryLevelById(String id) throws SQLException
	{
		return dao.queryLevelById(id);
	}

	@Override
	public boolean deleteManager(String id) throws SQLException
	{
		return dao.deleteManager(id);
	}
	
	@Override
	public Company queryCompanyByCompanyID(String companyId)  throws SQLException
	{
		return dao.queryCompanyByCompanyID(companyId);
	}

	@Override
	public boolean updateCompanyByCompany(Company company) throws SQLException {
		return dao.updateCompany(company);
	}

}

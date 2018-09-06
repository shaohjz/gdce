package com.isscollege.gdce.model.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.IRegisterModel;
import com.isscollege.gdce.service.IRegisterService;
import com.isscollege.gdce.service.impl.RegisterServiceImpl;

public class RegisterModelImpl implements IRegisterModel 
{
	private IRegisterService service;

	public RegisterModelImpl()
	{
		service = new RegisterServiceImpl();
	}

	@Override
	public boolean addUser(User user)
	{
		return service.addUser(user);
	}
	
	@Override
	public boolean addCompany(Company company)
	{
		return service.addCompany(company);
	}
	
	@Override
	public boolean  ajaxValidateLoginname(String name)
	{
		return service.ajaxValidateLoginname(name);
	}
	
	@Override
	public boolean  ajaxValidateCompanyId(String companyId)
	{
		return service.ajaxValidateCompanyId(companyId);
	}
	
	@Override
	public boolean addManager(User user) throws SQLException
	{
		return service.addManager(user);
	}

	@Override
	public List<User> queryManager() throws SQLException
	{
		return service.queryManager();
	}

	@Override
	public boolean deleteManager(String id) throws SQLException
	{
		int level = -1;
		level = service.queryLevelById(id);
		if (level == -1)
		{
			return false;
		}
		if (level == 0 || level == 2 || level == 3 || level == 4)
		{
			return false;
		}
		
		return service.deleteManager(id);

	}
	
	@Override
	public Company queryCompanyByCompanyID(String companyId) throws SQLException {
		return service.queryCompanyByCompanyID(companyId);
	}

	@Override
	public boolean updateCompany(Company company) throws SQLException {
		return service.updateCompanyByCompany(company);
	}
}

package com.isscollege.gdce.model;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.domain.Company;
import java.sql.SQLException;
import java.util.List;

public interface IRegisterModel 
{
	boolean addUser(User user);
	boolean addCompany(Company company);
	
	boolean ajaxValidateLoginname(String name);
	boolean ajaxValidateCompanyId(String companyId);
	
	boolean addManager(User user) throws SQLException;
	List<User> queryManager() throws SQLException;
	boolean deleteManager(String id) throws SQLException;
	
	Company queryCompanyByCompanyID(String companyId) throws SQLException;
	boolean updateCompany(Company company) throws SQLException;  
}

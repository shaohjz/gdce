package com.isscollege.gdce.service;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.User;
import java.sql.SQLException;
import java.util.List;

public interface IRegisterService 
{
    boolean addUser(User user);
    boolean addCompany(Company company);
    
    boolean ajaxValidateLoginname(String name);
    boolean ajaxValidateCompanyId(String companyId);
    
    boolean addManager(User user) throws SQLException; 
    List<User> queryManager() throws SQLException;
    int queryLevelById(String id) throws SQLException;
	boolean deleteManager(String id) throws SQLException;
	
	Company queryCompanyByCompanyID(String companyId)  throws SQLException;
	boolean updateCompanyByCompany(Company company) throws SQLException;
}

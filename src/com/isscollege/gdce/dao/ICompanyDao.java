package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;

public interface ICompanyDao
{
	public boolean save(Company company) throws SQLException;

	public boolean update(Company company) throws SQLException;

	public Company queryCompanyByCompanyID(String Companyid) throws SQLException;

	List<Company> queryCompanyByReviewState(int page, int size) throws SQLException;

	void updateCompanyReviewState(int companyId, int curStats) throws SQLException;

}

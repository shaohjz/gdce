package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.ICompanyDao;
import com.isscollege.gdce.domain.Company;

public class CompanyDaoImpl extends BasicDao implements ICompanyDao
{

	private static String SAVE = "INSERT INTO tbl_company_info (companyId,companyName,legalPerson,phoneNumber,bankAccount, openLicenseId, openLicensePath,taxRegisterId,reviewState) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static String UPDATE = "UPDATE tbl_company_info SET companyName = ?,legalPerson = ?,phoneNumber = ?,bankAccount = ?,openLicenseId = ?, openLicensePath = ?,taxRegisterId = ?,reviewState = ? "
			+ "WHERE  companyId= ? ";

	private static String QUERY_COMPANY_BYCOMID1 = "SELECT companyName,legalPerson,phoneNumber,bankAccount, openLicenseId, openLicensePath,taxRegisterId,reviewState "
			+ "WHERE companyId = ? ";
	private static String QUERY_COMPANY_BYCOMID = "SELECT * FROM tbl_company_info " + "WHERE companyId = '%s'";
	private static final String QUERY_UNREVIEW_COMPANY = "SELECT * FROM tbl_company_info WHERE reviewState=0 ORDER BY companyId ASC LIMIT %d,%d";
	private static final String UPDATE_COMPANY_REVIEW_STATE = "UPDATE tbl_company_info SET reviewState=%d WHERE companyId=%d";

	@Override
	public boolean save(Company company) throws SQLException
	{
		int state = this.insert(SAVE,
				new Object[] { company.getCompanyId(), company.getCompanyName(), company.getLegalPerson(),
						company.getPhoneNumber(), company.getBankAccount(), company.getOpenLicenseId(),
						company.getOpenLicensePath(), company.getTaxRegisterId(), company.getReviewState() });
		return state > 0 ? true : false;
	}

	@Override
	public boolean update(Company company) throws SQLException
	{
		int state = this.update(UPDATE,
				new Object[] { company.getCompanyName(), company.getLegalPerson(), company.getPhoneNumber(),
						company.getBankAccount(), company.getOpenLicenseId(), company.getOpenLicensePath(),
						company.getTaxRegisterId(), company.getReviewState(), company.getCompanyId() });
		return state > 0 ? true : false;
	}

	@Override
	public Company queryCompanyByCompanyID(String companyId) throws SQLException
	{
		// Company company = (Company)this.query(companyId,
		// QUERY_COMPANY_BYCOMID);
		List<Company> companylist = this.query(String.format(QUERY_COMPANY_BYCOMID, companyId), Company.class);
		return companylist.size() > 0 ? companylist.get(0) : null;
		// return company == null ? null : company;
	}

	@Override
	public List<Company> queryCompanyByReviewState(int page, int size) throws SQLException
	{
		List<Company> companyList = null;
		try
		{
			companyList = this.query(String.format(QUERY_UNREVIEW_COMPANY, page, size), Company.class);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return companyList;
	}

	@Override
	public void updateCompanyReviewState(int companyId, int curStats) throws SQLException
	{
		try
		{
			this.update(String.format(UPDATE_COMPANY_REVIEW_STATE, curStats, companyId), null);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

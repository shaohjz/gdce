package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.IReportDao;
import com.isscollege.gdce.dao.impl.ReportDaoImpl;
import com.isscollege.gdce.dao.impl.TradeDaoImpl;
import com.isscollege.gdce.dao.impl.UserDaoImpl;
import com.isscollege.gdce.domain.CoalSalesReport;


import com.isscollege.gdce.service.IReportService;


public class ReportServiceImpl implements IReportService {
	private IReportDao dao;
	public ReportServiceImpl()
	{
		dao = new ReportDaoImpl();
		
	}
	public CoalSalesReport getReportInfo(String date,String type) throws SQLException 
	{
		CoalSalesReport coal = dao.getReportInfo(date,type);
		return coal;
	}
	
}
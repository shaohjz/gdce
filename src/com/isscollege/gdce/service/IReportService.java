package com.isscollege.gdce.service;

import java.sql.SQLException;

import com.isscollege.gdce.domain.CoalSalesReport;

public interface IReportService {
	 CoalSalesReport getReportInfo(String date,String type) throws SQLException ;
	
}

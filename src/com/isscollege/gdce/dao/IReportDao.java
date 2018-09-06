package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.CoalSalesReport;
import com.isscollege.gdce.domain.Product;

public interface IReportDao {
	public CoalSalesReport getReportInfo(String date, String type) throws SQLException ;

	
}

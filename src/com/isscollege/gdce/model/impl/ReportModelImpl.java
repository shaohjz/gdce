package com.isscollege.gdce.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isscollege.gdce.domain.CoalSalesReport;
import com.isscollege.gdce.model.IReportModel;
import com.isscollege.gdce.service.IReportService;
import com.isscollege.gdce.service.impl.ReportServiceImpl;
import com.isscollege.gdce.service.impl.TradeServiceImpl;

public class ReportModelImpl implements IReportModel
{
	private IReportService service;

	public ReportModelImpl()
	{
		service = new ReportServiceImpl();
	}

	public List<CoalSalesReport> getReportInfo(String date)
	{
		String[] productTypes = { "ªÏ√∫", "∫÷√∫", "µÁ√∫", "—Ã√∫", "ƒ≠√∫", "Œﬁ—Ã√∫" };// ProductType√∫÷÷Œ™ªÏ√∫°¢∫÷√∫°¢µÁ√∫°¢—Ã√∫°¢ƒ≠√∫°¢Œﬁ—Ã√∫£ª
		List<CoalSalesReport> reportList = new ArrayList<CoalSalesReport>();
		for (int i = 0; i < productTypes.length; i++)
		{
			try
			{
				service.getReportInfo(date, productTypes[i]);
				reportList.add(service.getReportInfo(date, productTypes[i]));

			} catch (SQLException e)
			{

				e.printStackTrace();
				return null;
			}

		}
		return reportList;
	}

}

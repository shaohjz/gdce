package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.isscollege.gdce.common.dao.impl.BasicDao;

import com.isscollege.gdce.dao.IReportDao;
import com.isscollege.gdce.domain.CoalSalesReport;

public class ReportDaoImpl extends BasicDao implements IReportDao
{
	public CoalSalesReport getReportInfo(String month, String productType) throws SQLException
	{
		String queryReportsql = "SELECT SUM(tbl_product_info.quantity) AS sumquantity,	SUM(tbl_order_info.tradePrice) AS sumprice FROM tbl_product_info "
				+ "INNER JOIN tbl_order_info ON tbl_product_info.productId = tbl_order_info.productId WHERE  productState = 1 "
				+ "AND productType = '" + productType + "' AND tbl_order_info.endDate LIKE '" + month + "'";
		CoalSalesReport coalReport = new CoalSalesReport();
		String sumPrice = "sumprice";
		String sumQuantity = "sumquantity";
		Object sumPriceResult = this.query(sumPrice, queryReportsql);
		double price = NumberUtils.toDouble(ObjectUtils.toString(sumPriceResult, ""));
		coalReport.setSumPrice(price);
		
		Object sumQuantityResult = this.query(sumQuantity, queryReportsql);
		double quantity =NumberUtils.toDouble(ObjectUtils.toString(sumQuantityResult,""));
		coalReport.setSumQuantity(quantity);
		return coalReport;
	}
}

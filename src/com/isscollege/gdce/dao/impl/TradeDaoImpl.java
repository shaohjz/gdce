package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.ITradeDao;
import com.isscollege.gdce.domain.Product;

public class TradeDaoImpl extends BasicDao implements ITradeDao
{
	int PRODUCT_STATE = 2;// PRODUCT_STATE=2代表商品状态为锁定

	@Override
	public List<Product> getProductInfo(int productId) throws SQLException
	{
		String queryProductsql = "SELECT * FROM tbl_product_info WHERE productId = " + productId;
		List<Product> product = this.query(queryProductsql, Product.class);
		return product;
	}

	public Object getPhoneNumber(int productId) throws SQLException
	{
		String queryCompanysql = "SELECT phoneNumber FROM tbl_company_info WHERE companyId = ( SELECT companyId FROM system_users WHERE NAME = ( SELECT userName FROM tbl_product_info WHERE productId =  "
				+ productId + "  ) ) ";
		String telephoneNumber = "phoneNumber";
		String phoneNumber =(String) this.query(telephoneNumber, queryCompanysql);
		return phoneNumber;
	}

	public boolean updateProductState(int productId) throws SQLException
	{
		String updateProductsql = "UPDATE tbl_product_info SET productState = ? WHERE productId = ? ";
		int state = this.update(updateProductsql, new Object[] { PRODUCT_STATE, productId });
		return state != 0;
	}

}

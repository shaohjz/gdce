package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.IProductDao;
import com.isscollege.gdce.domain.Product;

public class ProductDaoImpl extends BasicDao implements IProductDao
{
	private static final String DELETE_PRODUCT = "Delete FROM tbl_product_info where id='%s';";
	private static final String INSERT_INTO_PRODUCTINFO = "INSERT INTO tbl_product_info(productType, srcAddress,destAddress,price,quantity,endDate,fullMoisture,"
			+ "fullSulfur,volatiles,transactionMode,lowPower,remark,productId,createDate,userName,productState,reviewState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String QUERY_UNREVIEW_PRODUCT = "SELECT * FROM tbl_product_info WHERE reviewState=0 ORDER BY id ASC LIMIT %d,%d";
	private static final String UPDATE_PRODUCT_REVIEW_STATE = "UPDATE tbl_product_info SET reviewState=%d WHERE productId=%d";
	
	private static final String UPDATE_PRODUCT="Update tbl_product_info set  productType=?,"
			+ " srcAddress=?, destAddress=?, price=?, quantity=?,  endDate=?, fullMoisture=?, fullSulfur=?,"
			+ "volatiles=?, transactionMode=?, lowPower=?, remark=?, productState=?,reviewState=? where id=%d";
	
	private static final String sql = "Select * FROM tbl_product_info;";

	@Override
	public int insertProduct(Product product) throws SQLException
	{
		int state = this.insert(INSERT_INTO_PRODUCTINFO, new Object[]
		{ product.getProductType(), product.getSrcAddress(), product.getDestAddress(), product.getPrice(),
				product.getQuantity(), product.getEndDate(), product.getFullMoisture(), product.getFullSulfur(),
				product.getVolatiles(), product.getTransactionMode(), product.getLowPower(), product.getRemark(),
				product.getproductId(), product.getCreateDate(), product.getUserName(), product.getProductState(),
				product.getReviewState() });
		return state;
	}


	public List queryProduct(Product product) throws SQLException
	{
		List productList = this.query(sql, product.getClass());
		return productList;
	}

	@Override
	public boolean updateProduct(Product product) throws SQLException
	{
		String s = String.format(UPDATE_PRODUCT,product.getId() );
		Object[] updaProduct = new Object[]
		{  product.getProductType(),
				product.getSrcAddress(), product.getDestAddress(), product.getPrice(), product.getQuantity(),
				product.getEndDate(), product.getFullMoisture(), product.getFullSulfur(),
				product.getVolatiles(), product.getTransactionMode(), product.getLowPower(),
				 product.getRemark(),product.getProductState(),product.getReviewState() };
		int state = this.update(s, updaProduct);
		return state > 0 ? true : false;
	}



	public boolean deleteProduct(Product product) throws SQLException
	{
		Object[] Id = new Object[product.getId()];
		int state = this.delete(DELETE_PRODUCT, Id);
		return state > 0 ? true : false;
	}


	@Override
	public List<Product> queryProductByReviewState(int page, int size) throws SQLException
	{
		return this.query(String.format(QUERY_UNREVIEW_PRODUCT, page, size), Product.class);
	}

	@Override
	public void updateProductReviewState(int productId, int curStats) throws SQLException
	{
		this.update(String.format(UPDATE_PRODUCT_REVIEW_STATE, curStats, productId), null);
	}

	@Override
	public List<Product> getResult() throws SQLException
	{
		List<Product> productList = this.query(sql, Product.class);
		return productList;
	}
}

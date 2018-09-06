package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.IOrderDao;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;

public class OrderDaoImpl extends BasicDao implements IOrderDao
{
	// 订单详情sql
	private static final String QUERY_ORDER_DETAIL = "SELECT orderId"
			+ ",buyerCompanyId,sellerCompanyId,productId,tradePrice"
			+ ",orderState FROM tbl_order_info WHERE orderId='%s'";
	private static final String QUERY_PRODUCT = "SELECT productId,price"
			+ ",quantity,productType,srcAddress"
			+ ",destAddress FROM tbl_product_info WHERE productId='%d'";
	private static final String QUERY_BUYERCOMPANY = "SELECT CompanyName"
			+ ",phoneNumber FROM tbl_Company_info WHERE CompanyId='%s'";
	private static final String QUERY_SELLERCOMPANY = "SELECT CompanyName"
			+ ",phoneNumber FROM tbl_Company_info WHERE CompanyId='%s'";

	// 订单查询sql
	// 查询部分全部订单用于分页
	private static final String QUERY_ORDER_BUYER = "SELECT orderId,createDate"
			+ ",tradePrice,orderState FROM gdce.tbl_order_info "
			+ "WHERE buyerCompanyId='%s' LIMIT %d,8;";
	
	private static final String QUERY_ORDER_SELLER = "SELECT orderId,createDate"
			+ ",tradePrice,orderState FROM gdce.tbl_order_info "
			+ "WHERE sellerCompanyId='%s' LIMIT %d,8;";

	// 查询全部订单用于确定页数
	private static final String QUERY_ORDER_ALL_BUYER = "SELECT orderId FROM gdce.tbl_order_info "
			+ "WHERE orderId LIKE '%s' AND buyerCompanyId='%s'";
	
	private static final String QUERY_ORDER_ALL_SELLER = "SELECT orderId FROM gdce.tbl_order_info "
			+ "WHERE orderId LIKE '%s' AND sellerCompanyId='%s'";
	// 查询指定订单，模糊查询
	private static final String QUERY_APPOINTED_ORDER_BUYER = "SELECT orderId"
			+ ",createDate,tradePrice,orderState,buyerCompanyId FROM tbl_order_info "
			+ "WHERE orderId LIKE '%s' AND buyerCompanyId='%s' LIMIT %d,8";
	
	private static final String QUERY_APPOINTED_ORDER_SELLER = "SELECT orderId"
			+ ",createDate,tradePrice,orderState,buyerCompanyId FROM tbl_order_info "
			+ "WHERE orderId LIKE '%s' AND sellerCompanyId='%s' LIMIT %d,8";

	// 上传回执单sql
	private static final String UPDATE_RECEIPTPATH = "UPDATE tbl_order_info"
			+ " SET receiptPath = ? Where orderId= ?";
	private static final String QUERY_COMPANY_ID_BY_ORDER_ID = "SELECT orderId"
			+ ",buyerCompanyId,productId FROM tbl_order_info "
			+ "WHERE orderId='%s'";

	// 订单创建sql
	private static final String QUERY_XPRODUCT = "SELECT productId,productType,srcAddress,destAddress,price,quantity FROM tbl_product_info WHERE productId='%s'";
	private static final String QUERY_COMPANY = "select * from tbl_company_info where companyId='%s'";
	private static final String INSERT_ORDER = "INSERT INTO tbl_order_info(orderId, tradePrice,productId,buyerCompanyId,sellerCompanyId,orderState,receiptPath,createDate,endDate) VALUES(?, ?, ?, ?,?,?,?,?,?);";
	
	//运单sql
	private static final String WAYBILL_PRODUCE = "	INSERT INTO tbl_waybill_info(waybillId"
			+ ",waybillCompanyId,createTime,endTime,orderId"
			+ ",waybillState) VALUES (?,?,?,?,?,?)";

	@Override
	public List<Order> queryOrderByPage(int page, String permission, String companyId) throws SQLException
	{
		if(permission.equals("3"))
		{
			String sql = String.format(QUERY_ORDER_SELLER, companyId, page);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
		else
		{
			String sql = String.format(QUERY_ORDER_BUYER, companyId, page);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
	}

	@Override
	public List<Order> queryOrder(String orderId, String permission, String companyId) throws SQLException
	{
		if(permission.equals("3"))
		{
			String sql = String.format(QUERY_ORDER_ALL_SELLER, "%" + orderId + "%", companyId);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
		else
		{
			String sql = String.format(QUERY_ORDER_ALL_BUYER, "%" + orderId + "%", companyId);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
		
	}

	@Override
	public Order queryOrderByOrderId(String orderId) throws SQLException
	{
		String sql = String.format(QUERY_ORDER_DETAIL, orderId);
		List<Order> orderList = this.query(sql, Order.class);
		return orderList.size() > 0 ? orderList.get(0) : null;
	}

	@Override
	public Product queryProductByProductId(Order order) throws SQLException
	{
		String sql = String.format(QUERY_PRODUCT, order.getProductId());
		List<Product> productList = this.query(sql, Product.class);
		return productList.size() > 0 ? productList.get(0) : null;
	};

	@Override
	public Company queryBuyerByCompanyId(Order order) throws SQLException
	{
		String sql = String.format(QUERY_BUYERCOMPANY,
				order.getBuyerCompanyId());
		List<Company> buyerList = this.query(sql, Company.class);
		return buyerList.size() > 0 ? buyerList.get(0) : null;
	}

	@Override
	public Company querySellerByCompanyId(Order order) throws SQLException
	{
		String sql = String.format(QUERY_SELLERCOMPANY,
				order.getSellerCompanyId());
		List<Company> sellerList = this.query(sql, Company.class);
		return sellerList.size() > 0 ? sellerList.get(0) : null;
	}

	@Override
	public List<Order> queryAppointedOrderByOrderId(String orderId, int page, String permission, String companyId)
			throws SQLException
	{
		if(permission.equals("3"))
		{
			String sql = String.format(QUERY_APPOINTED_ORDER_SELLER, "%" + orderId + "%", companyId, page);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
		else
		{
			String sql = String.format(QUERY_APPOINTED_ORDER_BUYER, "%" + orderId + "%", companyId, page);
			List<Order> orderList = this.query(sql, Order.class);
			return orderList;
		}
		
	}

	@Override
	public boolean updateReceiptPath(Order order) throws SQLException
	{
		int state = this.update(UPDATE_RECEIPTPATH,
				new Object[] { order.getReceiptPath(), order.getOrderId() });
		System.out.println(state);
		return state > 0 ? true : false;
	}
	
	@Override
	public Order queryCompanyIdByOrderId(String orderId) throws SQLException
	{
		String s = String.format(QUERY_COMPANY_ID_BY_ORDER_ID, orderId);
		List<Order> orderList = this.query(s, Order.class);
		return orderList.size() > 0 ? orderList.get(0) : null;
	}

	@Override
	public Product queryProductByProductId(int productId) throws SQLException
	{
		// TODO Auto-generated method stub
		List<Product> productList = this
				.query(String.format(QUERY_XPRODUCT, productId), Product.class);
		return productList.size() > 0 ? productList.get(0) : null;
	}

	@Override
	public Company queryCompanyByCompanyId(String companyId) throws SQLException
	{
		// TODO Auto-generated method stub
		List<Company> companyList = this
				.query(String.format(QUERY_COMPANY, companyId), Company.class);
		return companyList.size() > 0 ? companyList.get(0) : null;
	}

	@Override
	public boolean insertOrder(Order order) throws SQLException
	{
		// TODO Auto-generated method stub
		int state = this.insert(INSERT_ORDER,
				new Object[] { order.getOrderId(), order.getTradePrice(),
						order.getProductId(), order.getBuyerCompanyId(),
						order.getSellerCompanyId(), order.getOrderState(),
						order.getReceiptPath(), order.getCreateDate(),
						order.getEndDate() });
		return state > 0 ? true : false;
	}
	
	@Override
	public boolean insertWaybill(WaybillInfo waybill) throws SQLException
	{
		// TODO Auto-generated method stub
		int state = this.insert(WAYBILL_PRODUCE,
				new Object[] { waybill.getWaybillId(),
							waybill.getWaybillCompanyId(),
							waybill.getCreateTime(),
							waybill.getEndTime(),
							waybill.getOrderId(),
							waybill.getWaybillState() });
		return state>0 ? true:false;
	}
}

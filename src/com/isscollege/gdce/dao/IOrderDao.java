package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;

public interface IOrderDao
{
	// 使用orderId查询订单表，得到订单详情页所需的信息
	Order queryOrderByOrderId(String orderId) throws SQLException;

	// 使用productId查询产品表，得到订单详情页所需的信息
	Product queryProductByProductId(Order order) throws SQLException;

	// 使用CompanyId查询企业表，得到订单详情页所需的买方信息
	Company queryBuyerByCompanyId(Order order) throws SQLException;

	// 使用CompanyId查询企业表，得到订单详情页所需的卖方信息
	Company querySellerByCompanyId(Order order) throws SQLException;

	// 查询当前用户的订单，存在分页，传入page参数以查看不同页
	List<Order> queryOrderByPage(int page, String permission, String companyId) throws SQLException;

	// 查询当前用户的所有订单
	List<Order> queryOrder(String orderId, String permission, String companyId) throws SQLException;

	// 查询指定orderId的订单
	List<Order> queryAppointedOrderByOrderId(String orderId, int page, String permission, String companyId) throws SQLException;
	
	boolean updateReceiptPath(Order order) throws SQLException;
	
	//查询CompanyId
	Order queryCompanyIdByOrderId(String orderId) throws SQLException;
	
	//使用productId查询产品表，得到订单详情页所需的产品信息
	Product queryProductByProductId(int productId) throws SQLException;
	
	//使用companyId查询产品表，得到订单详情页所需的企业信息
	Company queryCompanyByCompanyId(String companyId) throws SQLException;
	
	//在数据库中插入成功生成的订单
	boolean insertOrder(Order order) throws SQLException;
	
	//运单生成存入数据库
	boolean insertWaybill(WaybillInfo waybill) throws SQLException;
}

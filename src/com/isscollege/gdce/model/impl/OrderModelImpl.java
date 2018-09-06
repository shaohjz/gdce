package com.isscollege.gdce.model.impl;

import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.model.IOrderModel;
import com.isscollege.gdce.service.IOrderService;
import com.isscollege.gdce.service.impl.OrderServiceImpl;

public class OrderModelImpl implements IOrderModel
{
	private IOrderService service;
	
	public OrderModelImpl()
	{
		service = new OrderServiceImpl();
	}
	
	@Override
	public List<Order> queryOrderOnPage(int page, String permission, String companyId)
	{
		return service.queryOrderOnPage(page, permission, companyId);
	}
	
	@Override
	public List<Order> queryOrderAll(String orderId, String permission, String companyId)
	{
		return service.queryOrderAll(orderId, permission, companyId);
	}

	@Override
	public Order queryOrder(String orderId)
	{
		return service.queryOrder(orderId);
	}

	@Override
	public Product queryProduct(Order order)
	{
		return service.queryProduct(order);
	}

	@Override
	public Company queryBuyer(Order order)
	{
		return service.queryBuyer(order);
	}

	@Override
	public Company querySeller(Order order)
	{
		return service.querySeller(order);
	}

	@Override
	public List<Order> queryAppointedOrder(String orderId, int page, String permission, String companyId)
	{
		return service.queryAppointedOrder(orderId, page, permission, companyId);
	}
	
	@Override
	public boolean updateReceiptPath(Order order)
	{
		// TODO Auto-generated method stub
		
		return service.updateReceiptPath(order);
	}
	
	@Override
	public boolean orderCreate(Order order)
	{
		// TODO Auto-generated method stub
		return service.orderCreate(order);
	}
	@Override
	public Product queryProduct(int productId)
	{
		return service.queryProduct(productId);
	}

	@Override
	public Company queryCompany(String companyId)
	{
		return service.queryCompany(companyId);
	}
	
	@Override
	public Order queryCompanyIdByOrderId(String orderId)
	{
		return service.queryCompanyIdByOrderId(orderId);
	}
	
	@Override
	public boolean insertWayBill(WaybillInfo waybill)
	{
		return service.insertWayBill(waybill);
	}
}

package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isscollege.gdce.dao.IOrderDao;
import com.isscollege.gdce.dao.impl.OrderDaoImpl;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.service.IOrderService;

public class OrderServiceImpl implements IOrderService
{
	private IOrderDao dao;
	
	public OrderServiceImpl()
	{
		dao = new OrderDaoImpl();
	}
	
	@Override
	public List<Order> queryOrderOnPage(int page, String permission, String companyId)
	{
		try
		{
			return dao.queryOrderByPage(page, permission, companyId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return new ArrayList<Order>();
		}
	}
	
	@Override
	public List<Order> queryOrderAll(String orderId, String permission, String companyId)
	{
		try
		{
			return dao.queryOrder(orderId, permission, companyId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return new ArrayList<Order>();
		}
	}

	@Override
	public Order queryOrder(String orderId)
	{
		try
		{
			return dao.queryOrderByOrderId(orderId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product queryProduct(Order order)
	{
		try
		{
			return dao.queryProductByProductId(order);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Company queryBuyer(Order order)
	{
		try
		{
			return dao.queryBuyerByCompanyId(order);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Company querySeller(Order order)
	{
		try
		{
			return dao.querySellerByCompanyId(order);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Order> queryAppointedOrder(String orderId, int page, String permission, String companyId)
	{
		try
		{
			return dao.queryAppointedOrderByOrderId(orderId, page, permission, companyId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return new ArrayList<Order>();
		}
	}
	
	@Override
	public boolean updateReceiptPath(Order order)
	{
		try
		{
			return dao.updateReceiptPath(order);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean orderCreate(Order order)
	{
		try 
		{
			return dao.insertOrder(order);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product queryProduct(int productId)
	{
		try 
		{
			return dao.queryProductByProductId(productId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Company queryCompany(String companyId)
	{
		try 
		{
			return dao.queryCompanyByCompanyId(companyId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Order queryCompanyIdByOrderId(String orderId)
	{
		try 
		{
			return dao.queryCompanyIdByOrderId(orderId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean insertWayBill(WaybillInfo waybill)
	{
		try 
		{
			return dao.insertWaybill(waybill);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}

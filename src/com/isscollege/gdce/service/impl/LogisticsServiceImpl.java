package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.ILogisticsDao;
import com.isscollege.gdce.dao.impl.LogisticsDaoImpl;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.LogisticsInfo;
import com.isscollege.gdce.domain.LogisticsPrice;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.service.ILogisticsService;
import com.isscollege.gdce.domain.Order;

public class LogisticsServiceImpl implements ILogisticsService
{
	ILogisticsDao dao;

	public LogisticsServiceImpl()
	{
		dao = new LogisticsDaoImpl();
	}

	public List<WaybillInfo> queryWaybillByState(String state,String userid)
	{
		try
		{
			return dao.queryWaybillByState(state,userid);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<WaybillInfo> queryWaybillByTwoState(String state,String state1,String userid)
	{
		try
		{
			return dao.queryWaybillByTwoState(state,state1,userid);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<WaybillInfo> queryWaybillOnPage(int Page,String state,String userid)
	{
		try
		{
			return dao.queryWaybillOnPage(Page,state,userid);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<WaybillInfo> queryWaybillOnPageByTwoState(int Page,String state,String state1,String userid)
	{
		try
		{
			return dao.queryWaybillOnPageByTwoState(Page,state,state1,userid);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<LogisticsPrice> priceGuide(String startingPlace, String destination, double weight) throws SQLException
	{
		List<LogisticsPrice> logisticsPriceslist = dao.countCost(startingPlace, destination, weight);
		return logisticsPriceslist;
	}

	@Override
	public Company queryCompanyInfo(String waybillCompanyid) throws SQLException
	{
		Company company = new Company();
		company = dao.queryCompanyBywaybillCompanyid(waybillCompanyid);
		return company;
	}

	@Override
	public List<Double> sumcost(List<LogisticsPrice> logisticspricelist, double weight)
	{
		List<Double> totalprices = dao.getsumcost(logisticspricelist, weight);
		return totalprices;
	}

	@Override
	public List<LogisticsInfo> queryLogisticsInfo(String waybillId) throws SQLException
	{
		return dao.queryLogisticsByWaybillId(waybillId);
	}

	@Override
	public WaybillInfo queryWaybillInfoByWaybillId(String waybillId) throws SQLException
	{
		return dao.queryWaybillInfoByWaybillId(waybillId);
	}

	@Override
	public Product queryProductByOrderId(String orderId) throws SQLException
	{
		return dao.queryProductByOrderId(orderId);
	}
	
	@Override
	public boolean updateWaybillState(String Cstate,String waybillid)throws SQLException
	{
		try
		{
			return dao.updateWaybillState(Cstate,waybillid);	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
			
	} 
	
	public boolean insertLogisticsInfo(LogisticsInfo logisticsInfo)
	{
		try
		{
			return dao.insertLogisticsInfo(logisticsInfo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateOrderState(int changeState,String orderId)
	{
		try
		{
			return dao.updateOrderState(changeState,orderId);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String queryWaybillByOrderId(String orderId) throws SQLException
	{
		String waybillId = dao.queryWaybillByOrderId(orderId);
		return waybillId;
	}
	
	public List<Order> queryOrderAll(String userid)
	{
		try 
		{
			return dao.queryOrderAll(userid);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Order> queryOrderOnPage(int page, String userid) {
		try 
		{
			return dao.queryOrderOnPage(page,userid);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

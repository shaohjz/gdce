package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.LogisticsInfo;
import com.isscollege.gdce.domain.LogisticsPrice;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.domain.Order;

public interface ILogisticsDao
{
	List<WaybillInfo> queryWaybillOnPage(int Page,String state,String userid) throws SQLException;
	
	List<WaybillInfo> queryWaybillOnPageByTwoState(int Page,String state,String state1,String userid) throws SQLException;
	
	List<WaybillInfo> queryWaybillByState(String state,String userid) throws SQLException;
	
	List<WaybillInfo> queryWaybillByTwoState(String state,String state1,String userid) throws SQLException;

	Company queryCompanyBywaybillCompanyid(String waybillCompanyid) throws SQLException;

	List<LogisticsPrice> countCost(String startingPlace, String destination, double weight) throws SQLException;

	List<Double> getsumcost(List<LogisticsPrice> logisticspricelist, double weight);

	List<LogisticsInfo> queryLogisticsByWaybillId(String waybillId) throws SQLException;

	WaybillInfo queryWaybillInfoByWaybillId(String waybillId) throws SQLException;

	Product queryProductByOrderId(String orderId) throws SQLException;
	
	public boolean updateWaybillState(String Cstate,String waybillid)throws SQLException;
	
	boolean insertLogisticsInfo(LogisticsInfo logisticsInfo) throws SQLException;
	
	boolean updateOrderState(int changeState,String orderId) throws SQLException;

	String queryWaybillByOrderId(String companyId) throws SQLException;;
	
	List<Order> queryOrderAll(String userid) throws SQLException;

	List<Order> queryOrderOnPage(int page, String userid) throws SQLException;
}

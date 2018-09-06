package com.isscollege.gdce.model;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.LogisticsInfo;
import com.isscollege.gdce.domain.LogisticsPrice;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.domain.Order;

public interface ILogisticsModel
{

	List<WaybillInfo> queryWaybillOnPage(int Page, String state, String userid);

	List<WaybillInfo> queryWaybillOnPageByTwoState(int Page, String state, String state1, String userid);

	List<WaybillInfo> queryWaybillByState(String state, String userid);

	List<WaybillInfo> queryWaybillByTwoState(String state, String state1, String userid);

	List<LogisticsPrice> priceGuide(String startingPlace, String destination, double weight) throws SQLException;

	Company queryCompanyInfo(String waybillCompanyid) throws SQLException;

	List<Double> sumcost(List<LogisticsPrice> logisticspricelist, double weight);

	List<LogisticsInfo> queryLogisticsInfo(String waybillId) throws SQLException;

	WaybillInfo queryWaybillInfoByWaybillId(String waybillId) throws SQLException;

	Product queryProductByOrderId(String orderId) throws SQLException;

	public boolean updateWaybillState(String Cstate, String waybillid) throws SQLException;

	boolean insertLogisticsInfo(LogisticsInfo logisticsInfo);

	boolean updateOrderState(int changeState, String orderId);

	String queryWaybillByOrderId(String orderId) throws SQLException;

	List<Order> queryOrderAll(String userid);

	List<Order> queryOrderOnPage(int page, String userid);
}

package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.ILogisticsDao;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.LogisticsInfo;
import com.isscollege.gdce.domain.LogisticsPrice;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;
import com.isscollege.gdce.domain.Order;

public class LogisticsDaoImpl extends BasicDao implements ILogisticsDao
{

	private static final String QUERY_WAYBILLONPAGE = "SELECT * FROM tbl_waybill_info where "
			+ "(waybillState = '%s' and waybillCompanyId  ='%s' )limit %d,9";
	private static final String QUERY_WAYBILLONPAGEBYTWOSTATE = "SELECT * FROM tbl_waybill_info where "
			+ "(waybillState = '%s' or waybillState = '%s')and waybillCompanyId  ='%s' limit %d,9";
	private static final String QUERY_WAYBILLBYSTATE = "SELECT * FROM tbl_waybill_info where"
			+ " waybillState = '%s'and waybillCompanyId  ='%s'";
	private static final String QUERY_WAYBILLBYTWOSTATE = "SELECT * FROM tbl_waybill_info where "
			+ "(waybillState = '%s' or waybillstate = '%s')and waybillCompanyId  ='%s'";
	private static final String UPDATE_WAYBILLSTATE = "UPDATE tbl_waybill_info SET waybillState = ? Where waybillId= ?";
	private static final String UPDATE_ORDERSTATE = "UPDATE tbl_order_info SET orderState = ? WHERE orderId = ?";
	private static final String QUERY_ORDERONPAGE = "SELECT * FROM tbl_order_info"
			+ " where (sellerCompanyId = '%s'or buyerCompanyId='%s') limit %d,9";
	private static final String QUERY_ORDERALL = "SELECT * FROM tbl_order_info"
			+ " where sellerCompanyId = '%s'or buyerCompanyId='%s'";

	private static String QUERY_LOGISTICS_PRICE = "SELECT" + " waybillCompanyId,startingPlace,destination,weight,price"
			+ " FROM tbl_static_logistics_price WHERE startingPlace='%s'" + " AND destination='%s'";

	private static String QUERY_COMP_BY_COMPId = "SELECT * FROM tbl_company_info WHERE companyId='%s'";

	private static String QUERY_LG_INFO_BY_WBID = "SELECT * FROM tbl_logistics_info WHERE waybillId='%s'";

	private static String QUERY_WB_INFO_BY_WBID = "SELECT * FROM tbl_waybill_info WHERE waybillId='%s'";

	private static String QUERY_PRODUCTID = "SELECT productId FROM tbl_order_info  WHERE orderId='%s'";

	private static String QUERY_PRO_BY_PROID = "SELECT * FROM tbl_product_info  WHERE productId='%s'";

	private static final String INSERT_LOGISTICSINFO = "INSERT INTO tbl_logistics_info"
			+ "(waybillId,updateDate,submitUser,location,content) VALUES(?,?,?,?,?)";

	private static String QUERY_WB_INFO_BY_ORDERID = "SELECT waybillId FROM tbl_waybill_info WHERE orderId='%s'";

	public List<WaybillInfo> queryWaybillOnPage(int Page, String state, String userid) throws SQLException

	{
		List<WaybillInfo> waybill = this.query(String.format(QUERY_WAYBILLONPAGE, state, userid, Page),
				WaybillInfo.class);
		return waybill;
	}

	public List<WaybillInfo> queryWaybillOnPageByTwoState(int Page, String state, String state1, String userid)
			throws SQLException
	{
		List<WaybillInfo> waybill = this
				.query(String.format(QUERY_WAYBILLONPAGEBYTWOSTATE, state, state1, userid, Page), WaybillInfo.class);
		return waybill;
	}

	public List<WaybillInfo> queryWaybillByState(String state, String userid) throws SQLException
	{
		List<WaybillInfo> waybill = this.query(String.format(QUERY_WAYBILLBYSTATE, state, userid), WaybillInfo.class);
		return waybill;
	}

	public List<WaybillInfo> queryWaybillByTwoState(String state, String state1, String userid) throws SQLException
	{
		List<WaybillInfo> waybill = this.query(String.format(QUERY_WAYBILLBYTWOSTATE, state, state1, userid),
				WaybillInfo.class);
		return waybill;
	}

	@Override
	public List<LogisticsPrice> countCost(String startingPlace, String destination, double weight) throws SQLException
	{
		String sql = String.format(QUERY_LOGISTICS_PRICE, startingPlace, destination);
		List<LogisticsPrice> logisticspricelist;

		logisticspricelist = this.query(sql, LogisticsPrice.class);
		for (int i = 0; i < logisticspricelist.size();)
		{
			String str_weight = logisticspricelist.get(i).getWeight();

			double logistics_weight = Double.parseDouble(str_weight.substring(2));
			String str = str_weight.substring(0, 2);

			if ((weight > logistics_weight && str.equals("<=")) || (weight <= logistics_weight && str.equals(">=")))
			{
				logisticspricelist.remove(i);
				i--;
			}
			i++;
		}
		return logisticspricelist.size() > 0 ? logisticspricelist : null;
	}

	@Override
	public Company queryCompanyBywaybillCompanyid(String waybillCompanyid) throws SQLException
	{
		String sql = String.format(QUERY_COMP_BY_COMPId, waybillCompanyid);
		List<Company> companylist = this.query(sql, Company.class);
		return companylist.size() > 0 ? companylist.get(0) : null;
	}

	@Override
	public List<Double> getsumcost(List<LogisticsPrice> logisticspricelist, double weight)
	{
		List<Double> totalpriceslist = new ArrayList<>();
		DecimalFormat dl = new DecimalFormat("0.00");
		for (int i = 0; i < logisticspricelist.size(); i++)
		{
			double money = Double.parseDouble(dl.format(logisticspricelist.get(i).getPrice() * weight * 10000));
			totalpriceslist.add(money);
		}
		return totalpriceslist.size() > 0 ? totalpriceslist : null;
	}

	@Override
	public List<LogisticsInfo> queryLogisticsByWaybillId(String waybillId) throws SQLException
	{
		String sql = String.format(QUERY_LG_INFO_BY_WBID, waybillId);
		List<LogisticsInfo> logisticsinfolist = this.query(sql, LogisticsInfo.class);
		return logisticsinfolist.size() > 0 ? logisticsinfolist : null;
	}

	@Override
	public WaybillInfo queryWaybillInfoByWaybillId(String waybillId) throws SQLException
	{
		String sql = String.format(QUERY_WB_INFO_BY_WBID, waybillId);
		List<WaybillInfo> waybililnfolist = this.query(sql, WaybillInfo.class);
		return waybililnfolist.size() > 0 ? waybililnfolist.get(0) : null;
	}

	@Override
	public Product queryProductByOrderId(String orderId) throws SQLException
	{
		int productId = (int) this.query("productId", String.format(QUERY_PRODUCTID, orderId));
		List<Product> Productlist = this.query(String.format(QUERY_PRO_BY_PROID, productId), Product.class);
		return Productlist.size() > 0 ? Productlist.get(0) : null;
	}

	@Override
	public boolean updateWaybillState(String Cstate, String waybillid) throws SQLException
	{
		int result = this.update(UPDATE_WAYBILLSTATE, new Object[] { Cstate, waybillid });
		System.out.println(result);
		return result > 0 ? true : false;
	}

	public boolean insertLogisticsInfo(LogisticsInfo logisticsInfo) throws SQLException
	{
		int state = this
				.insert(INSERT_LOGISTICSINFO,
						new Object[] { logisticsInfo.getWaybillId(), logisticsInfo.getUpdateDate(),
								logisticsInfo.getSubmitUser(), logisticsInfo.getLocation(),
								logisticsInfo.getContent() });
		return state > 0 ? true : false;
	}

	public boolean updateOrderState(int changeState, String orderId) throws SQLException
	{
		int result = this.update(UPDATE_ORDERSTATE, new Object[] { changeState, orderId });
		return result > 0 ? true : false;
	}

	@Override
	public String queryWaybillByOrderId(String orderid) throws SQLException
	{
		List<WaybillInfo> waybillinfo = this.query(String.format(QUERY_WB_INFO_BY_ORDERID, orderid), WaybillInfo.class);
		return waybillinfo.size()>0? waybillinfo.get(0).getWaybillId():"";
	}

	public List<Order> queryOrderAll(String userid) throws SQLException
	{
		List<Order> orderlist = this.query(String.format(QUERY_ORDERALL, userid, userid), Order.class);
		return orderlist;
	}

	@Override
	public List<Order> queryOrderOnPage(int page, String userid) throws SQLException
	{
		List<Order> orderlist = this.query(String.format(QUERY_ORDERONPAGE, userid, userid, page), Order.class);
		return orderlist;
	}
}

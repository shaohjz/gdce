package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;

public interface IOrderDao
{
	// ʹ��orderId��ѯ�������õ���������ҳ�������Ϣ
	Order queryOrderByOrderId(String orderId) throws SQLException;

	// ʹ��productId��ѯ��Ʒ���õ���������ҳ�������Ϣ
	Product queryProductByProductId(Order order) throws SQLException;

	// ʹ��CompanyId��ѯ��ҵ���õ���������ҳ���������Ϣ
	Company queryBuyerByCompanyId(Order order) throws SQLException;

	// ʹ��CompanyId��ѯ��ҵ���õ���������ҳ�����������Ϣ
	Company querySellerByCompanyId(Order order) throws SQLException;

	// ��ѯ��ǰ�û��Ķ��������ڷ�ҳ������page�����Բ鿴��ͬҳ
	List<Order> queryOrderByPage(int page, String permission, String companyId) throws SQLException;

	// ��ѯ��ǰ�û������ж���
	List<Order> queryOrder(String orderId, String permission, String companyId) throws SQLException;

	// ��ѯָ��orderId�Ķ���
	List<Order> queryAppointedOrderByOrderId(String orderId, int page, String permission, String companyId) throws SQLException;
	
	boolean updateReceiptPath(Order order) throws SQLException;
	
	//��ѯCompanyId
	Order queryCompanyIdByOrderId(String orderId) throws SQLException;
	
	//ʹ��productId��ѯ��Ʒ���õ���������ҳ����Ĳ�Ʒ��Ϣ
	Product queryProductByProductId(int productId) throws SQLException;
	
	//ʹ��companyId��ѯ��Ʒ���õ���������ҳ�������ҵ��Ϣ
	Company queryCompanyByCompanyId(String companyId) throws SQLException;
	
	//�����ݿ��в���ɹ����ɵĶ���
	boolean insertOrder(Order order) throws SQLException;
	
	//�˵����ɴ������ݿ�
	boolean insertWaybill(WaybillInfo waybill) throws SQLException;
}

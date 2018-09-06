package com.isscollege.gdce.service;

import java.util.List;

import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.Order;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.WaybillInfo;

public interface IOrderService
{
	// ��ѯ�������õ���������ҳ�������Ϣ
	Order queryOrder(String orderId);

	// ��ѯ��Ʒ���õ���������ҳ�������Ϣ
	Product queryProduct(Order order);

	// ��ѯ��ҵ���õ���������ҳ���������Ϣ
	Company queryBuyer(Order order);

	// ��ѯ��ҵ���õ���������ҳ�����������Ϣ
	Company querySeller(Order order);

	// ��ѯ�������õ��˸���ǰ���������ڷ�ҳ��һҳ�˸���
	List<Order> queryOrderOnPage(int page, String permission, String companyId);

	// ��ѯ������õ���������
	List<Order> queryOrderAll(String orderId, String permission, String companyId);

	// ��ѯ�������õ�ָ��������ŵĶ���
	List<Order> queryAppointedOrder(String orderId, int page, String permission, String companyId);
	
	boolean updateReceiptPath(Order orderId);
	
	//ִ�ж�����������
	boolean orderCreate(Order order);

	//������Ʒ��Ų�ѯ��Ʒ��Ϣ
	Product queryProduct(int productId);

	//������ҵ��Ų�ѯ��ҵ��Ϣ
	Company queryCompany(String companyId);
	
	//���ݶ�����Ų�ѯ CompanyId
	Order queryCompanyIdByOrderId(String orderId);
	
	//�˵�
	boolean insertWayBill(WaybillInfo waybill);
}

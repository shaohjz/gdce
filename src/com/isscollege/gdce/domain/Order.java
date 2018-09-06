package com.isscollege.gdce.domain;

public class Order
{
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getOrderId()
	{
		return orderId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	public float getTradePrice()
	{
		return tradePrice;
	}
	public void setTradePrice(float tradePrice)
	{
		this.tradePrice = tradePrice;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public String getBuyerCompanyId()
	{
		return buyerCompanyId;
	}
	public void setBuyerCompanyId(String buyerCompanyId)
	{
		this.buyerCompanyId = buyerCompanyId;
	}
	public String getSellerCompanyId()
	{
		return sellerCompanyId;
	}
	public void setSellerCompanyId(String sellerCompanyId)
	{
		this.sellerCompanyId = sellerCompanyId;
	}
	public int getOrderState()
	{
		return orderState;
	}
	public void setOrderState(int orderState)
	{
		this.orderState = orderState;
	}
	public String getReceiptPath()
	{
		return receiptPath;
	}
	public void setReceiptPath(String receiptPath)
	{
		this.receiptPath = receiptPath;
	}
	public String getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	private int id;
	// ������(ʱ���+������ҵ���������ź���λ��2018080110034455)
	private String orderId; 
	private float tradePrice;		//���׽��
	private int productId;  		//��Ʒ���
	private String buyerCompanyId; 		//�򷽱�ţ���Ӧ��ҵ��ţ�
	private String sellerCompanyId;		//������ţ���Ӧ��ҵ��ţ�
	private int orderState; //����״̬��0-������ 1-������ 2-���ջ� 3-������ 4-��ɣ�
	//��ִ�����·����/imgs/order/receipt/��ұ�ţ�����λ��+�������
	private String receiptPath;  
	private String createDate;	//����ʱ��
	private String endDate;		//����ʱ�䣨Ĭ��15�������գ�
}

package com.isscollege.gdce.domain;

public class LogisticsPrice
{

	// ��ҵ��������
	private String waybillCompanyId;
	// ��ʼ��
	private String startingPlace;
	// Ŀ�ĵ�
	private String destination;
	// ����
	private String weight;
	// �۸�
	private int price;

	public String getWaybillCompanyId()
	{
		return waybillCompanyId;
	}

	public void setWaybillCompanyId(String waybillCompanyId)
	{
		this.waybillCompanyId = waybillCompanyId;
	}

	public String getStartingPlace()
	{
		return startingPlace;
	}

	public void setStartingPlace(String startingPlace)
	{
		this.startingPlace = startingPlace;
	}

	public String getDestination()
	{
		return destination;
	}

	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public String getWeight()
	{
		return weight;
	}

	public void setWeight(String weight)
	{
		this.weight = weight;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

}

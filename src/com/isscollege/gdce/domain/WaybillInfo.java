package com.isscollege.gdce.domain;

public class WaybillInfo
{
	// �˵���
	private String waybillId;
	// ��ҵ��������
	private String waybillCompanyId;
	// ����ʱ��
	private String createTime;
	// ����ʱ��
	private String endTime;
	// ������
	private String orderId;
	// �˵�״̬
	private String waybillState;

	public String getWaybillId()
	{
		return waybillId;
	}

	public void setWaybillId(String waybillId)
	{
		this.waybillId = waybillId;
	}

	public String getWaybillCompanyId()
	{
		return waybillCompanyId;
	}

	public void setWaybillCompanyId(String waybillCompanyId)
	{
		this.waybillCompanyId = waybillCompanyId;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getOrderId()
	{
		return orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getWaybillState()
	{
		return waybillState;
	}

	public void setWaybillState(String waybillState)
	{
		this.waybillState = waybillState;
	}

}

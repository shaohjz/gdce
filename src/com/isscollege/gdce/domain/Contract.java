package com.isscollege.gdce.domain;

public class Contract
{
	// ����
	private long id;
	// ��ͬ���
	private long contractId;
	// �򷽱��
	private String buyerCompanyId;
    //�������
	private String sellerCompanyId;
	//��Ʒ���
	private long productId;
	//�򷽺�ͬ״̬(true-��ǩ false-δǩ)
	private boolean buyerContractState;
	//������ͬ״̬(true-��ǩ false-δǩ)
	private boolean sellerContractState;
	//����ʱ��
	private String createDate;
	//����ʱ��
	private String endDate;
	
	public Contract()
	{
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public long getContractId()
	{
		return contractId;
	}

	public void setContractId(long contractId)
	{
		this.contractId = contractId;
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

	public long getProductId()
	{
		return productId;
	}

	public void setProductId(long productId)
	{
		this.productId = productId;
	}

	public boolean isBuyerContractState()
	{
		return buyerContractState;
	}

	public void setBuyerContractState(boolean buyerContractState)
	{
		this.buyerContractState = buyerContractState;
	}

	public boolean isSellerContractState()
	{
		return sellerContractState;
	}

	public void setSellerContractState(boolean sellerContractState)
	{
		this.sellerContractState = sellerContractState;
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


}

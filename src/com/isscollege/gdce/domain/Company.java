package com.isscollege.gdce.domain;

public class Company
{
	// ��ҵ��������
	private String companyId;
	// ��ҵ����
	private String companyName;
	// ����
	private String legalPerson;
	// ��ϵ��ʽ
	private String phoneNumber;
	// �����˻�
	private String bankAccount;
	// Ӫҵִ��
	private String openLicenseId;
	// Ӫҵִ�մ��·����/imgs/openLicense/��ҵ��������+ʱ�����
	private String openLicensePath;
	// ˰��ǼǺ�
	private String taxRegisterId;
	// ���״̬ 0-����� 1-ͨ�� 2-δͨ��
	private int reviewState;

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getLegalPerson()
	{
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson)
	{
		this.legalPerson = legalPerson;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getBankAccount()
	{
		return bankAccount;
	}

	public void setBankAccount(String bankAccount)
	{
		this.bankAccount = bankAccount;
	}

	public String getOpenLicenseId()
	{
		return openLicenseId;
	}

	public void setOpenLicenseId(String openLicenseId)
	{
		this.openLicenseId = openLicenseId;
	}

	public String getOpenLicensePath()
	{
		return openLicensePath;
	}

	public void setOpenLicensePath(String openLicensePath)
	{
		this.openLicensePath = openLicensePath;
	}

	public String getTaxRegisterId()
	{
		return taxRegisterId;
	}

	public void setTaxRegisterId(String taxRegisterId)
	{
		this.taxRegisterId = taxRegisterId;
	}

	public int getReviewState()
	{
		return reviewState;
	}

	public void setReviewState(int reviewState)
	{
		this.reviewState = reviewState;
	}

}

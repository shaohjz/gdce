package com.isscollege.gdce.domain;

public class User
{
	// �û����
	private long id;
	// �û�����
	private String name;
	// �û�����
	private String password;
	//�û����� /*0-���� 1-����Ա 2-��Ա*/
	private int level;
	//�û�Ȩ��
	private String permission; 
	//��ҵ��������
	private String  companyId ;

	//�Ƿ��ס����
	private boolean isRemember;
	// ��¼״̬
	private boolean loginState = false;

	public User()
	{
	}

	public User(String name, String password, boolean isRemember)
	{
		this.name = name;
		this.password = password;
		this.isRemember = isRemember;
		
	}

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public boolean isRemember()
	{
		return this.isRemember;
	}

	public void setRemember(boolean isRemember)
	{
		this.isRemember = isRemember;
	}

	public boolean isLoginState()
	{
		return this.loginState;
	}

	public void setLoginState(boolean loginState)
	{
		this.loginState = loginState;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", level=" + level + ", permission="
				+ permission + ", companyId=" + companyId + ", isRemember=" + isRemember + ", loginState=" + loginState
				+ "]";
	}
	
}
